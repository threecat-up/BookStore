package com.yj.test;

import com.yj.bean.Cart;
import com.yj.bean.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author yj
 * @create 2020-08-26 20:30
 */
public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"lkjs",1,new BigDecimal(5),new BigDecimal(66)));
        cart.addItem(new CartItem(1,"lkjs",1,new BigDecimal(5),new BigDecimal(66)));
        cart.addItem(new CartItem(2,"你妹的",1,new BigDecimal(5),new BigDecimal(66)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"lkjs",1,new BigDecimal(5),new BigDecimal(66)));
        cart.addItem(new CartItem(1,"lkjs",1,new BigDecimal(5),new BigDecimal(66)));
        cart.addItem(new CartItem(2,"你妹的",1,new BigDecimal(5),new BigDecimal(66)));
        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"lkjs",1,new BigDecimal(5),new BigDecimal(66)));
        cart.addItem(new CartItem(1,"lkjs",1,new BigDecimal(5),new BigDecimal(66)));
        cart.addItem(new CartItem(2,"你妹的",1,new BigDecimal(5),new BigDecimal(66)));
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"lkjs",1,new BigDecimal(5),new BigDecimal(66)));
        cart.addItem(new CartItem(1,"lkjs",1,new BigDecimal(5),new BigDecimal(66)));
        cart.addItem(new CartItem(2,"你妹的",1,new BigDecimal(5),new BigDecimal(66)));
        cart.updateCount(1,5);
        System.out.println(cart);
    }
}