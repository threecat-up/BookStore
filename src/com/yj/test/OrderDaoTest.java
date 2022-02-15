package com.yj.test;

import com.yj.dao.OrderDao;
import com.yj.dao.impl.OrderDaoImpl;
import org.junit.Test;

/**
 * @author yj
 * @create 2020-08-29 21:39
 */
public class OrderDaoTest {

    private OrderDao orderDao = new OrderDaoImpl();
    @Test
    public void saveOrder() {
    }

    @Test
    public void queryAllOrders() {
        System.out.println(orderDao.queryAllOrders());
    }

    @Test
    public void updateOrderStatus() {
        orderDao.updateOrderStatus(1,"15987004865195");
    }

    @Test
    public void queryMyOrders() {
        System.out.println(orderDao.queryMyOrders(1));
    }


}