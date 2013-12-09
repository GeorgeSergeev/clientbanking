<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf8">
	<title>Title</title>
</head>


<h3>List 12345</h3>
	<table class="data">
		<tr>
			<th>name</th>
			<th>login</th>
			<th>role</th>
		</tr>
		<c:forEach items="${usersList}" var="user">		
			<tr>
				<td>${user.name}</td>
				<td>${user.login}</td>
				<td>${user.role}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>