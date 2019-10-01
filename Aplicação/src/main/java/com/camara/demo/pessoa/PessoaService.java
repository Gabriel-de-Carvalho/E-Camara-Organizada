package com.camara.demo.pessoa;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.camara.demo.partido.Partido;
import com.camara.demo.util.Util;

@Transactional
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

	public Pessoa cadastrarPessoa(String nome, String dni, String estado, String interesses, Partido partido) {
		if((nome == null || nome.isEmpty()) || (dni == null) || (estado == null || estado.isEmpty())) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Preencha todos os campos corretamente");
		} else if (dni.isEmpty()  || !(util.verificaDni(dni))) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "dni inexistente");
		}else if(pessoaDao.existsById(dni)) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "pessoa com dni ja cadastrada");
		} else {
			Pessoa pessoa = new Pessoa(nome, dni, estado, interesses, partido);
			pessoaDao.save(pessoa);
			return pessoa;
		}
	}



	public Pessoa exibirPessoa(String dni){
		if(!(pessoaDao.existsById(dni))) {
			throw new ResponseStatusException(HttpStatus.BAD_GATEWAY);
		}
		
		Pessoa pessoa = pessoaDao.dni(dni);
		return pessoa;
	}
	
	public Deputado exibirDeputado(String dni){
		if(!(deputadoDao.existsById(dni))) {
			throw new ResponseStatusException(HttpStatus.BAD_GATEWAY);
		}
		
		Deputado deputado = deputadoDao.findByDni(dni);
		return deputado;
	}
	
	public Deputado cadastrarDeputado(String dni, String dataInicio){
		if(pessoaDao.existsById(dni)) {
			Pessoa pessoa = pessoaDao.findByDni(dni);
			pessoaDao.deleteByDni(dni);
			if(!(util.verificaDni(dni)) || !(util.verificaData(dataInicio)) || pessoa.getPartido() == null || pessoa.getPartido() == null) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "erro");
			} else {
				Deputado deputado = new Deputado(pessoa.getNome(), pessoa.getDni(), pessoa.getEstado(), pessoa.getListaInteresses(), pessoa.getPartido(), dataInicio);
				deputadoDao.save(deputado);
				return deputado;
			}
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "dni inexistente");
		}
		
	}
	
	public boolean ehDeputado(String[] deputados) {
		boolean ehPolitico = true;
		for(int i = 0; i < deputados.length; i++) {
			if(!(util.verificaDni(deputados[i]))) {
				 ehPolitico = false;
			} else if(!(deputadoDao.existsByDni(deputados[i]))){
				ehPolitico =  false;
			} else if(!(deputadoDao.findByDni(deputados[i]) instanceof Deputado)) {
				 ehPolitico = false;
			}
		}
		return ehPolitico;
	}
	
	public boolean ehDeputado(String deputado) {
		if(deputadoDao.existsByDni(deputado)) {
			return true;
		} else {
			return false;
		}
	}
	
	public Deputado getDeputado(String dni) {
		return this.deputadoDao.findByDni(dni);
	}
	
}
