<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
</head>
<body>
	<h1>JSQL(JPQL)_NativeQuery</h1>

	<a href="/selectByNameLike1?name=user">특정 단어에 해당하는 이름 조회(JPQL 1)</a><p/><br>
	<a href="/selectByNameLike2?name=user">특정 단어에 해당하는 이름 조회(JPQL 2)</a><p/><br>
	<a href="/selectByNameLike3?name=user&page=2">특정 단어에 해당하는 이름 조회(JPQL 3 & Page 3)</a><p/><br>
	<a href="/selectByNameLike4?name=user">특정 단어에 해당하는 이름 조회(Native SQL)</a><p/><br>
</body>
</html>