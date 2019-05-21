<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Login</title>

</head>

<body>
	<form action="funzionarioController" method="post">
	
	Nome: <input type="text" name="username" value= "${param['username']}"/>
	<span class="error">  ${usernameErr}
			</span>
	<div></div>
	
	Password: <input type="text" name="password" value= "${param['password']}"/>
	<span class="error">  ${passwordErr}  <%--  DA CRIPTARE --%>
			</span>
	<div></div>
	
	<input type="submit" value="Invio">
	</form>
</body>

</html>