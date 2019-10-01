package com.camara.demo.models;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Ementa{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	protected long id;
	
	@NotNull @Size(min = 1) @Column protected Deputado autor;
	@NotNull @Size(min = 1) @Column protected String ano;
	@Column protected String codigo;
	@NotNull @Size(min = 1) @Column protected String ementa;
	@NotNull @Size(min = 1) @Column protected String interesses;
	@Column protected String situacao = "EM VOTACAO (CCJC)";
	@NotNull @Size(min = 1) @Column protected String endereco;
	
    private String local = "CCJC";
	
	@ElementCollection
	private Map<String, String> votacoes;
	
	@Column @NotNull @Size(min = 1) private String artigos;
	
	public Ementa() {
		
	}
	
	public Ementa(Deputado autor, String ano, String ementa, String interesses, String url, String artigos) {
		this.autor = autor;
		this.ano = ano;
		this.ementa = ementa;
		this.interesses = interesses;
		this.endereco = url;
		this.artigos = artigos;
		this.codigo = id + "/" + ano;
	}
	
	public long getId() {
		return id;
	}
	
	public Deputado getAutor() {
		return autor;
	}
	
	public String getAno() {
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
	
	public String getCodigo() {
		return id + "/" + ano;
	}
	
	public String getArtigos() {
		return artigos;
	}
	
	public String toString() {
		return "Projeto de Emenda Constitucional - " + getCodigo() + " - " + autor + " - " + ementa + " - " + artigos + " - " + situacao; 
	}
	
	public String resultVotacao(String result, String local, String prox) {
		votacoes.put(local, result);
		this.situacao = "Em Votacao (" + prox + ")";
		return (result + " (" + local + ")");
	}
	
	public String getLocal() {
		return local;
	}
	
}
