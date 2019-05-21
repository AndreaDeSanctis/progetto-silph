package controller;

import java.io.IOException;

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

@WebServlet("/Conferma")
public class ConfermaController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		StudenteServices studenteServices = new StudenteServices();		//rappresenta i servizi(del sistema) per lo studente
		Studente studente = new Studente();
		StudenteForm studenteForm = (StudenteForm)session.getAttribute("studenteForm");
		studente.setNome(studenteForm.getNome());
		studente.setCognome(studenteForm.getCognome());
				
		studenteServices.salvaStudente(studente);
		
		String nextPage = "/fine.jsp";
		
		//i dati verranno salvati sul DB
		
		//Gestione risposte 
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		return;
		
	}
	
}

