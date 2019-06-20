package progettosilph;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import progettosilph.model.Fotografia;
import progettosilph.model.Fotografo;
import progettosilph.model.Funzionario;
import progettosilph.model.Richiesta;
import progettosilph.repository.FotografiaRepository;
import progettosilph.repository.FotografoRepository;
import progettosilph.repository.FunzionarioRepository;
import progettosilph.repository.RichiestaRepository;

@Component
public class DBPopulation implements ApplicationRunner {

	@Autowired
	private FotografiaRepository fotografiaRepository;
	@Autowired
	private FotografoRepository fotografoRepository;
	@Autowired
	private FunzionarioRepository funzionarioRepository;
	@Autowired
	private RichiestaRepository richiestaRepository;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.deleteAll();
        this.populateDB();
	}
	
	private void deleteAll() {
        System.out.println("Deleting all users from DB...");
        fotografiaRepository.deleteAll();
        fotografoRepository.deleteAll();
        funzionarioRepository.deleteAll();
        richiestaRepository.deleteAll();
        System.out.println("Done");
    }
	
	private void populateDB() throws IOException, InterruptedException {

        System.out.println("Storing users...");

        /*inserimento funzionari*/
        Funzionario f1 = new Funzionario("Dimitri", "Affri", "dimitriaffri", "dapass", "ADMIN");
//        String pwd1 = new BCryptPasswordEncoder().encode("dapass");
//        f1.setPassword(pwd1);
        f1 = this.funzionarioRepository.save(f1);

        Funzionario f2 = new Funzionario("Andrea", "De Sanctis", "andreadesanctis", "adspass", "ADMIN");
//        String pwd2 = new BCryptPasswordEncoder().encode("adspass");
//        f2.setPassword(pwd2);
        f2 = this.funzionarioRepository.save(f2);
        
        Funzionario f3 = new Funzionario("Michele", "Capezzani", "michelecapezzani", "mcpass", "ADMIN");
//        String pwd3 = new BCryptPasswordEncoder().encode("mcpass");
//        f3.setPassword(pwd3);
        f3 = this.funzionarioRepository.save(f3);
        
        /*inserimento fotografi */
        Fotografo fg1 = new Fotografo("giacomo", "gianfelici");
        fg1 = this.fotografoRepository.save(fg1);
        
        Fotografo fg2 = new Fotografo("marco", "santolini");
        fg2 = this.fotografoRepository.save(fg2);

        Fotografo fg3 = new Fotografo("alberto", "papiri");
        fg3 = this.fotografoRepository.save(fg3);
        
        /*inserimento fotografie*/
        Fotografia foto1 = new Fotografia("ester", "persone", fg1.getId());
        foto1 = this.fotografiaRepository.save(foto1);
        Fotografia foto2 = new Fotografia("cina", "persone", fg1.getId());
        foto2 = this.fotografiaRepository.save(foto2);        
        Fotografia foto3 = new Fotografia("sleep", "persone", fg1.getId());
        foto3 = this.fotografiaRepository.save(foto3);        
        Fotografia foto4 = new Fotografia("lapidi", "luoghi", fg1.getId());
        foto4 = this.fotografiaRepository.save(foto4);
        
        Fotografia foto5 = new Fotografia("bosco", "natura", fg2.getId());
        foto5 = this.fotografiaRepository.save(foto5);
        Fotografia foto6 = new Fotografia("campagna", "natura", fg2.getId());
        foto6 = this.fotografiaRepository.save(foto6);
        Fotografia foto7 = new Fotografia("lago", "natura", fg2.getId());
        foto7 = this.fotografiaRepository.save(foto7);
        Fotografia foto8 = new Fotografia("montagna", "natura", fg2.getId());
        foto8 = this.fotografiaRepository.save(foto8);
        
        Fotografia foto9 = new Fotografia("girasoli", "natura", fg3.getId());
        foto9 = this.fotografiaRepository.save(foto9);
        Fotografia foto10 = new Fotografia("campi", "natura", fg3.getId());
        foto10 = this.fotografiaRepository.save(foto10);
        Fotografia foto11 = new Fotografia("chiesa", "citta", fg3.getId());
        foto11 = this.fotografiaRepository.save(foto11);
        Fotografia foto12 = new Fotografia("venezia", "citta", fg3.getId());
        foto12 = this.fotografiaRepository.save(foto12);
        
        /*inserimento richieste*/
        Richiesta rq1 = new Richiesta("perPaolo");
        rq1.getFotografie().add(foto1);
        rq1.getFotografie().add(foto5);
        rq1.getFotografie().add(foto9);
        rq1 = this.richiestaRepository.save(rq1);
        
        Richiesta rq2 = new Richiesta("perValter");
        rq2.getFotografie().add(foto2);
        rq2.getFotografie().add(foto10);
        rq2.getFotografie().add(foto12);
        rq2 = this.richiestaRepository.save(rq2);

        System.out.println("Done.\n");
    }

}
