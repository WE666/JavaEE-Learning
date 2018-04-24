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
	<h1>User List</h1>
	<h3>
		<a href="add">Add User</a>
	</h3>
	<table border="1">
		<tr>
		<th>UserName</th>
		<th>Password</th>
		<th>Age</th>
		<th>操作</th>
		</tr>
<c:forEach var="user" items="${user}">
	<tr>
	<td>${user.userName}</td>
	<td>${user.password}</td>
	<td>${user.age}</td>
	<td><a href="deleteUser?id=${user.id}">删除</a></td>
	<td><a href="updateUser?id=${user.id}">编辑</a></td>
	</tr>
</c:forEach></table></div>
 
</body>
</html>