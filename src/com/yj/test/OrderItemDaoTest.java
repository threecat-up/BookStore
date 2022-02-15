package com.yj.test;

import com.yj.bean.OrderItem;
import com.yj.dao.OrderItemDao;
import com.yj.dao.impl.OrderItemDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author yj
 * @create 2020-08-28 13:23
 */
public class OrderItemDaoTest {
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    @Test
    public void saveOrderItem() {

        orderItemDao.saveOrderItem(new OrderItem(1,"salfj",5,new BigDecimal(5),new BigDecimal(50),"123"));
    }

    @Test
    public void showOrderItem() {
        System.out.println(orderItemDao.showOrderItem("15987004865195"));

    }
}