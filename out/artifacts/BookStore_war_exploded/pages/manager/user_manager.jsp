<%--
  Created by IntelliJ IDEA.
  User: jhu
  Date: 2020/10/20
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户管理</title>
    <%@include file="/pages/common/header.jsp"%>
    <script type="text/javascript">
        $(function () {
            //给删除的a标签绑定单击事件，用于删除提示
            $("a.deleteClass").click(function () {
                /**
                 * 返回true表示确认
                 */
                return confirm("你确定要删除【"+$(this).parent().parent().find("td:first").text()+"】用户吗?");

            })
        })
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo1.jpg" >
    <span class="wel_word">用户管理</span>
    <%@include file="/pages/common/manager_menu.jsp"%>
</div>

<div id="main">
    <table style="height: 350px">
        <tr>
            <td>序号</td>
            <td>用户名</td>
            <td>密码</td>
            <td>电子邮箱</td>
            <td>收货地址</td>
            <td colspan="2">操作</td>
        </tr>
        <c:forEach items="${requestScope.page.items}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.email}</td>
                <td>${user.address}</td>
                <td><a href="manager/UserServlet?&action=getUser&id=${user.id}&pageNo=${requestScope.page.pageNo}">修改信息</a></td>
                <td><a class="deleteClass" href="manager/UserServlet?action=delete&id=${user.id}&pageNo=${requestScope.page.pageNo}">删除信息</a></td>
            </tr>
        </c:forEach>



        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/user_edit.jsp?pageNo=${requestScope.page.pageTotal}">添加用户</a></td>
        </tr>
    </table>
    <%@include file="/pages/common/page_nav.jsp"%>
</div>

<%@include file="/pages/common/footer.jsp"%>
</body>
</html>k