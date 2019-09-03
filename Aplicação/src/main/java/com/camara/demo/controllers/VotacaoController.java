package com.camara.demo.controllers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.camara.demo.services.VotacaoService;

public class VotacaoController {
	
	private VotacaoService votacaoService;
	
	public VotacaoController(VotacaoService votacaoService) {
		this.votacaoService = votacaoService;
	}
	
	
	public ResponseEntity<String> votarComissao(@RequestBody Map<String, String> values) {
			if(values.get("codigo") == null || values.get("status") == null || values.get("proximoLocal") == null) {
				throw new ResponseStatusException(HttpStatus.BAD_GATEWAY);
			}
			if(values.get("codigo").isEmpty() || values.get("status").isEmpty() || values.get("proximoLocal").isEmpty() ) {
				throw new ResponseStatusException(HttpStatus.BAD_GATEWAY);
			}
			
			String sucess = votacaoService.votarComissao(values.get("codigo"), values.get("status"), values.get("proximoLocal"));
			return new ResponseEntity<String>(sucess, HttpStatus.OK);
	}
}
