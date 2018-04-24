<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<form action="update" method="post">  
 	
        姓名：<input type="text" name="name" value="${employee.name }"><br/>  
        邮箱：<input type="text" name="email" value="${employee.email }"><br/>  
          地址：<input type="text" name="address" value="${employee.address }"><br/>  
           电话：<input type="text" name="telephone" value="${employee.telephone }"><br/> 
           <input name="id" type="hidden" value="${employee.id}"/> 
     <p><input type="submit"  value="提交"></p>
    </form> 
</body>
</html>