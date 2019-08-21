package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Comissao {
	String deputados;
	@Id
	String comissao;

	public Comissao() {
		
	}
	
	public Comissao(String nome, String participantes) {
		this.comissao = nome;
		this.deputados = participantes;
	}
	
	public String[] getListaDeputados() {
		return deputados.split(",");
	}
	
	public String getTema() {
		return comissao;
	}
	
	
}
