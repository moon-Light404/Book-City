package com.ding.test;

import com.ding.dao.BookDao;
import com.ding.dao.impl.BookDaoImpl;
import com.ding.pojo.Book;
import com.ding.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {

    private BookDao bookDao = new BookDaoImpl();
    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"三国演义","罗贯中",new BigDecimal(120),12,"历史"));
    }

    @Test
    public void deleteBookById() {
    }

    @Test
    public void updateBook() {
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(3));
    }

    @Test
    public void queyryBooks() {
    }

    @Test
    public void queryForPageTotalCount() {
        int min = 30;
        int max = 100;
        String s1 = min + "";
        String s2 = max + "";
        System.out.println(bookDao.queryForPageTotalCount("select count(*) from t_book where price between "+" "+s1+" and "+s2));
    }

//    @Test
//    public void queryForPageItems() {
//        System.out.println(bookDao.queryForPageItems(8,4));
//    }



}