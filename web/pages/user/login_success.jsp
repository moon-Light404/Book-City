<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录成功</title>
    <style>
        span.top {
            font-size: 28px;
            margin-left: 100px;
            float: left;
            line-height: 50px;
            color: #ffffff;
        }
        .um_span {
            color: red;
        }
        div.top {
            font-size: 28px;
            width: 100%;
            height: 50px;
            background-color: #353942;
            margin-bottom: 75px;
        }
       .top a {
           line-height: 50px;
            display: inline-block;
            float: left;
            margin-right: 50px;
            text-decoration: none;
           color: #ffffff;
        }

    </style>
</head>
<body>
    <div class="top">
        <span class="top">---欢迎光临书店--- <span class="um_span">${sessionScope.user.sname}</span></span>
        <a href="${pageScope.basePath}customer/bookServlet?action=page">购买图书</a>
        <a href="${pageScope.basePath}orderServlet?action=checkOrder">我的书架</a>
        <a href="${pageScope.basePath}userServlet?action=logout">注销</a>
        <a href="${pageScope.basePath}pages/customer/update.jsp">修改资料</a>
    </div>

</body>
</html>