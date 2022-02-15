package com.yj.bean;

/**
 * @author yj
 * @create 2020-10-02 20:12
 */

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车对象
 */
public class Cart {
    //private Integer totalCount;
    //private BigDecimal totalPrice;

    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (Map.Entry<Integer,CartItem>entry : items.entrySet()) {
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }


    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer,CartItem>entry : items.entrySet()) {
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }


    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    /**
     * key是商品编号，value是商品信息
     */
    private Map<Integer,CartItem> items = new LinkedHashMap<Integer, CartItem>();

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }

    /**
     * 添加商品项
     * @param cartItem
     */
    public void addItem(CartItem cartItem) {
        //先查看购物车中是否包含次商品，如果有的话，数量更新，总金额更新；如果没有，直接放到集合中即可
        CartItem item = items.get(cartItem.getId());

        if(item == null) {
            //之前没有添加过此商品
            items.put(cartItem.getId(),cartItem);
        } else {
            item.setCount(item.getCount() + 1);//数量累计
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));//更新总金额
        }
    }

    /**
     * 删除商品项
     * @param  id
     */
    public void deleteItem(Integer id) {
        items.remove(id);
    }

    /**
     * 清空购物车
     */
    public void clear() {
        items.clear();
    }

    /**
     * 修改商品数量
     * @param id
     * @param count
     */
    public void updateCount(Integer id,Integer count) {
        //先查看购物车中是否包含次商品，如果有的话，数量更新，总金额更新；
        CartItem cartItem = items.get(id);

         if(cartItem != null) {
             cartItem.setCount(count);
             cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        }
    }
}
