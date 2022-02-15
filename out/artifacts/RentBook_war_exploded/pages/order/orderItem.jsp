<%--
  Created by IntelliJ IDEA.
  User: jhu
  Date: 2020/10/5
  Time: 0:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>我的订单</title>
    <%@include file="/pages/common/header.jsp"%>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif" >
    <span class="wel_word">我的订单</span>

    <!-- 登录成功之后所有相同的菜单  -->
    <%@ include file="/pages/common/login_success_menu.jsp" %>

</div>

<div id="main">
    <table>
        <tr>
            <td>编号</td>
            <td>书名</td>
            <td>数量</td>
            <td>单价</td>
            <td>总金额</td>
            <td>订单编号</td>
        </tr>
        <c:forEach items="${requestScope.orderItems}" var="order">
            <tr>
                <td>${ order.id}</td>
                <td>${ order.name }</td>
                <td>${ order.count }</td>
                <td>${ order.price }</td>
                <td>${ order.totalPrice }</td>
                <td>${ order.orderId }</td>
            </tr>
        </c:forEach>
    </table>
</div>


<!-- 这是页脚的引入 -->
<%@ include file="/pages/common/footer.jsp" %>

</body>
</html>