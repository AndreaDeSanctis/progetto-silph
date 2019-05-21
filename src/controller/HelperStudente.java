package controller;

import javax.servlet.http.HttpServletRequest;

public class HelperStudente {
	public boolean isValid(HttpServletRequest request) {
		
		
		String nome = request.getParameter("nome").trim();
		String cognome = request.getParameter("cognome").trim();
		/*String matricola = request.getParameter("matricola");
		String DataDiNascita = request.getParameter("DataDiNascita");*/
		
		boolean corretto=true;
		
		
		//CASO DI STRINGA VUOTA
		if(nome.equals("")) {
			String messError = "Nome campo Obbligatorio";
			request.setAttribute("nomeError", messError );
			
			corretto=false;
		}
		
		if(cognome.equals("")) {
			String messError = "Cognome campo Obbligatorio";
			request.setAttribute("cognomeError",messError);
			corretto=false;
		}
		return corretto;
		
	}
}
