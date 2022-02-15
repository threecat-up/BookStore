<%--
  Created by IntelliJ IDEA.
  User: jhu
  Date: 2020/10/5
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临书店</span>
    <a href="client/orderServlet?action=myOrders">我的订单</a>
    <a href="pages/user/userinfo.jsp">个人信息</a>
    <a href="client/bookServlet?action=pageOrder">热榜</a>
    <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
    <a href="index.jsp">返回</a>
</div>