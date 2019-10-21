	package com.camara.demo.pessoa;

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



@RestController
@RequestMapping("/v1")
public class PessoaController {
	
	private PessoaService pessoaService;
	
	@Autowired
	public PessoaController(PessoaService service) {
		this.pessoaService = service;
	}
	
	@PostMapping("pessoa/ComPartido")
	public ResponseEntity<Pessoa> cadastrarComPartido(@RequestBody Pessoa pessoa){
		Pessoa Newpessoa = pessoaService.cadastrarPessoa(pessoa.getNome(), pessoa.getDni(), pessoa.getEstado(), pessoa.getListaInteresses(), pessoa.getPartido());
		return new ResponseEntity<Pessoa>(Newpessoa, HttpStatus.CREATED);
	}
	
	@PostMapping("pessoa/SemPartido")
	public ResponseEntity<Pessoa> cadastrarSemPartido(@RequestBody Pessoa pessoa){
		Pessoa retorno = pessoaService.cadastrarPessoa(pessoa.getNome(), pessoa.getDni(), pessoa.getEstado(), pessoa.getListaInteresses());
		return new ResponseEntity<Pessoa>(retorno, HttpStatus.CREATED);
	}
	
	@PutMapping("/deputado")
	public ResponseEntity<Deputado> cadastrarDeputado(@RequestBody Map<String, String> body){
		Deputado deputado = pessoaService.cadastrarDeputado(body.get("dni"), body.get("data"));
		return new ResponseEntity<Deputado>(deputado, HttpStatus.CREATED);
	}
	
	@GetMapping("/pessoa/{dni}")
	public ResponseEntity<String> recuperarPessoa(@PathVariable String dni){
		Pessoa pessoa = pessoaService.exibirPessoa(dni);
		return new ResponseEntity<String>(pessoa.toString(), HttpStatus.OK);
	}
	
	@GetMapping("/deputado/{dni}")
	public ResponseEntity<String> recuperarDeputado(@PathVariable String dni){
		Deputado deputado = pessoaService.exibirDeputado(dni);
		return new ResponseEntity<String>(deputado.toString(), HttpStatus.OK);
	}
	
}
