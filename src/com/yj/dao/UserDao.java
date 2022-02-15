package com.yj.dao;

import com.yj.bean.User;

import java.util.List;

/**
 * @author yj
 * @create 2020-08-21 11:57
 */
public interface UserDao {

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 如果返回null则没有这个用户，反之亦然
     */
    public User querybyUsername(String username);

    /**
     * 根据用户名和密码查询用户信息
     * @param username
     * @param password
     * @return 如果返回null则说明用户名或密码错误
     */
    public User querybyUsernameAndPassword(String username,String password);

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    public int saveUser(User user);

    public int addUser(User user);

    public int deleteUserById(int i);

    public int updateUser(User user);

    public User queryUserById(Integer id);

    public List<User> queryUsers();

    public Integer queryForPageTotalCount();

    public List<User> queryForPageItems(int begin, int pageSize);
}
