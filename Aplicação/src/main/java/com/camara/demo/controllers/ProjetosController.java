package com.camara.demo.controllers;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.camara.demo.models.Ementa;
import com.camara.demo.models.LeiComplementar;
import com.camara.demo.models.ProjetoLei;
import com.camara.demo.services.ProjetosService;

@RestController
@RequestMapping("/v1/projetos")
public class ProjetosController {
	
	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	private Validator validator = factory.getValidator();
		
	private ProjetosService projetos;
	
	@Autowired
	public ProjetosController(ProjetosService projeto) {
		this.projetos = projeto;
	}
	
	@PostMapping("/Ementa")
	public ResponseEntity<Ementa> cadastrarEmenta(@RequestBody Ementa ementa){
		Set<ConstraintViolation<Ementa>> violator = validator.validate(ementa);
		if(violator.size()  > 0) {
			for(ConstraintViolation<Ementa> quebra : violator) {
				throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, quebra.getMessage());
			}
		}
		Ementa sucess = projetos.cadastrarEmenta(ementa);
		return new ResponseEntity(sucess, HttpStatus.CREATED);
	}
	
	@PostMapping("/LeiComplementar")
	public ResponseEntity<LeiComplementar> cadastrarLeiComplementar(@RequestBody LeiComplementar lei){
		Set<ConstraintViolation<LeiComplementar>> violator = validator.validate(lei);
		if(violator.size()  > 0) {
			for(ConstraintViolation<LeiComplementar> quebra : violator) {
				throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, quebra.getMessage());
			}
		}
		LeiComplementar sucess = projetos.cadastrarLeiComplementar(lei);
		if(sucess == null) {
			throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Deputado nao existe");
		} else {
		return new ResponseEntity(sucess, HttpStatus.CREATED);
		}
	}
	
	@PostMapping("/ProjetoLei")
	public ResponseEntity<ProjetoLei> cadastrarProjetoLei(@RequestBody ProjetoLei lei){
		Set<ConstraintViolation<ProjetoLei>> violator = validator.validate(lei);
		if(violator.size()  > 0) {
			for(ConstraintViolation<ProjetoLei> quebra : violator) {
				throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, quebra.getMessage());
			}
		}
		ProjetoLei sucess = projetos.cadastrarProjetoLei(lei);
		if(sucess == null) {
			throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Deputado nao existe");
		} else {
		return new ResponseEntity(sucess, HttpStatus.CREATED);
		}
	}
	
	@GetMapping("/Ementa/{codigo}")
	public ResponseEntity<String> exibirEmenta(@PathVariable String codigo){
		if(codigo == null  || codigo.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "código nulo ou vazio");
		}
		String id = codigo.split("-")[0];
		return new ResponseEntity(projetos.exibirEmenta(id), HttpStatus.OK);
	}
	
	@GetMapping("/LeiComplementar/{codigo}")
	public ResponseEntity<String> exibirComplementar(@PathVariable String codigo){
		if(codigo == null  || codigo.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "código nulo ou vazio");
		}
//		String id = codigo.split("-")[0];
		return new ResponseEntity(projetos.exibirLeiComplementar(codigo), HttpStatus.OK);
	}
	
	@GetMapping("/ProjetoLei/{codigo}")
	public ResponseEntity<String> exibirProjeto(@PathVariable String codigo) {
		if(codigo == null  || codigo.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "código nulo ou vazio");
		}
		String id = codigo.split("-")[0];
		return new ResponseEntity(projetos.exibirProjeto(id), HttpStatus.OK);
	}
}
