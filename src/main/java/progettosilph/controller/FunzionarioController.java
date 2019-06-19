package progettosilph.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import progettosilph.model.Fotografia;
import progettosilph.model.Fotografo;
import progettosilph.model.Funzionario;
import progettosilph.service.FunzionarioServices;
import progettosilph.service.FunzionarioValidator;

@Controller
public class FunzionarioController {

	@Autowired
	private FunzionarioValidator funzValidator;

	@Autowired
	private FunzionarioServices funzService;

	@RequestMapping(value = "/signupFunzionario", method = RequestMethod.POST)
	public String newFunzionario(@Valid @ModelAttribute("funzionario") Funzionario funz,
			Model model, BindingResult bindingResult) {
		this.funzValidator.validate(funz, bindingResult);

		if(!bindingResult.hasErrors()) {
			this.funzService.inserisci(funz);
			model.addAttribute("funzionari", this.funzService.tutti());
			return "funzionari.html";
		} else {
			return "signupFunzionario.html";
		}
	}

	//il valore che ci aspettiamo nel parametro id è quello specifico contenuto in value
	@RequestMapping(value = "/funzionario/{id}", method = RequestMethod.GET)
	public String getFunzionario(@PathVariable ("id") Long id, Model model) {
		if(id != null) {
			model.addAttribute("funzionario", this.funzService.funzionarioPerId(id));
			return "funzionario.html"; 
		} else {
			model.addAttribute("funzionari", this.funzService.tutti());
			return "funzionari.html"; 
		}
	}
	
	@RequestMapping("/addFunzionario")
	public String addFunzionario(Model model) {
		model.addAttribute("funzionario", new Funzionario());
		return "signupFunzionario.html";
	}
	
	@RequestMapping("/loginFunzionario")
	public String loginFunzionario(Model model) {
		model.addAttribute("funzionario", new Funzionario());
		return "login.html";
	}
	
	@RequestMapping("/visualizzaFotografi")
	public String visualizzaFotografi(Model model) {
		model.addAttribute("fotografo", new Fotografo());
		return "fotografi.html";
	}
	
	@RequestMapping("/visualizzaAlbum")
	public String visualizzaAlbum(Model model) {
		model.addAttribute("fotografia", new Fotografia());
		return "album.html";
	}
}
