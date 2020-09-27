package com.yj.dao.impl;

import com.yj.bean.OrderItem;
import com.yj.dao.OrderItemDao;

import java.util.List;

/**
 * @author yj
 * @create 2020-08-28 13:10
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(), orderItem.getPrice(),orderItem.getTotalPrice(), orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> showOrderItem(String orderId) {
        String sql = "select `id`,`name`,`count`,`price`,`total_price`AS `totalPrice`,`order_id`AS `orderId` from t_order_item where order_id=?";
        return queryForList(OrderItem.class,sql,orderId);

    }
}
