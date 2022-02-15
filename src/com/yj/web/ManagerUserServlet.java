package com.yj.web;

import com.yj.bean.Page;
import com.yj.bean.User;
import com.yj.service.UserService;
import com.yj.service.impl.UserServiceImpl;
import com.yj.utils.WebUtils;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author yj
 * @create 2020-10-20 20:34
 */
public class ManagerUserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),0);
        pageNo+=1;
        User user = (User) WebUtils.copyParamToBean(req.getParameterMap(),new User());
        userService.addUser(user);
        //req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req,resp);
        resp.sendRedirect(req.getContextPath() + "/manager/UserServlet?action=page&pageNo="+pageNo);
    }


    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int i = Integer.parseInt(id);
        userService.deleteUserById(i);
        resp.sendRedirect(req.getContextPath() + "/manager/UserServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }


    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) WebUtils.copyParamToBean(req.getParameterMap(),new User());
        userService.updateUser(user);
        resp.sendRedirect(req.getContextPath() + "/manager/UserServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int i = Integer.parseInt(id);
        User user = userService.queryUserById(i);
        req.setAttribute("user",user);
        req.getRequestDispatcher("/pages/manager/user_edit.jsp").forward(req,resp);
    }


    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、通过BookService查询数据
        List<User> user = userService.queryUsers();
        //2、将数据保存在request域中
        req.setAttribute("user",user);
        //3、请求转发到pages/manager/book_manager.jsp
        req.getRequestDispatcher("/pages/manager/user_manager.jsp").forward(req,resp);
    }

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的参数pageNo和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        //2、调用BookService.page(pageNo,pageSize)方法：返回page对象
        Page<User> page = userService.page(pageNo,pageSize);
        page.setUrl("manager/UserServlet?action=page");

        //3、保存Page对象到request域中
        req.setAttribute("page",page);
        //4、请求转发到page/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/user_manager.jsp").forward(req,resp);
    }
}
