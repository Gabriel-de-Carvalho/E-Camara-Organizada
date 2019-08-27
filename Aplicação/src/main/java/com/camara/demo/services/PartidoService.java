package com.camara.demo.services;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.camara.demo.dao.PartidosDao;
import com.camara.demo.models.Partido;

@Service
public class PartidoService {
	
	private final PartidosDao partidoDao;
	
	@Autowired
	public PartidoService(PartidosDao partidoDao) {
		this.partidoDao = partidoDao;
	}
	
	public Partido cadastraPartido(String nome) {
		if(nome == null ||  nome.isEmpty() ) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "entrada invalida");
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
