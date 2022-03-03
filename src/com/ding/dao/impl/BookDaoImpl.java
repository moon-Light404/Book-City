package com.ding.dao.impl;

import com.ding.dao.BookDao;
import com.ding.pojo.Book;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(name,author,price,stock,type) values(?,?,?,?,?)";

        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getStock(),book.getType());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id =?";
        return update(sql,id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set name = ?,author = ?,price = ?,stock = ?,type = ? where id = ?";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getStock(),book.getType(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select * from t_book where id = ?";
        return queryForOne(Book.class,sql,id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select * from t_book";
        return queryForList(Book.class,sql);
    }

    /**
     * 分页中所有的记录数 查询特定得语句得到总记录数
     * @return
     */
    @Override
    public int queryForPageTotalCount(String sql,Object... args) {
        Number cnt = (Number) queryForSingleValue(sql,args);
        return cnt.intValue();
    }

    /**
     *
     * @param sql
     * @param args
     * @return
     */
    @Override
    public List<Book> queryForPageItems(String sql,Object... args) {
        return queryForList(Book.class,sql,args);
    }

//    /**
//     * 根据价格查询一页数据
//     * @param begin
//     * @param pageSize
//     * @param min
//     * @param max
//     * @return
//     */
//    @Override
//    public List<Book> queryForPageItemsByPrice(int begin, int pageSize,int min,int max) {
//        String sql = "select * from t_book where price between ? and ? order by price limit ?,? ";
//        return queryForList(Book.class,sql,min,max,begin,pageSize);
//    }


}
