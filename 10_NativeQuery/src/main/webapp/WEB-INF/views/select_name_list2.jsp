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
	<h1>JSQL - NativeQuery - @Query + Paging</h1>
	
	총 글 개수(totalElements) : ${totalElements} <br>
	총 페이지(totalPages) : ${totalPages} <br>
	한 페이지당 글 개수(size) : ${size} <br>
	현재 페이지(pageNumber) : ${pageNumber} <br>
	현재 페이지 글 개수(numberOfElements) : ${numberOfElements} <br><br>
	<hr>
	
	<c:forEach var="member" items="${members}">
		아이디(ID) : ${member.id} <br>
		이름(NAME) : ${member.name} <br>
		이메일(EMAIL) : ${member.email} <br><br>
	</c:forEach>
	
</body>
</html>