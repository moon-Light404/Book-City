package com.ding.service.impl;

import com.ding.dao.OrderDao;
import com.ding.dao.impl.OrderDaoImpl;
import com.ding.pojo.Order;
import com.ding.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    public OrderDao orderDao = new OrderDaoImpl();
    @Override
    public void addOrder(Order order) {
        orderDao.addOrder(order);
    }

    @Override
    public void updateOrder(Order order) {
        orderDao.updateOrder(order);
    }

    @Override
    public void deleteOrderById(Integer id) {
        orderDao.deleteOrderById(id);
    }

    @Override
    public Order queryOrderById(Integer id) {
        return orderDao.queryOrderById(id);
    }

    @Override
    public Order queryOrderByIdAndName(Integer bookId, String username) {
        return orderDao.queryBookByIdAnName(bookId,username);
    }

    @Override
    public List<Order> queryOrders(String username) {
        return orderDao.queryOrders(username);
    }
}
