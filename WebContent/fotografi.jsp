<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8" />
<title>Fotografi - Silph Srl</title>
<meta name="description" content="fotografi" />
<meta name="author" content="Andrea De Sanctis, Michele Capezzani" />
<link rel="stylesheet" type="text/css" href="CSS/fotografi.css" />
<link href='http://fonts.googleapis.com/css?family=Ubuntu:400,700'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300'
	rel='stylesheet' type='text/css'>
<link rel="shortcut icon" href="logo2.ico" />
</head>

<body>
	<section>
		<header>
			<a href="index.html"> <img src="images/logo2.jpg" alt="logo sito">
			</a>
			<h1>
				<a href="index.html">Silph Srl</a>
			</h1>
			<div class="login">
				<a href="loginFunzionario.jsp">Login</a>
			</div>
		</header>

		<div class="sottotitolo">
			<h2>I nostri fotografi:</h2>
		</div>

		<c:forEach var="fotografo" items="${fotografi}">
			<table class="fotografo">
				<tr>
					<td><a href="schedaFotografo.jsp"> <img
							src="images/fotografi/${param['name']}_${param['surname']}.jpg"
							alt="immagine fotografo"> <span class="scritta">${param['name']}
								${param['surname']}</span>
					</a></td>
				</tr>
			</table>
		</c:forEach>

	</section>
</body>

</html>