<%--
  Created by IntelliJ IDEA.
  User: jhu
  Date: 2020/10/5
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div id="page_nav">

    <a href="${requestScope.page.url}&pageNo=1">首页</a>
    <c:if test="${requestScope.page.pageNo>1}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
    </c:if>

    <c:choose>
        <%-- 当总页码小于等于5的情况 --%>
        <c:when test="${ requestScope.page.pageTotal <= 5 }">

            <c:set var="begin" value="1"></c:set>
            <c:set var="end" value="${ requestScope.page.pageTotal }"></c:set>

        </c:when>
        <c:otherwise>
            <%-- 当总页码大于5的情况 --%>
            <c:choose>
                <%-- 当前页码是前三 --%>
                <c:when test="${ requestScope.page.pageNo <= 3 }">

                    <c:set var="begin" value="1"></c:set>
                    <c:set var="end" value="5"></c:set>

                </c:when>
                <%-- 当前页码是后三 --%>
                <c:when test="${ requestScope.page.pageNo >= requestScope.page.pageTotal - 2 }">

                    <c:set var="begin" value="${ requestScope.page.pageTotal - 4 }"></c:set>
                    <c:set var="end" value="${ requestScope.page.pageTotal }"></c:set>

                </c:when>
                <c:otherwise>

                    <c:set var="begin" value="${ requestScope.page.pageNo - 2 }"></c:set>
                    <c:set var="end" value="${  requestScope.page.pageNo + 2 }"></c:set>

                </c:otherwise>
            </c:choose>
        </c:otherwise>
    </c:choose>




    <c:forEach begin="${ begin }" end="${ end }" var="i">
        <c:if test="${ i == requestScope.page.pageNo }">【${ i }】</c:if>
        <c:if test="${ i != requestScope.page.pageNo }"><a href="${requestScope.page.url}&pageNo=${i}">${i}</a></c:if>
    </c:forEach>

    <c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
    </c:if>

    <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
    到第<input value="${param.pageNo}" name="pn" id="pn_input"/>页
    <input id="searchPageBtn" type="button" value="确定">

    <script type="text/javascript">
        $(function () {
            $("#searchPageBtn").click(function () {
                var pageNo = $("#pn_input").val()
                var pageTotal = ${requestScope.page.pageTotal}
                if(pageNo<1) pageNo=1
                if(pageNo>pageTotal) pageNo=pageTotal
                location.href="${requestScope.basePath}${requestScope.page.url}&pageNo="+pageNo;
            });
        });
    </script>
</div>