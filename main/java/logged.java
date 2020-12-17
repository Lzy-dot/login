import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/login/logged")
public class logged extends HttpServlet{
    public static final long serialVersionUID=1L;
    public logged(){
        super();
    }
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        doPost(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
//        //设置响应内容类型
//        response.setContentType("text/html");
////        解决输出中文乱码问题
//        response.setContentType("text/html;charset=GBK");

        request.setCharacterEncoding("gbk");//编码部分
        response.setCharacterEncoding("gbk");
        response.setHeader("content-type", "text/html;charset=gbk");//解码部分

        String phone=request.getParameter("phone");


        String name=request.getParameter("login_name");
        String password=request.getParameter("login_password");
        Oracle logged=new Oracle();
        boolean correct=logged.seek(name,password);
        boolean have=logged.seek_user(name,password);
        PrintWriter out = response.getWriter();
        out.println("<h1>" + phone + "</h1>");
        if(correct){
            out.println("<h1>" + "登录成功(￣▽￣)" + "</h1>");
        }
        else if(have){
            out.println("<h1>" + "密码错误(╥╯^╰╥)" + "</h1>");
        }
        else{
            out.println("<h1>" + "您尚未注册￣へ￣" + "</h1>");
        }
    }


//    sendMsg smg=new sendMsg();



}





