<%--
  Created by IntelliJ IDEA.
  User: jhu
  Date: 2020/10/19
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书热销榜单</title>
    <%@include file="/pages/common/header.jsp"%>

</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo1.jpg" >
    <span class="wel_word">图书热销榜单</span>
    <div>
        <span>欢迎光临书店</span>
        <a href="index.jsp">返回</a>
    </div>
</div>

<div id="main">
    <table style="height: 350px">
        <tr>
            <td>排名</td>
            <td>书名</td>
            <td>价格</td>
            <td>作者</td>
            <td style="color: red">销量</td>
        </tr>
        <%int i=1;%>
        <c:forEach items="${requestScope.page.items}" var="book">
            <tr>
                <td><%=i++%></td>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td style="color: red">${book.sales}</td>
            </tr>
        </c:forEach>



        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    </table>
</div>

<%@include file="/pages/common/footer.jsp"%>
</body>
</html>
