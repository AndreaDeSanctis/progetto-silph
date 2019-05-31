package service;

import java.util.ArrayList;
import java.util.List;

import model.Funzionario;

public class FunzionarioServices {

	public void salvaFunzionario(Funzionario Funzionario) {
		//TODO
	}

	public List<Funzionario> listaFunzionari(){
		List<Funzionario> funzionari = new ArrayList<>() ;

		Funzionario f1 = new Funzionario();
		f1.setId(1l);
		f1.setNome("Andrea");
		f1.setCognome("De Sanctis");
		funzionari.add(f1);

		Funzionario f2 = new Funzionario();
		f2.setId(2l);
		f2.setNome("Daniele");
		f2.setCognome("D'Amico");
		funzionari.add(f2);

		Funzionario f3 = new Funzionario();
		f3.setId(3l);
		f3.setNome("Federico");
		f3.setCognome("Giuliana");
		funzionari.add(f3);

		return funzionari;
	}
}