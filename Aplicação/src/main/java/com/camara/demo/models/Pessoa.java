package com.camara.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;



@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@Table(name = "pessoa")
public class Pessoa {
	
	protected String nome;
	
	@Id protected String dni;
	protected String estado;
	protected String interesses;
	protected String partido;
	
	public Pessoa() {
		
	}
	
	
	public Pessoa(String nome, String dni, String estado, String interesses, String partido) {
		this.nome = nome;
		this.dni = dni;
		this.estado = estado;
		this.interesses = interesses;
		this.partido = partido;
	}
	
	public Pessoa(String nome, String dni, String estado, String interesses) {
		this.nome = nome;
		this.dni = dni;
		this.estado = estado;
		this.interesses = interesses;
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
		return interesses.split(",");
	}
	
	public String getListaInteresses() {
		return interesses;
	}


	public String getPartido() {
		return partido;
	}


	public String toString() {
		if(partido == null) {
			return (nome + " - " + dni + " / " + estado + " - " + interesses.toString());
		} else {
			return (nome + " - " + dni + " / " + estado + " - " + partido + " - " + interesses.toString());
		}
	}
	
}
