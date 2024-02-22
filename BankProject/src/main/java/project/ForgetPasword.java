package project;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.mysql.cj.xdevapi.Statement;
@WebServlet("/ForPass")
public class ForgetPasword  extends GenericServlet{

	  static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	    static final String DB_URL = "jdbc:mysql://localhost:8855/BankDB";
	    static final String USER = "root";
	    static final String PASS = "8855";
	    public long ac=0;
    	public  long ad=0;
    	public  String em=null;
    	public String np=null;
    	String email=null;
    	String Accno=null;
    	String Adhar=null;
    	String acc;
    	String add;
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        email = req.getParameter("email");
         Accno = req.getParameter("Accno");
        Adhar = req.getParameter("Adhar");
        np =req.getParameter("NewPass");
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection   conn = DriverManager.getConnection("jdbc:mysql://localhost:8855/BankDB","root","Sachinsp@4");
            PreparedStatement st = conn.prepareStatement("Select * from bankdb where Email=?");
            st.setString(1, email);
          
            ResultSet s  = st.executeQuery();
             while(s.next())
             	{
            	 em= s.getString(2);
            	 ac= s.getLong(3);
            	 acc=String.valueOf(ac); 
            	ad=s.getLong(10);
            	add=String.valueOf(ad);
            	
            	 if ((em.equals(email))&&((Accno.equals(acc)))&(Adhar.equals(add)))
            	 { 
            		 PreparedStatement ps=conn.prepareStatement("update bankdb set Pass=? where Accno=?");
            		 ps.setString(1,np);
            		 ps.setString(2,Accno);
     				ps.execute();
       			    RequestDispatcher rd = req.getRequestDispatcher("PasswordUpdated.html");
       			    rd.include(req, res);
       			}
            	  
             	}
             if((email==null)&&(Accno==null)&(Adhar==null)&&(np==null))
        	 {
        		 RequestDispatcher rd = req.getRequestDispatcher("InvalidCredentialsPass.html");
   			    rd.include(req, res);
   			 
        	 }
        	 else {
        		 RequestDispatcher rd = req.getRequestDispatcher("InvalidCredentialsPass.html");
  			    rd.include(req, res);
  			  res.setContentType("text/html");
        	 }
        } 
        catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }
		
	}


