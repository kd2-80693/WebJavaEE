<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>authentication</title>
</head>
<body>
	<jsp:useBean id="user" class = "com.sunbeam.beans.LoginBean"></jsp:useBean>
	<jsp:setProperty property="*" name = "user" />
	<%
	user.authenticate();
	%>
	<%
	if(user.getStatus())
	{
		out.println("<h1> Welcome to your page , Login Successfull</h1>");
	}
	else
	{
		out.println("<h1> Invalid User </h1>");
	}
	%>
</body>
</html>