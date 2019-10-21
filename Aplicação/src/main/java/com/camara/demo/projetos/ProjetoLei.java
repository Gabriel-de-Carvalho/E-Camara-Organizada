package com.camara.demo.projetos;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.camara.demo.pessoa.Deputado;

@Entity
public class ProjetoLei{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	protected long id;
	
	@NotNull @Size(min = 1) @OneToOne protected Deputado autor;
	@NotNull @Size(min = 1) @Column protected String ano;
	@Column protected String codigo;
	@NotNull @Size(min = 1) @Column protected String ementa;
	@NotNull @Size(min = 1) @Column protected String interesses;
	@Column protected String situacao = "EM VOTACAO (CCJC)";
	@NotNull @Size(min = 1) @Column protected String endereco;
	
    private String local = "CCJC";

	
	@ElementCollection
	private Map<String, String> votacoes;
	
	@Column private boolean status;
	public ProjetoLei(){
		
	}
	
	public ProjetoLei(Deputado autor, String ano, String ementa, String interesses, String url, boolean status) {
		this.autor = autor;
		this.ano = ano;
		this.ementa = ementa;
		this.interesses = interesses;
		this.endereco = url;
		this.status = status;
		codigo = id + "/" + ano;
	}
	public long getId() {
		return id;
	}
	
	public boolean getStatus() {
		return status;
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
	
	public String toString() {
		return "Projeto de Lei - " + getCodigo() + " - " + autor + " - " + ementa + " - " + status + " - " + situacao; 
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
