<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista studenti</title>
</head>
<body>
	<h1>Elenco Studenti</h1>
	<c:forEach var="studente" items="${studenti}">
		<table>
			<tr>
				<td>${studente.nome}</td>
				<td><a href="studenteController?id"></a>${studente.cognome}</td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>