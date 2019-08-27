//package com.camara.demo.models;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Inheritance;
//import javax.persistence.InheritanceType;
//
//@Entity
//
//public class Projeto {
//	
//	@Id @GeneratedValue(strategy = GenerationType.AUTO)
//	protected long sequencia;
//	
//	@Column protected String autor;
//	@Column protected int ano;
//	@Column protected String codigo;
//	@Column protected String ementa;
//	@Column protected String interesses;
//	@Column protected String situacao;
//	@Column protected String endereco;
//	
//	public Projeto() {
//		
//	}
//	
//	public Projeto(String dni, int ano, String ementa, String interesses, String url) {
//		this.autor = dni;
//		this.ano = ano;
//		this.ementa = ementa;
//		this.interesses = interesses;
//		this.endereco = url;
//	}
//	
//	public String getAutor() {
//		return autor;
//	}
//	
//	public int getAno() {
//		return ano;
//	}
//	
//	public String getEmenta() {
//		return ementa;
//	}
//	
//	public String[] getListaInteresses() {
//		return interesses.split(",");
//	}
//	
//	public String getInteresses() {
//		return interesses;
//	}
//	
//	public String getSituacao() {
//		return situacao;
//	}
//	
//	public String getEndereco() {
//		return endereco;
//	}
//	
//	public String toString() {
//		return (ano + "/" + sequencia);
//	}
//	
//}
