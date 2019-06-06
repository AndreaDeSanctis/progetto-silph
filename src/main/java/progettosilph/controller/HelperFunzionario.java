package progettosilph.controller;

import javax.servlet.http.HttpServletRequest;

public class HelperFunzionario {

	public boolean isValid(HttpServletRequest request) {

		String nome = request.getParameter("nome").trim();
		String cognome = request.getParameter("cognome").trim();
		String username = request.getParameter("username").trim();

		boolean corretto = true;

		//CASO DI STRINGA VUOTA
		if(nome.equals("")) {
			String messError = "Il nome e' un campo obbligatorio";
			request.setAttribute("nomeError", messError );

			corretto=false;
		}

		if(cognome.equals("")) {
			String messError = "Il cognome e' un campo obbligatorio";
			request.setAttribute("cognomeError", messError);
			corretto=false;
		}

		if(username.equals("")) {
			String messError = "L'username e' un campo obbligatorio";
			request.setAttribute("usernameError", messError);
			corretto=false;
		}

		return corretto;
	}
}
