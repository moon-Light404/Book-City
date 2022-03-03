package com.ding.dao;

import com.ding.pojo.Book;

import java.io.ObjectStreamException;
import java.util.List;

public interface BookDao {

    /**
     * 添加书籍
     * @param book
     * @return
     */
    public int addBook(Book book);

    /**
     * 通过id删除书籍
     * @param id
     * @return
     */
    public int deleteBookById(Integer id);

    /**
     * 通过id更新修改某个书籍的信息
     * @param book
     * @return
     */
    public int updateBook(Book book);

    /**
     * 通过id查询一本书籍
     * @param id
     * @return
     */
    public Book queryBookById(Integer id);

    /**
     * 查询全部图书
     * @return
     */
    public List<Book> queryBooks();


    /**
     * 返回总记录数
     * @return
     */
    public int queryForPageTotalCount(String sql,Object... args);

    /**
     *
     * @param sql
     * @param args
     * @return
     */
    public List<Book> queryForPageItems(String sql,Object... args);

//    public List<Book> queryForPageItemsByPrice(int begin, int pageSize,int min,int max);
}
