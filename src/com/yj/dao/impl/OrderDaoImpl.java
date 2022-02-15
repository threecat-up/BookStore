package com.yj.dao.impl;

import com.yj.bean.Order;
import com.yj.dao.OrderDao;

import java.util.List;

/**
 * @author yj
 * @create 2020-08-28 11:06
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {

        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());

    }

    @Override
    public List<Order> queryAllOrders() {
        // 查询所有的订单
        String sql = "select `order_id` AS `orderId`,`create_time`AS `createTime`,`price` AS `price`,`status` AS `status`,`user_id`  AS `userId` FROM t_order";
        // 执行sql语句
        List<Order> orders =  queryForList(Order.class,sql);
        return orders;

    }

    @Override
    public void updateOrderStatus(int status, String orderId) {
        // sql语句
        String sql = "update t_order set status = ? where order_id = ?";
        // 执行sql语句
        update(sql, status, orderId);
    }

    @Override
    public List<Order> queryMyOrders(int userId) {
        // 查询我的订单
        String sql = "select `order_id` AS `orderId`,`create_time`AS `createTime`,`price` AS `price`,`status` AS `status`,`user_id`  AS `userId` FROM t_order where user_id=?";
        // 执行sql语句
        List<Order> orders =  queryForList(Order.class,sql,userId);
        return orders;
    }


}
