package progettosilph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import progettosilph.model.Richiesta;
import progettosilph.repository.RichiestaRepository;

@Service
public class RichiestaServices {

	@Autowired //crea da solo l'oggetto e assegnalo alla variabile
	private RichiestaRepository requestRepository;
	
	@Transactional
	public Richiesta inserisci(Richiesta richiesta) {
		return requestRepository.save(richiesta);
	}

	@Transactional
	public List<Richiesta> tutti() {
		return (List<Richiesta>) requestRepository.findAll();
	}

	@Transactional
	public Richiesta richiestaPerId(Long id) {
		return this.requestRepository.findById(id).get();
	}
	
	@Transactional
	public Richiesta richiestaPerNome(String nome) {
		return this.requestRepository.findByNome(nome);
	}
}
