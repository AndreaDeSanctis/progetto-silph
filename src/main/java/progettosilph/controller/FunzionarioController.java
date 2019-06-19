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

import progettosilph.model.Funzionario;
import progettosilph.service.FunzionarioServices;
import progettosilph.service.FunzionarioValidator;

@Controller
public class FunzionarioController {

	@Autowired
	private FunzionarioValidator funzValidator;

	@Autowired
	private FunzionarioServices funzService;

	@RequestMapping(value = "/funzionario", method = RequestMethod.POST)
	public String newFunzionario(@Valid @ModelAttribute("funzionario") Funzionario funz,
			Model model, BindingResult bindingResult) {
		this.funzValidator.validate(funz, bindingResult);

		if(!bindingResult.hasErrors()) {
			this.funzService.inserisci(funz);
			model.addAttribute("funzionario", this.funzService.funzionarioPerId(funz.getId()));
			return this.getFunzionario(funz.getUsername(), model);
		} else {
			return "signupFunzionario.html";
		}
	}

	//il valore che ci aspettiamo nel parametro id è quello specifico contenuto in value
	@RequestMapping(value = "/funzionario/{username}", method = RequestMethod.GET)
	public String getFunzionario(@PathVariable ("username") String username, Model model) {
		if(username != null) {
			model.addAttribute("funzionario", this.funzService.funzionarioPerUsername(username));
			return "funzionario.html"; 
		} else {
			model.addAttribute("funzionari", this.funzService.tutti());
			return "funzionari.html"; 
		}
	}
	
}
