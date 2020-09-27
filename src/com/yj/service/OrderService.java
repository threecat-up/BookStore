package com.yj.service;

import com.yj.bean.*;

import java.util.List;

/**
 * @author yj
 * @create 2020-08-28 13:59
 */
public interface OrderService {
    /**
     * 创建订单
     * @param cart
     * @param userId
     * @return
     */
    public String createOrder(Cart cart, Integer userId);

    /**
     * 查询所有订单
     * @return
     */
    public List<Order> queryAllOrders();

    public void sendOrder(String orderId);

    public List<Order> queryMyOrders(Integer id);

    public void receivedOrder(String orderId);


    List<OrderItem> showOrderItem(String orderId);
}
