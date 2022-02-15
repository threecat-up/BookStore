package com.yj.dao;

import com.yj.bean.OrderItem;

import java.util.List;

/**
 * @author yj
 * @create 2020-08-28 11:03
 */
public interface OrderItemDao {
    public int saveOrderItem(OrderItem orderItem);

    public List<OrderItem> showOrderItem(String orderId);
}
