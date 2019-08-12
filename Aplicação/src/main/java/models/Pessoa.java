package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pessoa {
	
	private String nome;
	@Id
	private	String dni;
	private String estado;
	private String[] interesses;
	private String partido;
	
	public Pessoa() {
		
	}
	
	public Pessoa(String nome, String dni, String estado, String[] interesses) {
		this.nome = nome;
		this.dni = dni;
		this.estado = estado;
		this.interesses = interesses;
	}
	
	public Pessoa(String nome, String dni, String estado, String[] interesses, String partido) {
		this.nome = nome;
		this.dni = dni;
		this.estado = estado;
		this.interesses = interesses;
		this.partido = partido;
	}
	
}
