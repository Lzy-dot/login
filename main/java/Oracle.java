import java.sql.*;

public class Oracle {
    static Connection con;
    static Statement sql;
    static ResultSet rs;
    private Connection connect() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("加载数据库驱动成功！");
        }
        catch(ClassNotFoundException e) {
            System.out.println("找不到驱动程序类，加载驱动失败！");
            e.printStackTrace();
        }
    String dbURL="jdbc:oracle:thin:@localhost:1521:ORCL";
        String userName="U_J710";
        String userPwd="Oracle12c";

    try {
         con=DriverManager.getConnection(dbURL,userName,userPwd);
        System.out.println("数据库连接成功！");
        return con;
    }
    catch(SQLException ex) {
        System.out.println("数据库连接失败！");
        ex.printStackTrace();
    }
    return con;

}

    public void read()  {
        Oracle c=new Oracle();
        con=c.connect();
        try {
            sql=con.createStatement();
            rs=sql.executeQuery("select * from users");
            while(rs.next()) {
                String name=rs.getString("name");
                String password=rs.getString("password");
                System.out.println(name+" "+password);
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean write(String name,String password) {
        Oracle c=new Oracle();
        con=c.connect();
        try {
            sql=con.createStatement();
            String  code= "insert into users(id,name,password) values(710,?,?)";
            boolean flag=isOnly(name);
            while(flag==false){
                System.out.println("用户名"+name+"已被注册(╥╯^╰╥)");
                return false;
//                break;
            }
            PreparedStatement pst=con.prepareStatement(code);
            pst.setString(1, name);
            pst.setString(2, password);
            int i=pst.executeUpdate();
            if(i>0){
                System.out.println("恭喜你，"+name+"注册成功(◍°∇°◍)ﾉﾞ");
                return true;
                //跳转到登陆页面
            }else{
                System.out.println("注册失败，用户名重复(╥╯^╰╥)");
                return false;
            }

        }
        catch (SQLException e){
            System.out.println("注册失败，用户名已经存在(╥╯^╰╥)");
            e.printStackTrace();
            return false;

        }
    }

    public boolean seek(String name,String password){
        Oracle c=new Oracle();
        con=c.connect();
        try{
            sql=con.createStatement();
            rs=sql.executeQuery("select * from users");
            while(rs.next()){
                if(name.equals(rs.getString("name"))){
                    if(password.equals(rs.getString("password"))){
                        System.out.println("登录成功(◍°∇°◍)ﾉﾞ");
                        return true;
                    }
                    else {
                        System.out.println("密码错误(╥╯^╰╥)");
                        return  false;
                    }
                }
            }
            System.out.println("您尚未注册");
            return  false;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean seek_user(String name,String password){
        Oracle c=new Oracle();
        con=c.connect();
        try{
            sql=con.createStatement();
            rs=sql.executeQuery("select * from users");
            while(rs.next()){
                if(name.equals(rs.getString("name"))){
                    if(!password.equals(rs.getString("password"))){
                        System.out.println("密码错误(╥╯^╰╥)");
                        return true;
                    }
                }
                else{
                    System.out.println("您尚未注册￣へ￣");
                    return false;
                }
            }

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        return false;
    }


    private static boolean isOnly(String name){
        Oracle c=new Oracle();
        con=c.connect();
        String str="select id from users where name=?";
        boolean flag=true;
        PreparedStatement pst=null;
        ResultSet res=null;
        try{
            pst=con.prepareStatement(str);
            pst.setObject(1,name);
            //这里要获得结果集，进而判断表中是否存在用户名为name的结果
            res=pst.executeQuery();
            if(res.next()){
                flag=false;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return flag;
    }

//public static void main(String[] args)
//{
//    Oracle tester=new Oracle();
//    tester.read();
//    tester.write("lzy1","1002");
//
//}
}
