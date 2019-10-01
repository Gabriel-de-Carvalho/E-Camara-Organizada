package com.camara.demo.comissao;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.camara.demo.pessoa.Deputado;

@Entity
public class Comissao {
	
	@Id @Column
	private String id;
	@Column @OneToMany
	private ArrayList<Deputado> deputados;

	public Comissao() {
		
	}
	
	public Comissao(String id, ArrayList<Deputado> deputados) {
		this.id = id;
		this.deputados = deputados;
	}
	

	public ArrayList<Deputado> getDeputados() {
		return deputados;
	}


	public String getId() {
		return id;
	}


	public String[] getListaDeputados() {
		String[] allDeputs = new String[deputados.size()];
		for(int i = 0; i < allDeputs.length ; i++) {
			allDeputs[i] = deputados.get(i).getNome();
			
		}
		return allDeputs;
		
	}

	
	
}
