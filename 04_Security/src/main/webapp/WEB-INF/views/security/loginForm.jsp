<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	
	<form action="/login_check" method="post">
		ID : <input name="username"> <br><br>
		PW : <input type="password" name="password"> <br>
		<input type="submit" value="LOGIN"/>
	</form>
</body>
</html>