<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Location</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="c" items="${requestScope.depts }">
				<tr>
					<td>${c.id}</td>
					<td>${c.name}</td>
					<td>${c.location}</td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>
</body>
</html>