package com.camara.demo.partido;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartidoService {
	
	private final PartidosDao partidoDao;
	
	@Autowired
	public PartidoService(PartidosDao partidoDao) {
		this.partidoDao = partidoDao;
	}
	
	public Partido cadastraPartido(String nome) {
		if(nome == null ||  nome.isEmpty() || (nome.trim().length() == 0)) {
			return null;
		}
		
		Partido partido = new Partido(nome);
		partidoDao.save(partido);
		
		return partido;
	}
	
	public String listaPartidos() {
		ArrayList<String> partidos = partidoDao.lista();
		Collections.sort(partidos);
		String retorno = "";
		for(int i = 0; i < partidos.size(); i++) {
			if(i == partidos.size()-1) {
				retorno += partidos.get(i);
			} else {
				retorno += partidos.get(i) + ",";
			}
		}
		return retorno;
	}
}
