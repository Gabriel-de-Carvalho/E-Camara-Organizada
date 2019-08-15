package controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Deputado;
import models.Pessoa;
import services.PessoaService;

@RestController
@RequestMapping("/v1/pessoas")
public class PessoaController {
	
	private final PessoaService pessoaService;
	
	public PessoaController(PessoaService service) {
		this.pessoaService = service;
	}
	
	@PostMapping("/cadastrarComPartido")
	public ResponseEntity<Pessoa> cadastrarComPartido(@RequestBody Pessoa pessoa){
		return pessoaService.cadastrarPessoa(pessoa.getNome(), pessoa.getDni(), pessoa.getEstado(), String.join(",", pessoa.getInteresses()), pessoa.getPartido());
	}
	
	@PostMapping("/cadastrarSemPartido")
	public ResponseEntity<Pessoa> cadastrarSemPartido(@RequestBody Pessoa pessoa){
		return pessoaService.cadastrarPessoa(pessoa.getNome(), pessoa.getDni(), pessoa.getEstado(), pessoa.getInteresses().toString());
	}
	
	@PutMapping("/{dni}/{data}")
	public ResponseEntity<Deputado> cadastrarDeputado(@PathVariable String dni, @PathVariable String dataInicio){
		return pessoaService.cadastrarDeputado(dni, dataInicio);
	}
}
