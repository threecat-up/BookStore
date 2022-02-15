package com.yj.service;

import com.yj.bean.Book;
import com.yj.bean.Page;
import com.yj.bean.User;

import java.util.List;

/**
 * @author yj
 * @create 2020-08-21 15:29
 */
public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     * @param username
     * @return 返回true表示用户名已存在，返回false表示用户名可用
     */
    public boolean existsUsername(String username);

    public void addUser(User user);

    public void deleteUserById(int i);

    public void updateUser(User user);

    public User queryUserById(Integer id);

    public List<User> queryUsers();

    public Page<User> page(int pageNo, int pageSize);
}
