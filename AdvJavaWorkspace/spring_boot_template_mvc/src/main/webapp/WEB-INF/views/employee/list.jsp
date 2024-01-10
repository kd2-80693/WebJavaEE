<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
body {
	font-family: 'Arial', sans-serif;
	background-color: #f4f4f4;
	padding: 20px;
}

.table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
	background-color: #fff;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.table th, .table td {
	border: 1px solid #ddd;
	padding: 12px;
	text-align: left;
}

.table th {
	background-color: #3498db;
	color: #fff;
}

.table tbody tr:nth-child(even) {
	background-color: #f2f2f2;
}

.table img {
	max-width: 50px;
	max-height: 50px;
	border-radius: 50%;
}
</style>
<title>Employees</title>
</head>

<body>
<spring:url var="editurl" value="/emps/edit"></spring:url>
<spring:url var="delurl" value="/emps/delete"></spring:url>
<spring:url var = "edit" value="/edit.png"></spring:url>
<spring:url var = "delete" value="/delete.png"></spring:url>
	<table class="table">
		<tr>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Salary</th>
			<th>Join Date</th>
			<th>Email</th>
			<th>Employeement Type</th>
			<th>Dept ID</th>
			<th>IMG</th>
			<th>Action</th>
		</tr>
		<c:forEach var="emp" items="${requestScope.emps }">
			<tr>
				<td>${emp.id }</td>
				<td>${emp.firstName }</td>
				<td>${emp.lastName}</td>
				<td>${emp.salary }</td>
				<td>${emp.joinDate }</td>
				<td>${emp.email }</td>
				<td>${emp.empType }</td>
				<td>IMG</td>
				<td>${emp.dept.id }</td>
				<td>
				<a href="${editurl }?id=${emp.id}&deptId=${emp.dept.id}" ><img alt="edit" src="${edit }" height='24' width='24'></a> 
				<a href="${delurl }?id=${emp.id}&deptId=${emp.dept.id}"><img alt="delete" src="${delete }" height='24' width='24'></a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>