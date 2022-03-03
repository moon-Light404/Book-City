<%--
  Created by IntelliJ IDEA.
  User: jun Ding
  Date: 2021/6/3
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--管理员界面的分页条--%>
<div class="container">
    <div class="page-nav" align="center">
        <%--            大于首页才显示--%>
<%--        JSTL标签--%>
        <c:if test="${requestScope.page.pageNo > 1}">
            <a href = "${requestScope.page.url}&pageNo=1">首页</a>
            <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
        </c:if>
        <c:if test="${requestScope.page.pageNo <= 1}">
            首页 &nbsp 上一页
        </c:if>
        第【${requestScope.page.pageNo }】页
        <%--    防止末页越界--%>
        <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
            <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
            <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
        </c:if>
        <c:if test="${requestScope.page.pageNo >= requestScope.page.pageTotal}">
            下一页 &nbsp 末页
        </c:if>
        <%--            param.pageNo显示当前页码--%>
        共[${requestScope.page.pageTotal}]页&nbsp;[${requestScope.page.pageTotalCount}]条记录 转到第
        <input value="${param.pageNo}" name="pn" id="pn_input" style="width: 35px"/>页
        <input id="Topage" type="button" value="确定">

        <%-- 单机按钮到达指定页面--%>
        <%--                跳转到指定页码--%>
<%--            是在整个Web应用上都是有效的--%>
            <script type="text/javascript">
                $(function () {
                    // 跳到指定的页码
                    $("#Topage").click(function () {
                        var pageNo = $("#pn_input").val();

                        var pageTotal = ${requestScope.page.pageTotal}; // 获取总页码
                        if(pageNo<1 || pageNo > pageTotal){
                            alert("不能跳转,页面超过范围或不存在");
                            return;
                        }
                        window.location.href = "${pageScope.basePath}${requestScope.page.url}&pageNo="+
                            pageNo;
                    });
                });
            </script>
    </div>
</div>
