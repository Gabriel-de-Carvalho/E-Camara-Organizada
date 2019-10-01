package com.camara.demo.pessoa;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.camara.demo.partido.Partido;

@Entity
@Table(name = "deputado")
public class Deputado extends Pessoa{
	
	String dataInicio;
	int leis = 0;
	
	public Deputado() {
		
	}
	
	public Deputado(String nome, String dni, String estado, String interesses, Partido partido, String dataInicio) {
		super(nome, dni, estado, interesses, partido);
		this.dataInicio = dataInicio;
		
	}
	
	public String getData() {
		return dataInicio;
	}
	
	@Override
	public String toString() {
		return (nome + " - " + dni + " " + estado + " - " + partido + " - " + interesses.toString() + " - " +  leis + "leis");
	}
}
