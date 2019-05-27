<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Login - Silph Srl</title>
<meta name="description" content="login" />
<meta name="author" content="Andrea De Sanctis, Michele Capezzani" />
<link rel="stylesheet" type="text/css" href="CSS/loginFunzionario.css" />
<link href='http://fonts.googleapis.com/css?family=Ubuntu:400,700'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300'
	rel='stylesheet' type='text/css'>
<link rel="shortcut icon" href="favicon.ico" />
</head>

<body>
	<form action="funzionarioController" method="post">

		<header>
			<h1>
				<a href="index.html">Silph Srl</a>
			</h1>
			<div class="login">
				<a href="loginFunzionario.jsp">Login</a>
			</div>
		</header>

		<article>
			<div class="logintab">
				Email: <input type="text" name="email" placeholder="Email"
					value="${param['email']}" /> <span class="error">
					${emailErr} </span> <br> Password:&nbsp; <input type="password"
					name="password" placeholder="Password" value="${param['password']}" />
				<span class="error"> ${passwordErr} </span> <input type="submit"
					value="Accedi">
			</div>
		</article>
	</form>

</body>

</html>