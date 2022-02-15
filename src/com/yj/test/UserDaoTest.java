package com.yj.test;

import com.yj.bean.User;
import com.yj.dao.UserDao;
import com.yj.dao.impl.UserDaoImpl;
import com.yj.service.impl.UserServiceImpl;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.List;

/**
 * @author yj
 * @create 2020-08-21 15:14
 */
public class UserDaoTest {

        UserDao userDao = new UserDaoImpl();
    @Test
    public void querybyUsername() {
        if(userDao.querybyUsername("yan1gjie")==null) {
            System.out.println("用户名可用");
        } else {
            System.out.println("用户名已存在!");
        }
        //System.out.println(userDao.querybyUsername("yangjie"));
    }

    @Test
    public void querybyUsernameAndPassword() {
        if(userDao.querybyUsernameAndPassword("yagjie","yanjie")==null) {
            System.out.println("密码错误或用户名错误");
        }else {
            System.out.println("登陆成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null,"yangjie2","yangjie","wzg168@qq.com","大河湾")));
    }

    @Test
    public void addUser() {
        System.out.println(userDao.addUser(new User(null,"舒胡2贤","123456","123456@qq.com","贵州")));
    }

    @Test
    public void deleteUserById() {
        System.out.println(userDao.deleteUserById(3));
    }

    @Test
    public void updateUser() {
        System.out.println(userDao.updateUser(new User(3,"舒胡贤","123456","123456@qq.com","贵州")));
    }

    @Test
    public void queryUserById() {
        User user = userDao.queryUserById(1);
        System.out.println(user);
    }

    @Test
    public void queryUsers() {
        List<User> users = userDao.queryUsers();
        System.out.println(users);
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(userDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        System.out.println(userDao.queryForPageItems(1,2));
    }
}