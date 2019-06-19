package progettosilph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import progettosilph.model.Fotografia;
import progettosilph.repository.FotografiaRepository;

public class FotografiaServices {

	@Autowired //crea da solo l'oggetto e assegnalo alla variabile
	private FotografiaRepository fotografiaRepository;
	
	@Transactional
	public Fotografia inserisci(Fotografia foto) {
		return fotografiaRepository.save(foto);
	}

	@Transactional
	public List<Fotografia> tutti() {
		return (List<Fotografia>) fotografiaRepository.findAll();
	}

	public Fotografia fotografiaPerId(Long id) {
		return this.fotografiaRepository.findById(id).get();
	}
}
