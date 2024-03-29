package progettosilph.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "richieste")
public class Richiesta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "nome", unique=true)
	private String nome;
	
	@OneToMany
	private List<Fotografia> fotografie = new LinkedList<>();
	
	public Richiesta(String nome) {
		super();
		this.nome = nome;
	}
	
	public Richiesta() {
		super();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Fotografia> getFotografie() {
		return fotografie;
	}
	public void setFotografie(List<Fotografia> fotografie) {
		this.fotografie = fotografie;
	}
	
	
}
