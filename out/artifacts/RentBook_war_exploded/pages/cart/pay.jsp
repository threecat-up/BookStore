<%--
  Created by IntelliJ IDEA.
  User: jhu
  Date: 2020/10/5
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>结算页面</title>
    <%@include file="/pages/common/header.jsp"%>
    <div id="header">
        <img class="logo_img" alt="" src="static/img/logo.jpg" >
        <span class="wel_word">结算</span>
        <%@include file="/pages/common/login_success_menu.jsp"%>
    </div>
</head>
<body>

<div id="main">

    <form action="client/orderServlet?action=createOrder" method="post">
        <input type="hidden">
        <table width="80%">
            <tr>
                <td bgcolor="#F7FEFF" colspan="4">
                    支付金额：<INPUT id="money" TYPE="text" NAME="money" size="6" value="${sessionScope.cart.totalPrice}">元</td>
            </tr>
            <tr>
                <td><br />
                </td>
            </tr>
            <tr>
                <td colspan="4">请您选择在线支付银行</td>
            </tr>
            <tr>
                <td><INPUT TYPE="radio" NAME="pd_FrpId" value="CMBCHINA-NET">招商银行
                </td>
                <td><INPUT TYPE="radio" NAME="pd_FrpId" value="ICBC-NET">工商银行</td>
                <td><INPUT TYPE="radio" NAME="pd_FrpId" value="ABC-NET">农业银行</td>
                <td><INPUT TYPE="radio" NAME="pd_FrpId" value="CCB-NET">建设银行
                </td>
            </tr>
            <tr>
                <td><INPUT TYPE="radio" NAME="pd_FrpId" value="CMBC-NET">中国民生银行总行</td>
                <td><INPUT TYPE="radio" NAME="pd_FrpId" value="CEB-NET">光大银行
                </td>
                <td><INPUT TYPE="radio" NAME="pd_FrpId" value="BOCO-NET">交通银行</td>
                <td><INPUT TYPE="radio" NAME="pd_FrpId" value="SDB-NET">深圳发展银行</td>
            </tr>
            <tr>
                <td><INPUT TYPE="radio" NAME="pd_FrpId" value="BCCB-NET">北京银行</td>
                <td><INPUT TYPE="radio" NAME="pd_FrpId" value="CIB-NET">兴业银行
                </td>
                <td><INPUT TYPE="radio" NAME="pd_FrpId" value="SPDB-NET">上海浦东发展银行
                </td>
                <td><INPUT TYPE="radio" NAME="pd_FrpId" value="ECITIC-NET">中信银行</td>
            </tr>
            <tr>
                <td><br />
                </td>
            </tr>
            <tr>
                <td colspan="4"><INPUT TYPE="submit" value="确定支付">
                </td>
            </tr>
        </table>
    </form>


</div>

<%@include file="/pages/common/footer.jsp"%>

</body>
</body>
</html>
