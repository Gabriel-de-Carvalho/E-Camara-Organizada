package com.camara.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class LeiComplementar{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	protected long id;
	
	@NotNull @Size(min = 1) @Column protected String autor;
	@NotNull @Size(min = 1) @Column protected int ano;
	@Column protected String codigo;
	@NotNull @Size(min = 1) @Column protected String ementa;
	@NotNull @Size(min = 1) @Column protected String interesses;
	@Column protected String situacao;
	@NotNull @Size(min = 1) @Column protected String endereco;
	@Column private boolean status;

	@NotNull @Size(min = 1) private String artigos;
	
	public LeiComplementar() {
		
	}
	
	public LeiComplementar(String dni, int ano, String ementa, String interesses, String url, String artigos) {
		this.autor = dni;
		this.ano = ano;
		this.ementa = ementa;
		this.interesses = interesses;
		this.endereco = url;
		this.artigos = artigos;
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
	
	public String getInteresses() {
		return interesses;
	}
	
	public String getSituacao() {
		return situacao;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public String getArtigos() {
		return artigos;
	}
	
	public String toString() {
		return (id + "/" + ano);
	}
}
