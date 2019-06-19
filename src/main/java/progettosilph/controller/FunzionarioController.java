package progettosilph.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
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
			return "funzionario.html";
			//			return this.getFunzionario(funz.getId(), model);
		} else {
			return "signupFunzionario.html";
		}
	}

	//il valore che ci aspettiamo nel parametro id è quello specifico contenuto in value
//	@RequestMapping(value = "/funzionario/{id}", method = RequestMethod.GET)
//	public String getFunzionario(@PathVariable ("id") Long id, Model model) {
//		if(id != null) {
//			UserDetails details = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//			String role = details.getAuthorities().iterator().next().getAuthority();    // get first authority
//			model.addAttribute("username", details.getUsername());
//			model.addAttribute("role", role);
//			model.addAttribute("funzionario", this.funzService.funzionarioPerId(id));
//			return "funzionario.html"; 
//		} else {
//			return "login.html"; 
//		}
//	}

	@RequestMapping(value = "/funzionario/{id}", method = RequestMethod.POST)
	public String loginFunzionario(@Valid @ModelAttribute("funzionario") Funzionario funzionario, 
			Model model, BindingResult bindingResult) {
		this.funzValidator.validate(funzionario, bindingResult);
		if(!bindingResult.hasErrors()) {
			Funzionario funzionarioInMemoria = this.funzService.funzionarioPerUsername(funzionario.getUsername());
			if((funzionarioInMemoria!=null)&&(funzionario.checkPassword(funzionarioInMemoria))) {
				model.addAttribute("funzionario", funzionarioInMemoria);
				return "funzionario.html";
			} else {
				return "login.html"; 
			}
		}
		else return "login.html";
	}
}
