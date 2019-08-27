package com.camara.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Comissao {
	
	@Id @Column
	private String id;
	@Column
	private String deputados;

	public Comissao() {
		
	}
	
	public Comissao(String id, String deputados) {
		this.id = id;
		this.deputados = deputados;
	}
	

	public String getDeputados() {
		return deputados;
	}


	public String getId() {
		return id;
	}


	public String[] getListaDeputados() {
		return deputados.split(",");
	}

	
	
}
