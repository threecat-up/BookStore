package com.yj.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @author yj
 * @create 2020-08-23 17:01
 */
public class WebUtils {
    /**
     * 快速注入
     * @param value
     * @param bean
     * @return
     */
    public static Object copyParamToBean(Map value, Object bean) {
        try {
            BeanUtils.populate(bean,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String strInt,int defaultValue) {
        int n = 0;
        try {
            n = Integer.parseInt(strInt);
        } catch (Exception e) {
            return defaultValue;
        }
        return n;
    }

}
