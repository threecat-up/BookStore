<%--
  Created by IntelliJ IDEA.
  User: jhu
  Date: 2020/10/9
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的个人信息</title>
    <%@include file="/pages/common/header.jsp"%>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color:red;
        }

        input {
            text-align: center;
        }
    </style>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo1.jpg" >
    <span class="wel_word">个人信息</span>
    <%@include file="/pages/common/login_success_menu.jsp"%>
</div>

<div id="main">
    <form action="userServlet" method="post">
        <input type="hidden" name="action" value="update"/>
        <table>
            <tr>
                <td>序号</td>
                <td>用户名</td>
                <td>密码</td>
                <td>电子邮箱</td>
                <td>收货地址</td>
                <td colspan="2">修改</td>
            </tr>
            <tr>
                <td><input name="id" type="text" value="${sessionScope.user.id}"/></td>
                <td><input name="username" type="text" value="${sessionScope.user.username}"/></td>
                <td><input name="password" type="text" value="${sessionScope.user.password}"/></td>
                <td><input name="email" type="text" value="${sessionScope.user.email}"/></td>
                <td><input name="address" type="text" value="${sessionScope.user.address}"/></td>
                <td><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </form>


</div>

<%@include file="/pages/common/footer.jsp"%>
</body>
</html>
