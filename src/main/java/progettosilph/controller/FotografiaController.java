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
import progettosilph.service.FotografiaServices;
import progettosilph.service.FotografiaValidator;

@Controller
public class FotografiaController {

	@Autowired
	private FotografiaValidator fotografiaValidator;

	@Autowired
	private FotografiaServices fotografiaService;

	@RequestMapping(value = "/fotografia", method = RequestMethod.POST)
	public String newFotografia(@Valid @ModelAttribute("Fotografia") Fotografia fotografia,
			Model model, BindingResult bindingResult) {
		this.fotografiaValidator.validate(fotografia, bindingResult);

		if(!bindingResult.hasErrors()) {
			this.fotografiaService.inserisci(fotografia);
			model.addAttribute("album", this.fotografiaService.tutti());
			return "album.html";
		} else {
			return "inserisciFotografia.html";
		}
	}

	//il valore che ci aspettiamo nel parametro id è quello specifico contenuto in value
	@RequestMapping(value = "/fotografia/{id}", method = RequestMethod.GET)
	public String getFotografia(@PathVariable ("id") Long id, Model model) {
		if(id != null) {
			model.addAttribute("fotografia", this.fotografiaService.fotografiaPerId(id));
			return "fotografia.html"; 
		} else {
			model.addAttribute("fotografi", this.fotografiaService.tutti());
			return "album.html"; 
		}
	}
	
	@RequestMapping("/addFotografia")
	public String addFotografia(Model model) {
		model.addAttribute("fotografia", new Fotografia());
		return "inserisciFotografia.html";
	}
}
