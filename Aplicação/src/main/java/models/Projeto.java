package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Projeto {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int sequencia;
	
	@Column private String autor;
	@Column private int ano;
	@Column private String codigo;
	@Column private String ementa;
	@Column private String interesses;
	@Column private String situacao;
	@Column private String endereco;
	
	public Projeto() {
		
	}
	
	public Projeto(String dni, int ano, String ementa, String interesses, String url) {
		this.autor = dni;
		this.ano = ano;
		this.ementa = ementa;
		this.interesses = interesses;
		this.endereco = url;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public int getAno() {
		return ano;
	}
	
	public String getEmenta() {
		return ementa;
	}
	
	public String[] getListaInteresses() {
		return interesses.split(",");
	}
	
	public String getSituacao() {
		return situacao;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
}
