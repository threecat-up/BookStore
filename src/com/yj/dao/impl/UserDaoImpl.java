package com.yj.dao.impl;

import com.yj.bean.User;
import com.yj.dao.UserDao;

import java.util.List;

/**
 * @author yj
 * @create 2020-08-21 15:04
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User querybyUsername(String username) {
        String sql = "select `id`,`username`,`password`,`email`,`address` from t_user where username = ?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public User querybyUsernameAndPassword(String username, String password) {
        String sql = "select * from t_user where username = ? and password = ?";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(`username`,`password`,`email`,`address`) values(?,?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getAddress());
    }

    @Override
    public int addUser(User user) {
        String sql = "insert into t_user(`username`,`password`,`email`,`address`) values(?,?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getAddress());
    }

    @Override
    public int deleteUserById(int i) {
        String sql = "delete from t_user where id = ?";
        return update(sql,i);
    }

    @Override
    public int updateUser(User user) {
        String sql = "update t_user set `username`=?,`password`=?,`email`=?,`address`=? where id=?";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getAddress(),user.getId());
    }

    @Override
    public User queryUserById(Integer id) {
        String sql = "select * from t_user where id=?";
        return queryForOne(User.class,sql,id);
    }

    @Override
    public List<User> queryUsers() {
        String sql = "select * from t_user";
        return queryForList(User.class,sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_user";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<User> queryForPageItems(int begin, int pageSize) {
        String sql = "select * from t_user limit ?,?";
        return queryForList(User.class,sql,begin,pageSize);
    }
}
