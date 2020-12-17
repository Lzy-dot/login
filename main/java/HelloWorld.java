import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/login/HelloWorld")
public class HelloWorld extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置中文编码
        req.setCharacterEncoding("UTF-8");
        // 解决输出中文乱码问题
        resp.setContentType("text/xml;charset=UTF-8");
//        resp.setHeader("content-type", "text/html;charset=UTF-8");//解码部分

        String number=req.getParameter("phone");
//
//        //设置逻辑实现
//        AliyunSmaUtils Ali=new AliyunSmaUtils();
//        Ali.setNewcode();
//        String code = Integer.toString(Ali.getNewcode());
//        try{
//            SendSmsResponse response =Ali.sendSms(number,code); // TODO 填写你需要测试的手机号码
//        }catch (Exception e){
//            PrintWriter out = resp.getWriter();
//            out.println("<h1>发送失败</h1>");
//        }

        PrintWriter printWriter=resp.getWriter();
        //        返回XML文件给前台
        printWriter.write("<?xml version='1.0' encoding='UTF-8'?>");
        printWriter.write("<root>");

        printWriter.write("<code>code</code>");

        printWriter.write("</root>");


//        if(vcode.equals(code)){
//            PrintWriter out = resp.getWriter();
//            out.println("<h1>" + number + "</h1>");
//        }
//        PrintWriter out = resp.getWriter();
//        out.println("<h1>" + number  + "</h1>");
    }

    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        doPost(request,response);
    }

}
