<%--
  Created by IntelliJ IDEA.
  User: jhu
  Date: 2020/10/5
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>500</title>
    <%@include file="/pages/common/header.jsp"%>
</head>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif" >
    <span class="wel_word">500error</span>

</div>
<div id="main">
    <table>
        <tr>
            <td style="width: 300px">HTTP状态 500 - 内部服务器错误</td>
        </tr>
        <tr>
            <td>
                <a href="index.jsp" style="size: 300px;color: red">返回首页</a>
            </td>
        </tr>
    </table>
</div>


<!-- 这是页脚的引入 -->
<%@ include file="/pages/common/footer.jsp" %>

</body>
</html>
