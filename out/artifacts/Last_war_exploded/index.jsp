<%--
  Created by IntelliJ IDEA.
  User: jun Ding
  Date: 2021/6/2
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>主界面</title>
    <%@ include file="/pages/common/head.jsp"%>
<%--    <link rel = "stylesheet" href = "static/bootstrap.min.css">--%>
    <style>
        h1 {
            margin-bottom: 220px;
        }
        ul li a {
            font-size: 20px;
        }
        body {
            width: 100%;
            height: 100%;
            background-image: url(pages/images/main.jpg) ;
            background-size: 100% 100%;
        }
        .index {
            background-color: #423225;
            opacity: 0.8;
        }

    </style>
</head>
<body>
    <h1 align="center">书店信息管理系统</h1>
    <div class="container " style="text-align: center">
        <div class="row">
            <div class="col-md-4 col-md-offset-4 index">
                <ul class="nav nav-pills nav-stacked">
                    <li class="active"><a href="pages/user/login.jsp">登录</a></li>
                    <li><a href="pages/user/regist.jsp">注册</a></li>
                    <li><a href="pages/manager/login_manager.jsp">管理员</a></li>
                </ul>
            </div>
        </div>
    </div>

  </body>
</html>
