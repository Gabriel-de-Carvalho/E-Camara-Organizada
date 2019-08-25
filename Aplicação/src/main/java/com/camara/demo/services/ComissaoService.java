package com.camara.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.camara.demo.dao.ComissaoDao;
import com.camara.demo.models.Comissao;



@Service
public class ComissaoService {
		private final ComissaoDao comissaoDao;
		private final PessoaService pessoaService;
		
		@Autowired
		public ComissaoService(ComissaoDao comissaoDao, PessoaService pessoaService) {
			this.comissaoDao = comissaoDao;
			this.pessoaService = pessoaService;
		}
		
		public ResponseEntity<Comissao> cadastrarComissao(Comissao comissao){
			String tema = comissao.getTema();
			String[] deputados = comissao.getListaDeputados();
			
			if(tema == null || tema.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "tema da comissão vazio");
			}
			if(comissaoDao.existsById(tema) || pessoaService.ehDeputado(deputados)) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tema ja existente ou dnis invalidos");
			}
			
			comissaoDao.save(comissao);
			return new ResponseEntity<Comissao>(comissao, HttpStatus.CREATED);
		}
		
}
