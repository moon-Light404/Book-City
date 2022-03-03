package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ManagerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String passWord = req.getParameter("password");
        if(userName.equals("admin") && passWord.equals("123456")){
            // 跳转到管理页面
            req.getRequestDispatcher("/pages/manager/manager.jsp").forward(req,resp);
        }else {
            req.setAttribute("man_msg","管理员账号或密码错误");
            req.getRequestDispatcher("/pages/manager/login_manager.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
