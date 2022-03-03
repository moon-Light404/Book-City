package com.ding.dao;

import com.ding.pojo.Book;
import com.ding.pojo.Order;

import java.util.List;

public interface OrderDao {
    /**
     * 在订单数据库表中查找是否该用户买过这本书
     * @param bookId 书的id唯一的
     * @param username 用户的账号
     * @return
     */
    public Order queryBookByIdAnName(Integer bookId, String username);

    /**
     * 更新订单,修改订单中购买该书的数量
     * @param order
     * @return
     */
    public int updateOrder(Order order);

    /**
     * 当该书是这个用户没有买过的时候，就要添加订单记录
     * @param order
     * @return
     */
    public int addOrder(Order order);

    public int deleteOrderById(Integer id);

    public Order queryOrderById(Integer id);

    /**
     * 查询该用户所有的订单即买的书籍
     * @param username
     * @return
     */
    public List<Order> queryOrders(String username);
}
