package progettosilph.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "funzionari")
public class Funzionario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", columnDefinition = "serial", nullable = false)
	private long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cognome")
	private String cognome;
	
	@Column(name = "username", unique=true)
	private String username;
	
	@Column(name = "password")
	private String password;
	
    @Column(name = "role")
    protected String role;
	
	/**
     * Constructor
     *
     * @param id The id of this Funzionario
     * @param nome The name of this Funzionario
     * @param cognome The surname  of this Funzionario
     * @param username The username of this Funzionario for authentication
     * @param password The password of this Funzionario for authentication
     */
	public Funzionario(Long id, String nome, String cognome, String username, String password) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.password = password;
    }
	 /**
     * Empty Constructor
     */
     public Funzionario() {
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
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public boolean checkPassword(Funzionario funzionario) {
		String passwordDaVerificare = funzionario.getPassword();
		return this.password.equals(passwordDaVerificare);
}
	
	
	
}
