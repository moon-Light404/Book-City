package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

// 共有的抽象业务类(用户和书籍管理业务)
public abstract class MutualServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String act = req.getParameter("action");
        // act方法的名称
        try {
            // 获得action字符串获取相应的业务 方法反射对象
            Method method = this.getClass().getDeclaredMethod(act,HttpServletRequest.class,HttpServletResponse.class);
            // 调用目标业务方法
            method.invoke(this,req,resp);
        }catch (Exception e){
//            e.printStackTrace();
        }finally {
        }
    }
}
