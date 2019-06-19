package progettosilph.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fotografia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	String categoria;
	private long idFotografo;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getFotografo() {
		return idFotografo;
	}
	public void setFotografo(long idFotografo) {
		this.idFotografo = idFotografo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}	
}
