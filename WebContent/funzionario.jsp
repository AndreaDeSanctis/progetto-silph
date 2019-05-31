<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="CSS/loginFunzionario.css" />
<meta charset="ISO-8859-1" />
<title>Funzionario</title>
</head>
<body>
	<form action="StudenteController" method="post">

		Email: <input type="text" name="email" value="${param['email']}" /> <span
			class="error"> ${nomeError} </span>
		<div></div>


		Cognome: <input type="text" name="cognome" value="${param['cognome']}" />
		<span class="error"> ${cognomeError} </span>

		<div></div>



		<div>
			<input type="submit" name="submit" value="invia" />
		</div>


	</form>
</body>
</html>