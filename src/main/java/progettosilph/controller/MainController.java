package progettosilph.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import progettosilph.model.Fotografia;
import progettosilph.model.Fotografo;
import progettosilph.model.Funzionario;

@Controller
public class MainController {

	@RequestMapping(value = "/addFunzionario", method = RequestMethod.GET)
	public String addFunzionario(Model model) {
		model.addAttribute("funzionario", new Funzionario());
		return "signupFunzionario.html";
	}
	
	@RequestMapping(value = "/loginFunzionario", method = RequestMethod.GET)
	public String loginFunzionario(Model model) {
		model.addAttribute("funzionario", new Funzionario());
		return "login.html";
	}
	
	@RequestMapping(value = "/visualizzaFotografi", method = RequestMethod.GET)
	public String visualizzaFotografi(Model model) {
		model.addAttribute("fotografo", new Fotografo());
		return "fotografi.html";
	}
	
	@RequestMapping(value = "/visualizzaAlbum", method = RequestMethod.GET)
	public String visualizzaAlbum(Model model) {
		model.addAttribute("fotografia", new Fotografia());
		return "album.html";
	}
}
