import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Register extends HttpServlet {
      static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
      static final String DB_URL="jdbc:mysql://localhost/TEST";

      //  Database credentials
      static final String USER = "root";
      static final String PASS = "nive";
Connection conn;
Statement stmt;
	

public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
     try{
         // Register JDBC driver
         Class.forName("com.mysql.jdbc.Driver");

         // Open a connection
         conn = DriverManager.getConnection(DB_URL,USER,PASS);
String b = request.getParameter("op");
if(b.equals("register"))
{
 

		String n=request.getParameter("userName");
		String p=request.getParameter("userPass");
		String d=request.getParameter("dept");
		String s = request.getParameter("sec");
		String y = request.getParameter("year");
		String e=request.getParameter("userEmail");
		String c=request.getParameter("userCountry");
			
		PreparedStatement ps=conn.prepareStatement("insert into registeruser values(?,?,?,?,?,?,?)");
		ps.setString(1,n);
		ps.setString(2,p);
		ps.setString(3,d);
		ps.setString(4,s);
		ps.setInt(5,Integer.valueOf(y));
		ps.setString(6,e);
		ps.setString(7,c);

				
		int i=ps.executeUpdate();
		if(i>0)
		out.print("You are successfully registered...");
		else
out.print("Unsuccessful");
			
		}

if(b.equals("delete"))
{

		String n=request.getParameter("userName");
		String p=request.getParameter("userPass");
		String e=request.getParameter("userEmail");

		PreparedStatement ps=conn.prepareStatement("delete from registeruser where pass='"+p+"' and email='"+e+"' ");
ps.executeUpdate();
out.print("Successfully removed!!");
}
if(b.equals("update"))
{
String n=request.getParameter("userName");
		String p=request.getParameter("userPass");
		
		String s = request.getParameter("sec");
		String y = request.getParameter("year");
		String e=request.getParameter("userEmail");
		PreparedStatement ps=conn.prepareStatement("update registeruser set email='"+e+"',sec='"+s+"',year="+y+" where pass='"+p+"' ");
ps.executeUpdate(); 
out.print("UPDATEEED!!");
			

}
}

catch (Exception e2) {

out.print(e2);
}
		
		out.close();
	}

}
