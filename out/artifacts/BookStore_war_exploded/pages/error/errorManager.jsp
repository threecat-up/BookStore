<%--
  Created by IntelliJ IDEA.
  User: jhu
  Date: 2020/10/5
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>404</title>
    <%@include file="/pages/common/header.jsp"%>
</head>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif" >
    <span class="wel_word">错误提示</span>

</div>
<div id="main">
    <table>
        <tr>
            <td style="width: 300px">亲，你没有管理员权限哦！</td>
        </tr>
        <tr>
            <td>
                <a href="pages/user/login.jsp" style="size: 300px;color: red">管理员登录</a>
                <a href="index.jsp" style="size: 300px;color: red">返回首页</a>
            </td>
        </tr>
    </table>
</div>


<!-- 这是页脚的引入 -->
<%@ include file="/pages/common/footer.jsp" %>

</body>
</html>
