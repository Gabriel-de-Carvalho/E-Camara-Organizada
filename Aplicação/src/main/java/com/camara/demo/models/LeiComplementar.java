package com.camara.demo.models;

import javax.persistence.Entity;

@Entity
public class LeiComplementar extends Projeto{

	private String artigos;
	
	public LeiComplementar(String dni, int ano, String ementa, String interesses, String url, String artigos) {
		super(dni, ano, ementa, interesses, url);
		this.artigos = artigos;
	}
	
	public String getArtigos() {
		return artigos;
	}
	
	public String toString() {
		return (sequencia + "/" + ano);
	}
}
