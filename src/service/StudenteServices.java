package service;

import java.util.List;
import java.util.ArrayList;

import model.Studente;

//servizi del nostro sistema per lo studewntte
public class StudenteServices {

	public void salvaStudente(Studente studente) {
		//TODO
	}
	
	public List<Studente> listaStudenti(){
		List<Studente> studenti = new ArrayList<>() ;
		
		Studente s1 = new Studente();
		s1.setId(1l);
		s1.setNome("Andrea");
		s1.setCognome("De Sanctis");
		studenti.add(s1);
		
		Studente s2 = new Studente();
		s2.setId(2l);
		s2.setNome("Daniele");
		s2.setCognome("D'Amico");
		studenti.add(s2);
		
		Studente s3 = new Studente();
		s3.setId(3l);
		s3.setNome("Federico");
		s3.setCognome("Giuliana");
		studenti.add(s3);
		
		return studenti;
	}
}
