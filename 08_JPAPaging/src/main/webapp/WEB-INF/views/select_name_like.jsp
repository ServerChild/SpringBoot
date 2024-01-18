<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select Name Like</title>
</head>
<body>
	<h1>Member JPA #01 - SELECT NAME LIKE</h1>
	
	<c:forEach items="${members}" var="member">
		아이디: ${member.id}<br>
		이름 : ${member.name}<br>
		날짜 : ${member.email}<br><br>
	</c:forEach>
</body>
</html>