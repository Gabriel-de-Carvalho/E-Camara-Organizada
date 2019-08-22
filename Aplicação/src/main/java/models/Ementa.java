package models;

public class Ementa  extends Projeto{
	
	private String artigos;
	
	public Ementa(String dni, int ano, String ementa, String interesses, String url, String artigos) {
		super(dni, ano, ementa, interesses, url);
		this.artigos = artigos;
	}
}
