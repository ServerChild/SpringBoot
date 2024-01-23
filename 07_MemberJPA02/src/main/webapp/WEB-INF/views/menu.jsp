<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
</head>
<body>
	<h1>Member JPA #02</h1>
	
	<a href="/insert">데이터 추가</a><p/><br>
	<a href="/selectAll">전체 조회 </a><p/><br>
	<a href="/selectById?id=1">특정 ID 조회</a><p/><br>
	<a href="/selectByEmail?email=test4@test.com">특정 Email 조회</a><p/><br>
	<a href="/selectByName?name=홍아무개">특정 이름 조회</a><p/><br>
	<a href="/selectByNameLike?name=김">특정 단어에 해당하는 이름 조회</a><p/><br>
	<a href="/selectByNameLikeDesc?name=김">특정 단어에 해당하는 이름 조회(내림차순)</a><p/><br>
	<a href="/selectByNameLikeSort?name=김">특정 단어에 해당하는 이름 조회(Sort)</a><p/><br>
</body>
</html>