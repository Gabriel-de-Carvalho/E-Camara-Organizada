package com.camara.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camara.demo.models.Partido;
import com.camara.demo.services.PartidoService;

@RestController
@RequestMapping("/v1/partido")
public class PartidoController {
	
	private final PartidoService partidoService;
	
	public PartidoController(PartidoService partidoService) {
		this.partidoService = partidoService;
	}
	
	@PostMapping("/")
	public ResponseEntity cadastrarPartido(@RequestBody String nome) {
		Partido partido =  partidoService.cadastraPartido(nome);
		return new ResponseEntity<Partido>(partido, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity listarBase() {
		return new ResponseEntity<String>(partidoService.listaPartidos(), HttpStatus.FOUND);
	}
}
