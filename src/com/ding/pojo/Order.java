package com.ding.pojo;

public class Order {
    private Integer id; // 记录编号
    private String username; // 用户账号
    private Integer bookId; // 书的id
    private String bookName; // 书名
    private String author; // 书的作者
    private String bookType; // 书的类型
    private Integer bookNum; // 购买的书的数量

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public Integer getBookNum() {
        return bookNum;
    }

    public void setBookNum(Integer bookNum) {
        this.bookNum = bookNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", bookType='" + bookType + '\'' +
                ", bookNum=" + bookNum +
                '}';
    }

    public Order() {

    }

    public Order(Integer id, String username, Integer bookId, String bookName, String author, String bookType, Integer bookNum) {
        this.id = id;
        this.username = username;
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.bookType = bookType;
        this.bookNum = bookNum;
    }
}
