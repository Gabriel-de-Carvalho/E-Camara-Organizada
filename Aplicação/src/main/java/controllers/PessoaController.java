package controllers;

import org.springframework.web.bind.annotation.RestController;

import services.PessoaService;

@RestController
public class PessoaController {
	
	private final PessoaService pessoaService;
	
	public PessoaController(PessoaService service) {
		this.pessoaService = service;
	}
}
