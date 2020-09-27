package com.yj.service.impl;

import com.yj.bean.User;
import com.yj.dao.UserDao;
import com.yj.dao.impl.UserDaoImpl;
import com.yj.service.UserService;

/**
 * @author yj
 * @create 2020-08-21 15:34
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.querybyUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.querybyUsername(username) == null) {
            return false;
        } else {
            return true;
        }
    }
}
