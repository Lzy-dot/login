import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//@WebServlet("/login/send")
public class send extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置中文编码
        req.setCharacterEncoding("UTF-8");//编码部分
        // 解决输出中文乱码问题
        resp.setContentType("text/html;charset=UTF-8");
        resp.setHeader("content-type", "text/html;charset=UTF-8");//解码部分

        //设置逻辑实现
//        AliyunSmaUtils Ali=new AliyunSmaUtils();
//        Ali.setNewcode();
//        String code = Integer.toString(Ali.getNewcode());
        String mess=req.getParameter("mess");
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + mess + "</h1>");
    }

    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        doPost(request,response);
    }

}
