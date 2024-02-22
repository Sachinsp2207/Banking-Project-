<%@page import= "java.sql.*"%>
<%@page import= "java.sql.Connection"%>
<%@page import ="java.sql.DriverManager" %>
<%@page import= "java.sql.ResultSet" %>
<%@page import= "java.sql.Statement" %>
<%@page import= "java.sql.SQLException" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String PIN = request.getParameter("pin");
	int pin=Integer.parseInt(PIN);
	double bal;
	try {
   		 	Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection   conn = DriverManager.getConnection("jdbc:mysql://localhost:8855/BankDB","root","Sachinsp@4");
    		PreparedStatement st = conn.prepareStatement("Select * from bankdb where pin=?");
    		st.setInt(1, pin);
    		ResultSet s  = st.executeQuery();
     	while(s.next())
     		{	
    	 		bal=s.getDouble(5);
     		}  
		} 
	catch (SQLException se) {
    	se.printStackTrace();
	} catch (Exception e) {
  	  e.printStackTrace();
	}

		out.print(bal);
%>


</body>
</html>