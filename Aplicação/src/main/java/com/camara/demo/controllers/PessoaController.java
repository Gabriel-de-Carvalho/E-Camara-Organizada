	package com.camara.demo.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camara.demo.models.Deputado;
import com.camara.demo.models.Pessoa;
import com.camara.demo.services.PessoaService;



@RestController
@RequestMapping("/v1/pessoas")
public class PessoaController {
	
	private PessoaService pessoaService;
	
	@Autowired
	public PessoaController(PessoaService service) {
		this.pessoaService = service;
	}
	
	@PostMapping("/cadastrarComPartido")
	public ResponseEntity<Pessoa> cadastrarComPartido(@RequestBody Pessoa pessoa){
		return pessoaService.cadastrarPessoa(pessoa.getNome(), pessoa.getDni(), pessoa.getEstado(), pessoa.getListaInteresses(), pessoa.getPartido());
	}
	
	@PostMapping("/cadastrarSemPartido")
	public ResponseEntity<Pessoa> cadastrarSemPartido(@RequestBody Pessoa pessoa){
		Pessoa retorno = pessoaService.cadastrarPessoa(pessoa.getNome(), pessoa.getDni(), pessoa.getEstado(), pessoa.getListaInteresses());
		return new ResponseEntity<Pessoa>(retorno, HttpStatus.CREATED);
	}
	
	@PutMapping("cadastrarDeputado/")
	public ResponseEntity<Deputado> cadastrarDeputado(@RequestBody Map<String, String> body){
		return pessoaService.cadastrarDeputado(body.get("dni"), body.get("data"));
	}
	
	@GetMapping("/{dni}")
	public ResponseEntity<String> recuperarPessoa(@PathVariable String dni){
		Pessoa pessoa = pessoaService.exibirPessoa(dni);
		return new ResponseEntity<String>(pessoa.toString(), HttpStatus.FOUND);
	}
	
}
