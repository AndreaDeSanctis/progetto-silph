<!DOCTYPE>
<html>
<head> <link rel="stylesheet" href="CSS/style.css"/>
<meta charset="ISO-8859-1" />
<title>Studente</title>
</head>
<body>
	<form action="StudenteController" method="post">
		
			Nome: <input type="text" name="nome" value="${param["nome"]}" /> 
			 <span class="error"> ${nomeError} </span>
		<div></div>

		
			Cognome: <input type="text" name="cognome" value="${param["cognome"]}" /> 
			<span class="error"> ${cognomeError} </span>

		<div></div>



		<div>
			<input type="submit" name="submit" value="invia" />
		</div>


	</form>
</body>
</html>