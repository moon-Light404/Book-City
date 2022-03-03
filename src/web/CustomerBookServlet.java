package web;

import com.ding.pojo.Book;
import com.ding.pojo.Page;
import com.ding.service.BookService;
import com.ding.service.impl.BookServiceImpl;
import com.ding.util.HandleAddress;
import com.ding.util.ToInt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerBookServlet extends MutualServlet{

    private BookService bookService = new BookServiceImpl();


    /**
     * 处理分页功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 获取请求参数pageNo 和 pageSize
        int PageNo = ToInt.parseInt(req.getParameter("pageNo"),1);
        int PageSize = Page.PAGE_SIZE;

        // 调用BookService.page对象,可求出总页数和总记录数
        Page<Book> page = bookService.page(PageNo,PageSize);
        page.setUrl("customer/bookServlet?action=page");
        // 保存到request域中
        req.setAttribute("page",page);
        // 请求转发到bookInfo.jsp页面显示数据
        req.getRequestDispatcher("/pages/customer/bookInfo.jsp").forward(req,resp);
    }

//    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//        req.setCharacterEncoding("utf-8");
//        // 获取请求参数pageNo 和 pageSize
//        int PageNo = ToInt.parseInt(req.getParameter("pageNo"),1);
//        int PageSize = Page.PAGE_SIZE;
//        int min = ToInt.parseInt(req.getParameter("min"),0);
//        int max = ToInt.parseInt(req.getParameter("max"),Integer.MAX_VALUE);
//        Page<Book> page;
//        // 调用BookService.page对象,可求出总页数和总记录数，最后记录page
//        page = bookService.pageByPrice(PageNo,PageSize,min,max);
//        // 后台访问地址,带上价格区间
//        StringBuilder addre = new StringBuilder("customer/bookServlet?action=pageByPrice");
//        // 最小值价格
//        if(req.getParameter("min")!=null){
//            addre.append("&min=").append(req.getParameter("min"));
//        }
//        // 最大值价格
//        if(req.getParameter("max")!=null){
//            addre.append("&max=").append(req.getParameter("max"));
//        }
//        if("".equals(req.getParameter("min")) && "".equals(req.getParameter("max"))){
//            addre.delete(32,39); // 把ByPrice删除变成customer/bookServlet?action=page
//            page = bookService.page(1,Page.PAGE_SIZE); // 从第一页开始
//        }
//
//        page.setUrl(addre.toString());
//        // 保存到request域中
//        req.setAttribute("page",page);
//        // 请求转发到book_manager.jsp页面
//        req.getRequestDispatcher("/pages/customer/bookInfo.jsp").forward(req,resp);
//    }
    protected void pageByThree(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int pageNo = ToInt.parseInt(req.getParameter("pageNo"),1);
        int pageSize = Page.PAGE_SIZE;
        int min = ToInt.parseInt(req.getParameter("min"),0);
        int max = ToInt.parseInt(req.getParameter("max"),Integer.MAX_VALUE);
        String name = req.getParameter("name");
        String author = req.getParameter("author"); // 作者
        String type = req.getParameter("type");
        Page<Book> page = bookService.searchBook(pageNo,pageSize,name,author,type,min,max);
        // 先获取url地址
        String url = HandleAddress.getAddress(name,author,type,min,max);
        // 没有查询条件都为空时
        if(url.equals("customer/bookServlet?action=page")){
            // 这是无查询条件的默认查询所以书籍
            page = bookService.page(1,pageSize);
        }
        page.setUrl(url);
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/customer/bookInfo.jsp").forward(req,resp);
    }

}
