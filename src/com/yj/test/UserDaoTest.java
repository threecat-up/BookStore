package com.yj.test;

import com.yj.bean.User;
import com.yj.dao.UserDao;
import com.yj.dao.impl.UserDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yj
 * @create 2020-08-21 15:14
 */
public class UserDaoTest {

        UserDao userDao = new UserDaoImpl();
    @Test
    public void querybyUsername() {
        if(userDao.querybyUsername("yangie")==null) {
            System.out.println("用户名可用");
        } else {
            System.out.println("用户名已存在!");
        }
        //System.out.println(userDao.querybyUsername("yangjie"));
    }

    @Test
    public void querybyUsernameAndPassword() {
        if(userDao.querybyUsernameAndPassword("yangjie","yangjie")==null) {
            System.out.println("密码错误或用户名错误");
        }else {
            System.out.println("登陆成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null,"yangjie","yangjie","wzg168@qq.com")));
    }
}