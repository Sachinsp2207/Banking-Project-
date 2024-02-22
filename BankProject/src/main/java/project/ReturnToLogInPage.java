package project;
import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/returnlogin")
public class ReturnToLogInPage extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		 RequestDispatcher rd = req.getRequestDispatcher("Loginpage1.html");
		    rd.include(req, res);
		    res.setContentType("text/html");
		
	}

}
