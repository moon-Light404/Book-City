package web;

import com.ding.pojo.Book;
import com.ding.pojo.Page;
import com.ding.service.BookService;
import com.ding.service.impl.BookServiceImpl;
import com.ding.util.TextUtils;
import com.ding.util.ToInt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Pageable;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class BookServlet extends MutualServlet {

    private BookService bookService = new BookServiceImpl(); // 书籍数据库操作类
    // 添加操作
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取参数
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        String type = req.getParameter("type");
        BigDecimal price = new BigDecimal(req.getParameter("price"));
        Integer stock = Integer.valueOf(req.getParameter("stock"));
        int pag = ToInt.parseInt(req.getParameter("pageNo"),0);
        pag += 1;
        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(author) && !TextUtils.isEmpty(type)){
            bookService.addBook(new Book(null,name,author,price,stock,type));
        }
        // 返回跳转到图书显示界面更新
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+pag);
    }

    // 删除图书
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Integer id = Integer.parseInt(req.getParameter("id"));
//        String pageNum = req.getParameter("pageNo");
        bookService.deleteBookById(id);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
        // 第二次采用分页所有要跳到分页处理,删除一条记录后在当前页面显示
    }

    /**
     * 修改书籍信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 先获取当前页码
//        String pageNum = req.getParameter("pageNo");
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        String type = req.getParameter("type");
        BigDecimal price = new BigDecimal(req.getParameter("price"));
        Integer stock = Integer.valueOf(req.getParameter("stock"));
        Integer id = Integer.valueOf(req.getParameter("id"));
        Book book = new Book(id,name,author,price,stock,type);
        bookService.updateBook(book);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
        // 第二次采用分页所有要跳到分页处理,修改后同样是在当前页面显示
    }

    /**
     * 查询书籍列表
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void checkList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> bookList = bookService.queryBooks(); // 查询所有书籍

        req.setAttribute("books",bookList);
        // 跳转到book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id")); // 获取传过来的id
        Book book = bookService.queryBookById(id); // 查询该图书
        req.setAttribute("book",book); // 保存图书到request域中
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp); // 带着查询过id后的信息又传回去回显信息
    }

    /**
     * 处理分页功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("utf-8");
        // 获取请求参数pageNo 和 pageSize
        int PageNo = ToInt.parseInt(req.getParameter("pageNo"),1);
        int PageSize = Page.PAGE_SIZE;
        // 调用BookService.page对象,可求出总页数和总记录数
        Page<Book> page = bookService.page(PageNo,PageSize);
        // 后台访问地址
        page.setUrl("manager/bookServlet?action=page");
        // 保存到request域中
        req.setAttribute("page",page);
        // 请求转发到book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
}
