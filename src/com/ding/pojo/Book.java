package com.ding.pojo;

import java.math.BigDecimal;

public class Book {

    private Integer id; // 图书编号
    private String name; // 图书名称
    private String author; // 图书作者
    private BigDecimal price; // 图书价格
    private Integer stock; // 图书库存
    private String type; // 类型

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Book(){

    }
    public Book(Integer id, String name, String author, BigDecimal price, Integer stock, String type) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.stock = stock;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", type='" + type + '\'' +
                '}';
    }
}
