package com.camara.demo.models;

import javax.persistence.Entity;

@Entity
public class ProjetoLei extends Projeto{
	private boolean status;
	
	public ProjetoLei(String dni, int ano, String ementa, String interesses, String url, boolean status) {
		super(dni, ano, ementa, interesses, url);
		this.status = status;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public String toString() {
		return (sequencia + "/" + ano);
	}
}
