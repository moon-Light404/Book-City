<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
<!--    写base标签永远固定相对路径跳转的结果-->
    <base href="http://localhost:8080/Last_war_exploded/ ">
    <link rel = "stylesheet" href = "static/bootstrap.min.css">
    <script src = "static/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            // 给注册绑定单击事件
            $("#sub_btn").click(function () {
                // 验证用户名：必须由字母，数字下划线组成，并且长度为5到12位
                //1 获取用户名输入框里的内容
                var usernameText = $("#username").val();
                //2 创建正则表达式对象
                var usernamePatt = /^\w{5,12}$/;
                //3 使用test方法验证
                if (!usernamePatt.test(usernameText)) {
                    //4 提示用户结果
                    $("span.errorMsg").text("用户名不合法！");

                    return false;
                }

                // 验证密码：必须由字母，数字下划线组成，并且长度为5到12位
                //1 获取用户名输入框里的内容
                var passwordText = $("#password").val();
                //2 创建正则表达式对象
                var passwordPatt = /^\w{5,12}$/;
                //3 使用test方法验证
                if (!passwordPatt.test(passwordText)) {
                    //4 提示用户结果
                    $("span.errorMsg").text("密码不合法！");

                    return false;
                }

                // 验证确认密码：和密码相同
                //1 获取确认密码内容
                var repwdText = $("#repwd").val();
                //2 和密码相比较
                if (repwdText != passwordText) {
                    //3 提示用户
                    $("span.errorMsg").text("确认密码和密码不一致！");

                    return false;
                }

                // 邮箱验证：xxxxx@xxx.com
                //1 获取邮箱里的内容
                var emailText = $("#email").val();
                //2 创建正则表达式对象
                var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                //3 使用test方法验证是否合法
                if (!emailPatt.test(emailText)) {
                    //4 提示用户
                    $("span.errorMsg").text("邮箱格式不合法！");

                    return false;
                }

                // 去掉错误信息
                $("span.errorMsg").text("");

            });

        });
    </script>
</head>
<body>
    <h1 align="center">注册界面</h1>
    <div class="container" style = "text-align: center">
        <span class="errorMsg">
            ${empty requestScope.msg ? "请输入用户名和密码":requestScope.msg}
        </span>
    </div>
        <form style="text-align: center" action="userServlet" method="post">
            <input type = "hidden" name = "action" value = "regist" />
            <div class="form-group">
                <label for="username" stype="display:inline;">账号：</label>
                <input type="text" class="form-control" id="username" name="username" style="display:inline;width:200px;"autocomplete="off"
                value="${requestScope.username}"/>
            </div>
            <div class="form-group">
                <label for="password" style="display:inline;">密码：&nbsp</label>
                <input type="text" class="form-control" id="password" name="password" style="display:inline;width:200px;"autocomplete="off" />
            </div>
            <div class="form-group">
                <label for="repwd" style="display:inline;">确认密码：</label>
                <input type="text" class="form-control" id="repwd" name="repwd" style="display:inline;width:200px;"autocomplete="off" />
            </div>
            <div class="form-group">
                <label for="email" style="display:inline;">电子邮件：</label>
                <input type="email" class="form-control" id="email" name="email" style="display:inline;width:200px;"autocomplete="off"
                value="${requestScope.email}"/>
            </div>
            <div class="form-group">
                <label for="sname" stype="display:inline;">你的昵称：</label>
                <input type="text" class="form-control" id="sname" name="sname" style="display:inline;width:200px;"autocomplete="off" />
            </div>
            <button type="submit" class="btn btn-primary" id ="sub_btn">注册</button>
        </form>


</body>
</html>