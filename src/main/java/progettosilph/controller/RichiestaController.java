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
import org.springframework.web.bind.annotation.RequestParam;

import progettosilph.model.Fotografia;
import progettosilph.model.Richiesta;
import progettosilph.service.FotografiaServices;
import progettosilph.service.RichiestaServices;
import progettosilph.service.RichiestaValidator;

@Controller
public class RichiestaController {

	@Autowired
	private RichiestaValidator richiestaValidator;

	@Autowired
	private RichiestaServices richiestaService;

	@Autowired
	private FotografiaServices fotografiaService;

	@RequestMapping(value = "/richiesta", method = RequestMethod.POST)
	public String newRichiesta(@Valid @ModelAttribute("richiesta") Richiesta richiesta,
			Model model, BindingResult bindingResult) {
		this.richiestaValidator.validate(richiesta, bindingResult);

		if(!bindingResult.hasErrors()) {
			this.richiestaService.inserisci(richiesta);
			model.addAttribute("richiesta", richiesta);
			return "richiesta.html";
		} else {
			return "inserisciRichiesta.html";
		}
	}

	@RequestMapping(value = "/richiesta/{nome}", method = RequestMethod.GET)
	public String getRichiesta(@PathVariable ("nome") String nome, Model model) {
		if(nome != null) {
			model.addAttribute("richiesta", this.richiestaService.richiestaPerNome(nome));
			return "richiesta.html"; 
		} else {
			model.addAttribute("richieste", this.richiestaService.tutti());
			return "richieste.html"; 
		}
	}
//	public String getRichiesta(@Valid @ModelAttribute("richiesta") Richiesta richiesta, 
//			Model model, BindingResult bindingResult) {
//		this.richiestaValidator.validate(richiesta, bindingResult);
//		if(!bindingResult.hasErrors()) {
//			Richiesta richiestaInMemoria = this.richiestaService.richiestaPerNome(richiesta.getNome());
//			if((richiestaInMemoria!=null)) {
//				model.addAttribute("richiesta", richiestaInMemoria);
//				return "richiesta.html";
//			} else {
//				return "richieste.html"; //"scegliRichiesta.html" ???
//			}
//		}
//		else return "richieste.html";
//	}

	@RequestMapping(value = "/addToRichiesta", method = RequestMethod.GET)
	public String addToRichiesta(Model model) {
		model.addAttribute("null", null);
		return "aggiungiAllaRichiesta.html";
	}
	
	@RequestMapping(value = "/addFotografia/{id}", method = RequestMethod.POST)
	public String addFotografia(Long id, @RequestParam("id") Long idFoto, Model model, BindingResult bindingResult) {

		Fotografia foto = this.fotografiaService.fotografiaPerId(idFoto);
		Richiesta richiesta = this.richiestaService.richiestaPerId(id);

		if(foto!=null && richiesta!=null) {
			richiesta.getFotografie().add(foto);
			model.addAttribute("richiesta", richiesta);
			return "richiesta.html";
		} else {
			return "aggiungiAllaRichiesta.html";
		}
	}
	
	@RequestMapping(value = "/seeRequest", method = RequestMethod.GET)
	public String seeRequest(Model model) {
		model.addAttribute("richieste", this.richiestaService.tutti());
		return "richieste.html";

	}
	
}
