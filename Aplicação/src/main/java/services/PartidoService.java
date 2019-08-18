package services;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dao.PartidosDao;
import models.Partido;

@Service
public class PartidoService {
	
	private final PartidosDao partidoDao;
	
	public PartidoService(PartidosDao partidoDao) {
		this.partidoDao = partidoDao;
	}
	
	public ResponseEntity cadastraPartido(String nome) {
		if(nome.isEmpty() || nome == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "entrada invalida");
		}
		
		Partido partido = new Partido(nome);
		partidoDao.save(partido);
		
		return new ResponseEntity<Partido>(partido, HttpStatus.CREATED);
	}
	
	public ResponseEntity listaPartidos() {
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
		return new ResponseEntity<String>(retorno, HttpStatus.OK);
	}
}
