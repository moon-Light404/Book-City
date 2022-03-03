<%--
  Created by IntelliJ IDEA.
  User: jun Ding
  Date: 2021/6/10
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户信息</title>
    <%@ include file="/pages/common/head.jsp"%>

    <%@ include file="/pages/user/login_success.jsp"%>
</head>
<body>
    <div class="container">
        <div>
            <form action="userServlet" method="get">
                <input type="hidden" name="action" value="change">
<%--                change修改用户信息--%>
                <table class="table table-striped table-condensed" style="width: 70%;height: auto;">
                    <tr>
                        <td>账号</td>
                        <td>${sessionScope.user.username}</td>
                    </tr>
                    <tr>
                        <td>新的昵称</td>
                        <td><input name = "sname" type="text" value="${sessionScope.user.sname}"/> </td>
                    </tr>
                    <tr>
                        <td>新的密码</td>
                        <td><input name="password" type="text" value="${sessionScope.user.password}"/> </td>
                    </tr>
                    <tr>
                        <td>新的邮件</td>
                        <td><input name="email" type="text" value="${sessionScope.user.email}"/> </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="确定修改"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
  </body>
</html>
