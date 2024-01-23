<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
	<form action="minsert" method="post">
		ID : <input name="id"><p/>
		이름 : <input name="name"><p/>
		비밀번호 : <input type="password" name="password"><p/>
		이메일 : <input type="email" name="email"><p/>
		
		<button>회원가입</button>
	</form>
	
	<form action="binsert" method="post">
		제목 : <input name="title"><p/> 
		내용 : <input name="content"><p/>
		
		<button>글 등록</button>
	</form>
</body>
</html>