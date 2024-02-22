package project;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CheckBalance")
public class CheckBalance extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    	RequestDispatcher rd = req.getRequestDispatcher("EnterPin.html");
    	res.setContentType("text/html");
    	res.setContentType("text/jsp");
    	PrintWriter pr=res.getWriter();
    	rd.include(req, res);
	
    }
}
