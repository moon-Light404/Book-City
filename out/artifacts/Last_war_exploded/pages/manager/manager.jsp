<%--
  Created by IntelliJ IDEA.
  User: jun Ding
  Date: 2021/6/4
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员界面</title>
<%--    包含base固定相对路径--%>
    <%@ include file="/pages/common/head.jsp"%>
    <style>
        ul li a{
            font-size: 20px;
        }
    </style>
</head>
<body>
    <h1 align="center">---欢迎管理界面---</h1>
    <div class="container">
        <div class="row">
            <div class="col-sm-4">
                <ul class="nav nav-pills nav-stacked">
                    <li><a href="#">返回首页</a></li>
                    <li><a href="manager/bookServlet?action=page">管理书籍</a></li>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>
