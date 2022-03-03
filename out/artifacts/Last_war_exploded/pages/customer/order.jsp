<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jun Ding
  Date: 2021/6/7
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的书架</title>
    <%@ include file="/pages/common/head.jsp"%>
    <%--    包含登录成功页面--%>
    <%@ include file="/pages/user/login_success.jsp"%>
</head>
<body>
    <table class="table table-striped table-condensed" style="width: 80%; height: auto;">
        <caption><h2>我的书架</h2></caption>
        <thead>
        <tr>
            <th>书名</th>
            <th>作者</th>
            <th>数量</th>
            <th>类型</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.orders}" var="order">
            <tr>
                <td>${order.bookName}</td>
                <td>${order.author}</td>
                <td>${order.bookNum}</td>
                <td>${order.bookType}</td>
                <td><a class="btn btn-danger" href="orderServlet?action=giveUp&id=${order.id}">不想要了</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
