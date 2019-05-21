<!DOCTYPE html>
<html>
<body>
	<p>
		Hai inserito questi dati
	</p>
	<p>
		<!--  uguale a request.getAttribute(nome) -->
		Nome: ${studenteForm.nome}
	</p>
	
	<p>
		Cognome: ${studenteForm.cognome}
	</p>
	
	<p>
		Sei sicuro di voler procedere con questi dati?
	</p>
	<p>
		<a href = "<%out.print(response.encodeURL("Conferma"));%>"> conferma definitiva</a>
	</p>
	
</body>
</html>