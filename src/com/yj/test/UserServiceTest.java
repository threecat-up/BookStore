package com.yj.test;

import com.yj.bean.User;
import com.yj.service.UserService;
import com.yj.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yj
 * @create 2020-10-21 18:50
 */
public class UserServiceTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void addUser() {
        userService.addUser(new User(null,"舒胡贤2","kj","1234@qq.com","kjk"));
    }

    @Test
    public void deleteUserById() {
        userService.deleteUserById(3);
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void queryUserById() {
    }

    @Test
    public void queryUsers() {
    }

    @Test
    public void page() {
    }
}