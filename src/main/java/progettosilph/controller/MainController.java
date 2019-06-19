package progettosilph.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import progettosilph.model.Funzionario;
import progettosilph.service.FotografiaServices;
import progettosilph.service.FotografoServices;

@Controller
public class MainController {

	@Autowired
	private FotografoServices fotografoService;
	
	@Autowired
	private FotografiaServices fotografiaService;
	
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
		model.addAttribute("fotografi", this.fotografoService.tutti());
		return "fotografi.html";
	}
	
	@RequestMapping(value = "/visualizzaFotografie", method = RequestMethod.GET)
	public String visualizzaFotografie(Model model) {
		model.addAttribute("fotografie", this.fotografiaService.tutti());
		return "album.html";
	}
	
	@RequestMapping(value = "/visualizzaAlbum", method = RequestMethod.GET)
	public String visualizzaAlbum(Model model) {
		model.addAttribute("album", this.fotografiaService.tutti());
		return "album.html";
	}
}
