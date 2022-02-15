<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: jhu
  Date: 2020/10/19
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>总账单</title>
    <%@include file="/pages/common/header.jsp"%>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif" >
    <span class="wel_word">总账单</span>

    <!-- 这是manager管理模块的共同菜单  -->
    <%@ include file="/pages/common/manager_menu.jsp" %>

</div>
<%
    String usernumber=request.getParameter("usernumber");
    String ordernumber = request.getParameter("ordernumber");
    String booknumbers = request.getParameter("booknumbers");
    String bigDecimal = request.getParameter("bigDecimal");
%>
<div id="main">
    <table>
        <tr style="color: red">尊敬的管理员：</tr>
        <tr>
            <td colspan="2">截止<%=new Date()%>账单详情：</td>
        </tr>
        <tr>
            <td>用户总数:</td>
            <td>${usernumber}人</td>
        </tr>
        <tr>
            <td>总订单数：</td>
            <td>${ordernumber}单</td>
        </tr>
        <tr>
            <td>销售本数：</td>
            <td>${booknumbers}本</td>
        </tr>
        <tr>
            <td>总收入：</td>
            <td>${bigDecimal}元</td>
        </tr>
    </table>
</div>

<!-- 这是页脚的引入 -->
<%@ include file="/pages/common/footer.jsp" %>

</body>
</html>