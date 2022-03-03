<%--
  Created by IntelliJ IDEA.
  User: jun Ding
  Date: 2021/6/2
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加图书</title>
    <%--    静态包含base标签、css文件--%>
    <%@ include file="/pages/common/head.jsp"%>
    <style>
        table {
            margin: 0 auto;
            padding: 0;
        }
        tr {
            width: 1035px;
        }
        td,th {
            width: 150px;
            height: 40px;
            font-size: 20px;
        }
    </style>

</head>
<body>
    <div class="container">
        <div class="jumbotron">
            <h2>编辑图书</h2>
        </div>
        <div>
            <form action="manager/bookServlet" method="get">
                <input type = "hidden" name = "pageNo" value="${param.pageNo}"/>
                <input type="hidden" name="action" value="${param.function}" />
                <input type = "hidden" name="id" value="${requestScope.book.id}">
<%--                把id传到bookServlet对指定的book进行修改--%>
                <table class="table table-striped table-condensed" style ="width: 70%; height: auto;">
                <tr>
                    <td>名称</td>
                    <td>作者</td>
                    <td>价格</td>
                    <td>库存</td>
                    <td>类型</td>
                    <td colspan="2">操作</td>
                </tr>
                <tr>
                    <td><input name="name" type="text" value="${requestScope.book.name}"/></td>
                    <td><input name="author" type="text" value="${requestScope.book.author}"/></td>
                    <td><input name="price" type="text" value="${requestScope.book.price}"/></td>
                    <td><input name="stock" type="text" value="${requestScope.book.stock}"/></td>
                    <td><input name="type" type="text" value="${requestScope.book.type}"/></td>
                    <td><input type="submit" value="提交"/></td>
                </tr>
            </table>
            </form>
        </div>
    </div>
</body>
</html>
