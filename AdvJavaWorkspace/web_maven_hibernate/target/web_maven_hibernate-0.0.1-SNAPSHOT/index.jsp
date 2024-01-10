<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="team" class="beans.TeamBean" scope="session" />
<body>
<h3> Welcome 2 Web App with Hibernate @ <%= new Date() %></h3>
<h3>${sessionScope.team.allTeams}</h3>
<h3><a href="add_player_form.jsp">Add Player Form</a></h3>
</body>
</html>