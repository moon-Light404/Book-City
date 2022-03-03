package com.ding.test;

import com.ding.pojo.Page;
import com.ding.service.BookService;
import com.ding.service.impl.BookServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookServiceTest {

    private BookService bookService = new BookServiceImpl();
    @Test
    public void addBook() {
    }

    @Test
    public void deleteBookById() {
    }

    @Test
    public void updateBook() {
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(3));
    }

    @Test
    public void queryBooks() {
    }
    @Test
    public void page(){
        System.out.println(bookService.page(1,4) );
    }

//    @Test
//    public void searchBook(){
//        System.out.println(bookService.searchBook(1,4,"java",null,30,100));
//    }
}