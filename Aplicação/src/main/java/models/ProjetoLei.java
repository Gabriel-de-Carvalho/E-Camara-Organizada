package models;

public class ProjetoLei extends Projeto{
	private boolean status;
	
	public ProjetoLei(String dni, int ano, String ementa, String interesses, String url, boolean status) {
		super(dni, ano, ementa, interesses, url);
		this.status = status;
	}
	
	public boolean getStatus() {
		return status;
	}
}
