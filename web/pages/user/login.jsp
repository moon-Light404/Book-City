<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <base href="http://localhost:8080/Last_war_exploded/">
    <link rel = "stylesheet" href = "static/bootstrap.min.css">
    <script src = "static/jquery-3.5.1.min.js"></script>
    <script src = "static/bootstrap.min.js"></script>

</head>

<body>
    <div class="page-header" align="center">
        <h1>登陆界面</h1>
    </div>
    <div class="container" style = "text-align: center">
        <span>
            ${empty requestScope.msg ? "请输入用户名和密码":requestScope.msg}
        </span>
    </div>
    <form style="text-align: center" action="userServlet" method="post">
        <input type = "hidden" name = "action" value = "login" />
        <div class="form-group">
            <label for="user" stype="display:inline;">账号：</label>
            <input type="text" class="form-control" id="user" name="username" style="display:inline;width:200px;"autocomplete="off"
            value="${ requestScope.username}"/>
        </div>
        <div class="form-group">
            <label for="password" style="display:inline;">密码：</label>
            <input type="text" class="form-control" id="password" name="password" style="display:inline;width:200px;"autocomplete="off" />
        </div>
        <button type="submit" class="btn btn-primary">登录</button>
        <button type="button" class="btn btn-primary"  onclick="window.location.href='pages/user/regist.jsp'">注册</button>
    </form>
</body>
</html>