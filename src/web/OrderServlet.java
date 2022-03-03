package web;

import com.ding.pojo.Book;
import com.ding.pojo.Order;
import com.ding.pojo.User;
import com.ding.service.BookService;
import com.ding.service.OrderService;
import com.ding.service.impl.BookServiceImpl;
import com.ding.service.impl.OrderServiceImpl;
import com.ding.util.ToInt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderServlet extends MutualServlet {

    private OrderService orderService = new OrderServiceImpl();
    private BookService bookService = new BookServiceImpl();

    protected void checkOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取当前登录的用户
        User user = (User)req.getSession().getAttribute("user");
        // 查询该用户的购买订单
        List<Order> orderList = orderService.queryOrders(user.getUsername());
        req.setAttribute("orders",orderList);
        // 跳转到order.jsp页面
        req.getRequestDispatcher("/pages/customer/order.jsp").forward(req,resp);
    }
    /**
     * 处理买书业务
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void buyBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 得到当前登录的用户对象
        User user = (User) req.getSession().getAttribute("user");
        // 获得购买的图书的id
        Integer bookId = Integer.valueOf(req.getParameter("bookId"));
        // 获得该书籍对象
        Book book = bookService.queryBookById(bookId);
        // 没有买过该书，则添加订单记录
        Order order = orderService.queryOrderByIdAndName(bookId,user.getUsername());
        if(order == null){
            orderService.addOrder(new Order(null,user.getUsername(),book.getId(),book.getName(),book.getAuthor(),book.getType(),1));
        }else {
            // 买过该书，则订单记录中书的数量加1
            orderService.updateOrder(new Order(null,order.getUsername(),order.getBookId(),order.getBookName(),order.getAuthor(),
                    order.getBookType(),order.getBookNum()+1));
        }
//        resp.sendRedirect(req.getContextPath() + "/" + url + "&pageNo="+pageNo);
        // 从哪个页面来的回到哪个页面去
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void giveUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int orderId = ToInt.parseInt((req.getParameter("id")),0);
        Order order = orderService.queryOrderById(orderId);
        if(order.getBookNum() > 1){
            orderService.updateOrder(new Order(null,order.getUsername(),order.getBookId(),order.getBookName(),order.getAuthor(),
                    order.getBookType(),order.getBookNum()-1));
        }else{
            orderService.deleteOrderById(orderId);
        }
        resp.sendRedirect(req.getContextPath() + "/orderServlet?action=checkOrder");
    }
}
