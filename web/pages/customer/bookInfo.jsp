<%--
  Created by IntelliJ IDEA.
  User: jun Ding
  Date: 2021/6/4
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--不要忘记包含Jstl库否则没有数据--%>
<html>
<head>
    <title>用户商品界面</title>
    <%@ include file="/pages/common/head.jsp"%>
<%--    包含登录成功页面--%>
    <%@ include file="/pages/user/login_success.jsp"%>
    <style>
        form {
            font-size: 18px;
        }
        form input {
            width: 75px;
            height: 30px;
            line-height: 30px;
        }
        .table h2 {
            width: 140px;
            border: 1px solid black;
        }
    </style>
    <script type="text/javascript">
        $(function (){
            $("a.buy").click(function (){
                window.alert("恭喜成功购买["+$(this).parent().parent().find("td:first").text()+"]，快去书架看看吧");
            });
        });
    </script>
</head>
<body>

    <div class="container">
        <form action="customer/bookServlet" method="get">
            请输入查询关键字:
            <input type="hidden" name="action" value="pageByThree">
            书名:<input id = "book_name" type="text" name="name" value="${param.name}">
            作者:<input id = "author" type="text" name="author" value="${param.author}">
            价格: <input id="min" type="text" name="min" value="${param.min}"> ~
            <input id = "max" type="text" name="max" value="${param.max}">元
            种类:<input id="type" type="text" name="type" value="${param.type}">
            <input class="btn btn-info" type="submit" value="查询" />
        </form>
    </div>
    <table class="table table-striped table-condensed" style="width: 80%; height: auto;">
        <caption><h2>光明书店</h2></caption>
        <hr/>
        <thead>
        <tr>
            <th>书名</th>
            <th>作者</th>
            <th>价格</th>
            <th>库存</th>
            <th>类型</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
<%--        显示分页数据--%>
        <c:forEach items="${requestScope.page.items}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.author}</td>
                <td>${book.price}</td>
                <td>${book.stock}</td>
                <td>${book.type}</td>
                <td>
                    <a class="buy btn btn-success" href="orderServlet?action=buyBook&bookId=${book.id}">购买</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    <%@ include file="/pages/common/page_nav.jsp"%>


</body>
</html>
