package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Studente;
import service.StudenteServices;


@WebServlet("/StudenteController")
public class StudenteController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nextPage;


		HelperStudente helperStud = new HelperStudente();
		StudenteForm studenteForm = new StudenteForm();
		HttpSession session = request.getSession();

		//se valido
		if(helperStud.isValid(request)) {
			studenteForm.setNome(request.getParameter("nome").toUpperCase());
			studenteForm.setCognome(request.getParameter("cognome").toUpperCase());
			session.setAttribute("studenteForm",studenteForm);
			nextPage ="/risposta.jsp";
		}


		//se ci sono errori
		else {
			nextPage="/newStudente.jsp";		//ricarica la pagina
		}

		//in caso senza cookies
		response.encodeURL(nextPage);

		//Gestione risposte andando alla pagina opportuna
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		return;

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nextPage = "/studenti.jsp";
		StudenteServices studenteServices = new StudenteServices();
		List<Studente> studenti = studenteServices.listaStudenti();
		
		request.setAttribute("studenti", studenti);
		
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		return;
	}

}

