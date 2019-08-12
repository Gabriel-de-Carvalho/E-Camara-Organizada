package services;

import org.springframework.stereotype.Service;

import dao.PessoaDao;

@Service
public class PessoaService {
	
	private final PessoaDao pessoaDao;
	
	public PessoaService(PessoaDao pessoadao) {
		this.pessoaDao = pessoadao;
	}
	
	
	
}
