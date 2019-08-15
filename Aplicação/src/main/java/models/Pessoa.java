package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pessoa {
	
	protected String nome;
	@Id
	protected	String dni;
	protected String estado;
	protected String[] interesses;
	protected String partido;
	
	public Pessoa() {
		
	}
	
	public Pessoa(String nome, String dni, String estado, String interesses) {
		this.nome = nome;
		this.dni = dni;
		this.estado = estado;
		this.interesses = interesses.split(",");
	}
	
	public Pessoa(String nome, String dni, String estado, String interesses, String partido) {
		this.nome = nome;
		this.dni = dni;
		this.estado = estado;
		this.interesses = interesses.split(",");
		this.partido = partido;
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDni() {
		return dni;
	}

	public String getEstado() {
		return estado;
	}


	public String[] getInteresses() {
		return interesses;
	}


	public String getPartido() {
		return partido;
	}


	public String toString() {
		if(partido == null) {
			return (nome + " - " + dni + " " + estado + " - " + interesses.toString());
		} else {
			return (nome + " - " + dni + " " + estado + " - " + partido + " - " + interesses.toString());
		}
	}
	
}
