package com.camara.demo.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Deputado")
public class Deputado extends Pessoa{
	
	String dataInicio;
	int leis = 0;
	
	public Deputado() {
		
	}
	
	public Deputado(String nome, String dni, String estado, String interesses, String partido, String dataInicio) {
		super(nome, dni, estado, interesses, partido);
		this.dataInicio = dataInicio;
		
	}
	
	@Override
	public String toString() {
		return (nome + " - " + dni + " " + estado + " - " + partido + " - " + interesses.toString() + " - " +  leis + "leis");
	}
}
