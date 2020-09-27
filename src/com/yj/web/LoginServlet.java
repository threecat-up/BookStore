package com.yj.web;

import com.yj.bean.User;
import com.yj.service.UserService;
import com.yj.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yj
 * @create 2020-08-23 9:44
 */
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException, ServletException {
        //1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(userService.login(new User(null,username,password,null))!=null)
        {
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        } else {
            req.setAttribute("msg","用户名或密码错误!");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }
    }
}
