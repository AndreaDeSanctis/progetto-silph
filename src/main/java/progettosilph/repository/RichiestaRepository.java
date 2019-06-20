package progettosilph.repository;

import org.springframework.data.repository.CrudRepository;

import progettosilph.model.Richiesta;

public interface RichiestaRepository extends CrudRepository<Richiesta, Long> {

	//findByDatiDaRecuperare (sarebbero le variabili nel db)
		public Richiesta findByNome(String nome);
}
