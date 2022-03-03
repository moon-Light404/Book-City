package com.ding.dao.impl;

import com.ding.dao.OrderDao;
import com.ding.pojo.Order;

import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {


    @Override
    public Order queryBookByIdAnName(Integer bookId, String username) {
        String sql = "select * from t_order where bookId = ? and username = ? ";
        return queryForOne(Order.class,sql,bookId,username);
    }

    @Override
    public int updateOrder(Order order) {
        String sql = "update t_order set bookName = ?,author = ?,bookType = ?,bookNum = ? where bookId = ? and username = ?";
        return update(sql,order.getBookName(),order.getAuthor(),order.getBookType(),order.getBookNum(),order.getBookId(),
                order.getUsername());
    }

    @Override
    public int addOrder(Order order) {
        String sql = "insert into t_order(username,bookId,bookName,author,bookType,bookNum) values(?,?,?,?,?,?)";
        return update(sql,order.getUsername(),order.getBookId(),order.getBookName(),order.getAuthor(),order.getBookType(),
                order.getBookNum());
    }

    @Override
    public int deleteOrderById(Integer id) {
        String sql = "delete from t_order where id = ?";
        return update(sql,id);
    }

    @Override
    public Order queryOrderById(Integer id) {
        String sql = "select * from t_order where id = ?";
        return queryForOne(Order.class,sql,id);
    }

    @Override
    public List<Order> queryOrders(String username) {
        String sql = "select * from t_order where username = ?";
        return queryForList(Order.class,sql,username);
    }
}
