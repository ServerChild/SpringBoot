<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Insert</title>
</head>
<body>
	<h1>게시판 글 등록 성공</h1>
	
	제목 : ${board.title} <br>
	내용 : ${board.content} <br>
	<!-- board.member로 적으면 전체 객체가 값으로 들어옴 -->
	작성자 : ${board.member} <br>
</body>
</html>