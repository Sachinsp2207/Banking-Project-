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
   String n=request.getParameter("pin");
	int id=(Integer).parseInt(n);
	
	Class.forName("com.mysql.cj.jdbc.Driver");
    Connection   conn = DriverManager.getConnection("jdbc:mysql://localhost:8855/student","root","Sachinsp@4");
    PreparedStatement st = conn.prepareStatement("Select * from details where pin=?");
    st.setInt(1, id);
    ResultSet s  = st.executeQuery();
    if(s.next())
    {   
%>

<form action="">
id <input type="number" value="<%=s.getInt(1)%>">
Name <input type="text" value="<%=s.getString(2)%>">
Age <input type="number" value="<%=s.getInt(3)%>">
Contact <input type="number" value="<%=s.getLong(4)%>">
</form>
<%}

else
{%>
<%="Id Not Found" %>
<%} %>
</body>
</html>