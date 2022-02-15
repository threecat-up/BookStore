package com.yj.dao;

import com.yj.bean.Order;

import java.util.List;

/**
 * @author yj
 * @create 2020-08-28 10:57
 */
public interface OrderDao {

    public int saveOrder(Order order);

    public List<Order> queryAllOrders();

    public void updateOrderStatus(int i, String orderId);

    public List<Order> queryMyOrders(int userId);

}
