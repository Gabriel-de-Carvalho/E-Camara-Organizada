package com.camara.demo.pessoa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.camara.demo.partido.Partido;



@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@Table(name = "pessoa")
public class Pessoa {
	
	protected String nome;
	
	@Id @Column(name="dni") protected String dni;
	protected String estado;
	protected String interesses;
	@OneToMany
	protected Partido partido;
	
	public Pessoa() {
		
	}
	
	
	public Pessoa(String nome, String dni, String estado, String interesses, Partido partido) {
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


	public Partido getPartido() {
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
