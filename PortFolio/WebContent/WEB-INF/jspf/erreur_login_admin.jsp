<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body text="red" bgcolor="orange">
	<h2>Authentification incorrect, veuillez recommencer</h2>
	<hr>
	<form method="post" action="j_security_check">
	<h3>
		Login : <input type="text" name="j_username">
	</h3>
	<h3>
		Password : <input type="password" name="j_password">
	</h3>
	<hr>
	<input type="submit" value="Valider">
	</form>
</body>
</html>