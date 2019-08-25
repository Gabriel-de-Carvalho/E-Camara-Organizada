package com.camara.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.camara.demo.dao.DeputadoDao;
import com.camara.demo.dao.PessoaDao;
import com.camara.demo.models.Deputado;
import com.camara.demo.models.Pessoa;

@Service
public class PessoaService {
	
	private PessoaDao pessoaDao;
	private DeputadoDao deputadoDao;
	private Util util = new Util();
	
	@Autowired
	public PessoaService(PessoaDao pessoadao, DeputadoDao deputadoDao) {
		this.pessoaDao = pessoadao;
		this.deputadoDao = deputadoDao;
	}
	
	public Pessoa cadastrarPessoa(String nome, String dni, String estado, String interesses) {
		if((nome == null || nome.isEmpty()) || (dni == null) || (estado == null) || (interesses == null)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Valores de entrada não podem ser nulos");
		} else if ( dni.isEmpty()  || !(util.verificaDni(dni))) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "dni inexistente ou incorreta");
		}else if(pessoaDao.existsById(dni)) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "pessoa com dni ja cadastrada");
		} else {
			Pessoa pessoa = new Pessoa(nome, dni, estado, interesses);
			pessoaDao.save(pessoa);
			return pessoa;
		}
	}

	public ResponseEntity<Pessoa> cadastrarPessoa(String nome, String dni, String estado, String interesses, String partido) {
		if((nome == null || nome.isEmpty()) || (dni == null) || (estado == null || estado.isEmpty())) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Preencha todos os campos corretamente");
		} else if (dni.isEmpty()  || !(util.verificaDni(dni))) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "dni inexistente");
		}else if(pessoaDao.existsById(dni)) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "pessoa com dni ja cadastrada");
		} else {
			Pessoa pessoa = new Pessoa(nome, dni, estado, interesses, partido);
			pessoaDao.save(pessoa);
			return new ResponseEntity<Pessoa>(pessoa, HttpStatus.CREATED);
		}
	}



	public Pessoa exibirPessoa(String dni){
		if(!(pessoaDao.existsById(dni))) {
			throw new ResponseStatusException(HttpStatus.BAD_GATEWAY);
		}
		
		Pessoa pessoa = pessoaDao.dni(dni);
		return pessoa;
	}
	
	public ResponseEntity<Deputado> cadastrarDeputado(String dni, String dataInicio){
		if(pessoaDao.existsById(dni)) {
			Pessoa pessoa = pessoaDao.dni(dni);
			if(!(util.verificaDni(dni)) || !(util.verificaData(dataInicio)) || pessoa.getPartido() == null || pessoa.getPartido().isEmpty()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "erro");
			} else {
				pessoaDao.deleteById(dni);
				Deputado deputado = new Deputado(pessoa.getNome(), pessoa.getDni(), pessoa.getEstado(), String.join(",", pessoa.getInteresses()), pessoa.getPartido(), dataInicio);
				pessoaDao.save(deputado);
				return new ResponseEntity<Deputado>(deputado, HttpStatus.CREATED);
			}
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "dni inexistente");
		}
		
	}
	
	public boolean ehDeputado(String[] deputados) {
		boolean politico = true;
		for(int i = 0; i < deputados.length; i++) {
			if(!(util.verificaDni(deputados[i]))) {
				 politico = false;
			} else if(!(pessoaDao.existsById(deputados[i]))){
				politico =  false;
			} else if(!(pessoaDao.dni(deputados[i]) instanceof Deputado)) {
				 politico = false;
			}
		}
		return politico;
	}
	
}
