<%--
  Created by IntelliJ IDEA.
  User: jun Ding
  Date: 2021/6/2
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书管理界面</title>
<%--    静态包含base标签、css文件--%>
    <%@ include file="/pages/common/head.jsp"%>
<%--    <link rel = "stylesheet" href = "static/bootstrap.min.css">--%>
    <style>
        .back {
            font-size: 20px;
        }
    </style>
    <script type="text/javascript">
        $(function (){
            $("a.delete").click(function (){
                // 返回true表示点击了
                return confirm("你确定要删除["+ $(this).parent().parent().find("td:first").text()+"]?");
            });
        });
    </script>
</head>
<body>
    <div class="container">
        <div class="jumbotron">
            <h1>图书管理</h1>
            <a class = "back" href="pages/manager/manager.jsp">返回主页</a>
        </div>
    </div>


    <table class="table table-striped table-condensed" style="width: 80%; height: auto;">
        <thead>
        <tr>
            <th>书名</th>
            <th>作者</th>
            <th>价格</th>
            <th>库存</th>
            <th>类型</th>
            <th colspan="2" align="center">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.page.items}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.author}</td>
                <td>${book.price}</td>
                <td>${book.stock}</td>
                <td>${book.type}</td>
                <td><a class="btn btn-success" href="manager/bookServlet?action=getBook&id=${book.id}&function=update&pageNo=${requestScope.page.pageNo}">修改</a></td>
<%--                修改图书把当前页码pageNo传过去--%>
                <td><a class="delete btn btn-danger" href="manager/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}">删除</a></td></tr>
        </c:forEach>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a class="btn btn-primary" href="pages/manager/book_edit.jsp?function=add&pageNo=${requestScope.page.pageTotal}">添加图书</a></td>
<%--            跳到最后一页--%>
        </tr>
        </tbody>
    </table>
     <%@ include file="/pages/common/page_nav.jsp"%>


</body>
</html>
