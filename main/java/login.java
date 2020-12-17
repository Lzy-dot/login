import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login/login")
public class login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(req, resp);
    }



    // 处理 POST 方法请求的方法
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("gbk");//编码部分
        response.setCharacterEncoding("gbk");
        response.setHeader("content-type", "text/html;charset=gbk");//解码部分

        String name=request.getParameter("u_name");//获得html界面的信息
        String password=request.getParameter("u_pass0");
        Oracle logging=new Oracle();
        boolean register=logging.write(name, password);//使用上面的第二步，写入数据库
        PrintWriter printwriter=response.getWriter();//浏览器界面显示
        if(register){
            printwriter.write("<h1>" +"恭喜你，"+name+"注册成功(￣▽￣)"+"</h1>");
        }else{
            printwriter.write("<h1>" +"注册失败，用户名重复(╥╯^╰╥)"+"</h1>");
        }



        response.sendRedirect("login.html");
    }

}
