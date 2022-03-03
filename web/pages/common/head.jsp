<%--
  Created by IntelliJ IDEA.
  User: jun Ding
  Date: 2021/6/3
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/";

    pageContext.setAttribute("basePath",basePath);
%>
<%--协议--%>
<%--服务器名--%>
<%--端口号--%>
<%--当前工程名--%>
<!--写base标签，永远固定相对路径跳转的结果-->
<base href="<%=basePath%>">
<link rel = "stylesheet" href = "static/bootstrap.min.css">
<link rel="stylesheet" href="static/table.css">
<script type="text/javascript" src="static/jquery-1.7.2.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
  
  </body>
</html>
