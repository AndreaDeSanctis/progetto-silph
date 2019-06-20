package progettosilph.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fotografie")
public class Fotografia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	String nome;
	String categoria;
	private long idFotografo;
	
	public Fotografia(String nome, String categoria, long idFotografo) {
		super();
		this.nome = nome;
		this.categoria = categoria;
		this.idFotografo = idFotografo;
	}
	
	public Fotografia() {
		super();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdFotografo() {
		return idFotografo;
	}
	public void setIdFotografo(long idFotografo) {
		this.idFotografo = idFotografo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	
}
