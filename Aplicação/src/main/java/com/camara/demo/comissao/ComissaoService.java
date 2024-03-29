package com.camara.demo.comissao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camara.demo.pessoa.PessoaService;



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
