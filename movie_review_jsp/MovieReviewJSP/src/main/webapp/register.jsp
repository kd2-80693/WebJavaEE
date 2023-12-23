<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<jsp:useBean id="ru" class ="com.sunbeam.beans.RegisterBean"></jsp:useBean>
	<jsp:setProperty property="*" name="ru"/>
	${ru.registerUser()}
	
	
	
	<%
	if(ru.getStatus())
	{
		out.println("<h1> User Registered Succesfully</h1>");
	}
	else
	{
		out.println("<h1> Some Error Occured , Try Again with valid Values;</h1>");
		out.println("<a href ='registerPage.jsp' > Sign-up </a>");
	}
	%>
</body>
</html>