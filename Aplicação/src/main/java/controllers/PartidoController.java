package controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import services.PartidoService;

@RestController
@RequestMapping("/v1/partido")
public class PartidoController {
	
	private final PartidoService partidoService;
	
	public PartidoController(PartidoService partidoService) {
		this.partidoService = partidoService;
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity cadastrarPartido(String nome) {
		return partidoService.cadastraPartido(nome);
	}
	
	@GetMapping("/listar")
	public ResponseEntity listarBase() {
		return partidoService.listaPartidos();
	}
}
