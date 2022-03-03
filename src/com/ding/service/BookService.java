package com.ding.service;

import com.ding.pojo.Book;
import com.ding.pojo.Page;

import java.util.List;

public interface BookService {
    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    /**
     * 查询某一页的数据
     * @param pageNo 第几页
     * @param pageSize 每页的记录数
     * @return 该页数据
     */
    public Page<Book> page(int pageNo, int pageSize);

    public Page<Book> searchBook(int pageNo,int pageSize,String name,String author,String type,int min,int max);
}
