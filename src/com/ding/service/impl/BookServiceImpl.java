package com.ding.service.impl;

import com.ding.dao.BookDao;
import com.ding.dao.impl.BookDaoImpl;
import com.ding.pojo.Book;
import com.ding.pojo.Page;
import com.ding.service.BookService;
import com.ding.util.TextUtils;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {

    public BookDao bookDao = new BookDaoImpl(); // 数据库操作
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    /**
     * 求出表中所有的总页数  select * from table，总记录数并返回page
     * @param pageNo 第几页
     * @param pageSize 每页的记录数
     * @return
     */
    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<Book>();


        // 每页的记录数
        page.setPageSize(pageSize);
        // 求总记录数
        int pagetotalCount = bookDao.queryForPageTotalCount("select count(*) from t_book");
        // 设置总记录数
        page.setPageTotalCount(pagetotalCount);
        // 总页码
        int pageTotal = (pagetotalCount % pageSize > 0) ?  pagetotalCount/pageSize+1 : pagetotalCount/pageSize;
        page.setPageTotal(pageTotal);
        if(pageNo < 1){
            pageNo=1;
        }
        if(pageNo > pageTotal){
            pageNo = pageTotal;
        }
        // 设置当前页码
        page.setPageNo(pageNo);
        int begin = (page.getPageNo()-1)*pageSize; // 查询起点
        if(begin < 0){
            begin = 0;
        }
        String sql = "select * from t_book" + " limit " + begin + "," + pageSize;
        // 当前页的数据
        List<Book> items = bookDao.queryForPageItems(sql);
        // 设置当前页数据
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> searchBook(int pageNo, int pageSize, String name,String author, String type, int min, int max) {
        Page<Book> page = new Page<Book>();
        page.setPageSize(pageSize);
        String sql = "select * from t_book where 1=1  ";

        // 查找数量的语句
        String cntSql = "select count(*) from t_book where 1=1";
        List<String> list = new ArrayList<String>();
        // 生成sql语句
        if(!TextUtils.isEmpty(name)){
            sql = sql + " and name like ? ";
            cntSql = cntSql + " and name like ? ";
            list.add("%" + name + "%");
        }
        if(!TextUtils.isEmpty(author)){
            sql = sql + " and author = ? ";
            cntSql = cntSql + " and author =  ? ";
            list.add(author);
        }
        if(!TextUtils.isEmpty(type)){
            sql = sql + " and type = ? ";
            cntSql = cntSql + " and type = ? ";
            list.add(type);
        }
        sql = sql + " and price between " + min + " and " + max+ " order by price ";
        // 这里order by price 按照价格排序
        cntSql = cntSql + " and price between " + min + " and " + max;

        // 总记录数
        int pagetotalCount = bookDao.queryForPageTotalCount(cntSql,list.toArray());
        page.setPageTotalCount(pagetotalCount);

        // 总页码
        int pageTotal = (pagetotalCount % pageSize > 0) ? pagetotalCount/pageSize+1 : pagetotalCount/pageSize;
        page.setPageTotal(pageTotal);

        if(pageNo < 1){
            pageNo = 1;
        }
        if(pageNo > pageTotal){
            pageNo = pageTotal;
        }

        // 设置当前页码
        page.setPageNo(pageNo);
        int begin = (page.getPageNo()-1)*pageSize;
        if(begin < 0){
            begin = 0;
        }
        sql = sql + " limit " + begin + "," + pageSize; // 先设置limit值
        List<Book> items = bookDao.queryForPageItems(sql,list.toArray());
        page.setItems(items);
        return page;
    }
//
//    @Override
//    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
//        Page<Book> page = new Page<Book>();
//
//        // 每页的记录数
//        page.setPageSize(pageSize);
//        // 求总记录数.将整型转换为字符串类型
//        String s1 = min + "";
//        String s2 = max + "";
//        int pagetotalCount = bookDao.queryForPageTotalCount("select count(*) from t_book where price between  "+ s1 +" and "+s2);
//        // 设置总记录数
//        page.setPageTotalCount(pagetotalCount);
//
//        // 总页码
//        int pageTotal = (pagetotalCount % pageSize > 0) ?  pagetotalCount/pageSize+1 : pagetotalCount/pageSize;
//        page.setPageTotal(pageTotal);
//
//        if(pageNo < 1){
//            pageNo=1;
//        }
//        if(pageNo > pageTotal){
//            pageNo = pageTotal;
//        }
//        // 设置当前页码
//        page.setPageNo(pageNo);
//
//        int begin = (page.getPageNo()-1)*pageSize; // 查询起点
//        // 当前页的数据
//        List<Book> items = bookDao.queryForPageItemsByPrice(begin,pageSize,min,max);
//        // 设置当前页数据
//        page.setItems(items);
//
//        return page;
//    }


}
