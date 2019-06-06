package progettosilph.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import progettosilph.model.Funzionario;
import progettosilph.service.FunzionarioServices;

@WebServlet("/conferma")
public class ConfermaController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	// cazzucazzu
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		FunzionarioServices FunzionarioServices = new FunzionarioServices();		//rappresenta i servizi(del sistema) per lo Funzionario
		Funzionario Funzionario = new Funzionario();
		FunzionarioForm FunzionarioForm = (FunzionarioForm)session.getAttribute("FunzionarioForm");
		Funzionario.setNome(FunzionarioForm.getNome());
		Funzionario.setCognome(FunzionarioForm.getCognome());
				
		FunzionarioServices.salvaFunzionario(Funzionario);
		
		String nextPage = "/fine.jsp";
		
		//i dati verranno salvati sul DB
		
		//Gestione risposte 
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		return;
		
	}
	
}
