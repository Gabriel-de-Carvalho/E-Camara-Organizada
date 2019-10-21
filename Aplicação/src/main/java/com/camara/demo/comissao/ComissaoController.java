package com.camara.demo.comissao;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/v1/Comissao")
public class ComissaoController {
	
	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	private Validator validator = factory.getValidator();
	
	private final ComissaoService comissaoService;
	
	@Autowired
	public ComissaoController(ComissaoService comissaoService) {
		this.comissaoService = comissaoService;
	}
	
	@PostMapping("/")
	public ResponseEntity<Comissao> cadastrarComissao(@RequestBody Comissao comissao){
		Set<ConstraintViolation<Comissao>> quebras = validator.validate(comissao);
		if(quebras.size() != 0) {
			for(ConstraintViolation<Comissao> violacao : quebras) {
				throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, violacao.getMessage());
		}
	}
		if(comissaoService.cadastrarComissao(comissao) == null) {
			throw new ResponseStatusException(HttpStatus.BAD_GATEWAY);
		}
		return new ResponseEntity<Comissao>(comissaoService.cadastrarComissao(comissao), HttpStatus.CREATED);
	}
}
