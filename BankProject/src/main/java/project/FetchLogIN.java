package project;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Step1")
public class FetchLogIN extends GenericServlet{ 
	
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    	String   Email = req.getParameter("email");
    	String   Pass = req.getParameter("pass");
    	double Bal = 0;
    	Log l1=new Log(Email,Pass,Bal);
    	
         String em=null;
    	  String ps=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection   conn = DriverManager.getConnection("jdbc:mysql://localhost:8855/BankDB","root","Sachinsp@4");
            PreparedStatement st = conn.prepareStatement("Select * from bankdb where Pass=?");
            st.setString(1, Pass);
            ResultSet s  = st.executeQuery();
           
             while(s.next())
             	{	
            	em= s.getString(2);
            	Bal=s.getDouble(5);
            	 ps=s.getString(7);
            	 if (em.equals(Email)&&ps.equals(Pass)) 
            	 { 
       			    RequestDispatcher rd = req.getRequestDispatcher("Loginsuccess.html");
       			    rd.include(req, res);
       			 res.setContentType("text/html");
       			}
            	 
             	}
              if(em==null&& ps==null) {
    			    RequestDispatcher rd = req.getRequestDispatcher("InvalidCredentialsLogIn.html");
    			    rd.include(req, res);
    			    res.setContentType("text/html");
    			}  
              else
              {  
  			    RequestDispatcher rd = req.getRequestDispatcher("InvalidCredentialsLogIn.html");
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
	

