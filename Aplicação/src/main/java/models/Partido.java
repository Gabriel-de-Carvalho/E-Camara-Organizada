package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Partido {
	
	@Id
	private String partido;
	
	public Partido() {
		
	}
	
	public Partido(String partido) {
		this.partido = partido;
	}
	
	public String getPartido() {
		return partido;
	}
	
}
