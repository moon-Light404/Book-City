<%--
  Created by IntelliJ IDEA.
  User: jun Ding
  Date: 2021/6/15
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录</title>
    <%@ include file="/pages/common/head.jsp"%>
</head>
<body>
    <h1 align="center">管理员登录</h1>
    <div class="container" style="text-align: center">
        <span>
            ${empty requestScope.man_msg ? "请输入管理员账号密码" : requestScope.man_msg}
        </span>
    </div>
    <form style="text-align: center" action="managerServlet" method="post">
        <div class="form-group">
            <label for="user" stype="display:inline;">账号：</label>
            <input type="text" class="form-control" id="user" name="username" style="display:inline;width:200px;"autocomplete="off"
                   value=""/>
        </div>
        <div class="form-group">
            <label for="password" style="display:inline;">密码：</label>
            <input type="text" class="form-control" id="password" name="password" style="display:inline;width:200px;"autocomplete="off" />
        </div>
        <button type="submit" class="btn btn-primary">登录</button>
    </form>
</body>
</html>
