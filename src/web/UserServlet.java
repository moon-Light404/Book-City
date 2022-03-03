package web;

import com.ding.pojo.User;
import com.ding.service.UserService;
import com.ding.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.Method;

public class UserServlet extends MutualServlet {

    private UserService userService = new UserServiceImpl();

    // 登录业务
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 调用 userService.login()登录处理业务
        User loginUser = userService.login(new User(null,null,username,password,null));
        // 如果等于null,说明登录失败
        if(loginUser == null){
            // 登陆失败跳回登录页面
            req.setAttribute("msg","用户名或密码错误!");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else{
            // 登录成功页面,跳转到分页显示界面 action = page执行page方法
            req.getSession().setAttribute("user",loginUser);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }


    // 注册业务
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String sname = req.getParameter("sname");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        if(userService.existsUsername(username)){
            // 检查用户名是否可用
            // 跳回注册页面
            System.out.println("用户名"+username+"已存在");
            req.setAttribute("msg","用户名已存在");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }else{
            // 可用调用数据库
            userService.registUser(new User(null,sname,username,password,email));
            // 跳转到注册成功页面
            req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
        }
    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{
//        1、销毁 Session 中用户登录的信息（或者销毁 Session）
        req.getSession().invalidate();
// 2、重定向到首页（或登录页面）。
        resp.sendRedirect(req.getContextPath());
    }

    protected void change(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String sname = req.getParameter("sname");
        User user = (User) req.getSession().getAttribute("user");
        // 得到用户原有的密码
        String password = user.getPassword();
        // 得到原有的用户账号
        String username = user.getUsername();
        String newpassword = req.getParameter("password");
        String email = req.getParameter("email");
        User newUser = new User(null,sname,username,password,email);
        req.getSession().setAttribute("user",newUser);
        // 更新用户信息
        userService.updateUser(new User(null,sname,username,newpassword,email));

        if(newpassword.equals(password)){
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }else {
            req.setAttribute("msg","成功修改密码，请重新登陆");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }
    }


}
