package com.yj.web;

import com.yj.bean.Order;
import com.yj.bean.OrderItem;
import com.yj.bean.User;
import com.yj.service.OrderService;
import com.yj.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author yj
 * @create 2020-08-29 19:10
 */
public class ManagerOrderServlet extends BaseServlet{

    private OrderService orderService = new OrderServiceImpl();
    /**
     * 查看所有订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void orders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        // 用户未登录，需要先登录
        if (user == null) {
            // 如果用户没有登录，重定向到登录页面
            resp.sendRedirect(req.getContextPath() + "/pages/user/login.jsp");
        } else {
            // 查询用户的订单信息
            List<Order> orders = orderService.queryAllOrders();
            // 设置订单到域对象中
            req.setAttribute("orders", orders);
            // 转发到订单页面
            req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req, resp);
        }
    }

    protected void sendOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取发货的订单号
        String orderId = request.getParameter("orderId");
        // 发货
        orderService.sendOrder(orderId);

        // 重定向到订单页面
        response.sendRedirect(request.getHeader("referer"));
    }

    protected void showOrderItem(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        //获取前台传输的订单编号和域中的登录对象
        User user = (User) request.getSession().getAttribute("user");
        // 用户未登录，需要先登录
        if (user == null) {
            // 如果用户没有登录，重定向到登录页面
            response.sendRedirect(request.getContextPath() + "/pages/user/login.jsp");
        } else {
            // 查询用户的订单信息
            List<OrderItem> orderItems = orderService.showOrderItem(orderId);
            // 设置订单到域对象中
            request.setAttribute("orderItems", orderItems);
            // 转发到订单页面
            request.getRequestDispatcher("/pages/order/orderItem.jsp").forward(request, response);
        }
    }
}
