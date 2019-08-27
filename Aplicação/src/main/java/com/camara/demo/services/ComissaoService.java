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
		
		public Comissao cadastrarComissao(Comissao comissao){
			String tema = comissao.getId();
			String[] deputados = comissao.getListaDeputados();
			
			if(tema == null || tema.isEmpty()) {
				return null;
			}
			if(comissaoDao.existsById(tema) || !(pessoaService.ehDeputado(deputados))) {
				return null;
			}
			
			comissaoDao.save(comissao);
			return comissao;
		}
		
}
