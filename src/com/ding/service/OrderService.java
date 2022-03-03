package com.ding.service;

import com.ding.pojo.Book;
import com.ding.pojo.Order;

import java.util.List;

public interface OrderService {

    public void addOrder(Order order);

    public void updateOrder(Order order);

    public void deleteOrderById(Integer id);

    public Order queryOrderById(Integer id);

    public Order queryOrderByIdAndName(Integer bookId,String username);

    public List<Order> queryOrders(String username);
}
