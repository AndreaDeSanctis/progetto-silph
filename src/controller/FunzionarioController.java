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

import model.Funzionario;
import service.FunzionarioServices;

@WebServlet("/funzionarioController")
public class FunzionarioController extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nextPage;
		
		HelperFunzionario helperFunz = new HelperFunzionario();
		FunzionarioForm funzionarioForm = new FunzionarioForm();
		HttpSession session = request.getSession();
		
		//se valido
		if(helperFunz.isValid(request)) {
			funzionarioForm.setNome(request.getParameter("nome").toUpperCase());
			funzionarioForm.setCognome(request.getParameter("cognome").toUpperCase());
			session.setAttribute("funzionarioForm", funzionarioForm);
			nextPage = "/fotografo.jsp";
		}
		
		else {
			nextPage = "/newFunzionario.jsp";
		}
		
		//in caso senza cookies
		response.encodeURL(nextPage);
		
		//gestione risposte andando alla pagina opportuna
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		return;
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nextPage = "/funzionari.jsp";
		FunzionarioServices funzionarioServ = new FunzionarioServices();
		List<Funzionario> funzionari = funzionarioServ.listaFunzionari();
		
		request.setAttribute("funzionari", funzionari);
		
		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		return;
	}
	
	

}
