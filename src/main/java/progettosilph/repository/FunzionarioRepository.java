package progettosilph.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import progettosilph.model.Funzionario;

public interface FunzionarioRepository extends CrudRepository<Funzionario, Long> {

	//findByDatiDaRecuperare (sarebbero le variabili nel db)
	public List<Funzionario> findByNome(String nome);
	public List<Funzionario> findByNomeAndCognome(String nome, String cognome);
}
