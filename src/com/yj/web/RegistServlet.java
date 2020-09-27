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
 * @create 2020-08-21 15:52
 */
public class RegistServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException, ServletException {
        //1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String repwd = req.getParameter("repwd");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        //2、检查验证码是否正确 abcde
        if ("abcde".equalsIgnoreCase(code)) {
            //3、检查用户名是否可用
            if (userService.existsUsername(username)) {
                //不可用 跳回注册页面
                req.setAttribute("msg","用户名已存在！");
                req.setAttribute("username",username);
                req.setAttribute("email",email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                //可用 调用service保存到数据库 跳到注册成功页面
                userService.registUser(new User(null, username, password, email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
            } else {
                //不正确 调回注册页面
                req.setAttribute("msg","验证码错误！");
                req.setAttribute("username",username);
                req.setAttribute("password",password);
                req.setAttribute("repwd",repwd);
                req.setAttribute("email",email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            }
     }
}
