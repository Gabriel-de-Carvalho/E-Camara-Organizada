//package com.camara.demo.controllers;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.camara.demo.models.Comissao;
//import com.camara.demo.services.*;
//
//@RestController
//@RequestMapping("/v1/Comissao")
//public class ComissaoController {
//	
//	private final ComissaoService comissaoService;
//	
//	public ComissaoController(ComissaoService comissaoService) {
//		this.comissaoService = comissaoService;
//	}
//	
//	@PostMapping("/cadastrar")
//	public ResponseEntity<Comissao> cadastrarComissao(@RequestBody Comissao comissao){
//		return comissaoService.cadastrarComissao(comissao);
//	}
//}
