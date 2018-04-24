<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
	<h1>Employee List</h1>
	<h3>
		<a href="add">Add Employee</a>
	</h3>
	<table border="1">
		<tr>
		<th>Name</th>
		<th>Email</th>
		<th>Address</th>
		<th>Telephone</th>
		<th>Action</th>
		</tr>
<c:forEach var="tea" items="${listEmployee}">
	<tr>
	<td>${tea.name}</td>
	<td>${tea.email}</td>
	<td>${tea.address}</td>
	<td>${tea.telephone}</td>
	<td><a href="deleteEmployee?id=${tea.id}">删除</a></td>
	<td><a href="doupdate?id=${tea.id}">编辑</a></td>
	</tr>
</c:forEach></table></div>
 
</body>
</html>