<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NativeQuery</title>
</head>
<body>
	<h1>JSQL - NativeQuery - @Query</h1>
	
	<c:forEach var="member" items="${members}">
		아이디(ID) : ${member.id} <br>
		이름(NAME) : ${member.name} <br>
		이메일(EMAIL) : ${member.email} <br><br>
	</c:forEach>
</body>
</html>