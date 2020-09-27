package com.yj.dao.impl;

import com.yj.bean.User;
import com.yj.dao.UserDao;

/**
 * @author yj
 * @create 2020-08-21 15:04
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User querybyUsername(String username) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username = ?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public User querybyUsernameAndPassword(String username, String password) {
        String sql = "select * from t_user where username = ? and password = ?";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(`username`,`password`,`email`) values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
