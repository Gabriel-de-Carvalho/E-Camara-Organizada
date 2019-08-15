package services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dao.PessoaDao;
import models.Pessoa;

@Service
public class PessoaService {
	
	private final PessoaDao pessoaDao;
	
	public PessoaService(PessoaDao pessoadao) {
		this.pessoaDao = pessoadao;
	}
	
	public ResponseEntity<Pessoa> cadastrarPessoa(String nome, String dni, String estado, String interesses) {
		if((nome == null || nome.isEmpty()) || (dni == null || dni.isEmpty()) || (estado == null || estado.isEmpty())) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Preencha todos os campos corretamente");
		} else if (!(verificaDni(dni))) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "dni inexistente");
		}else if(pessoaDao.existsById(dni)) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "pessoa com dni ja cadastrada");
		} else {
			Pessoa pessoa = new Pessoa(nome, dni, estado, interesses);
			pessoaDao.save(pessoa);
			return new ResponseEntity<Pessoa>(pessoa, HttpStatus.CREATED);
		}
	}
	
	private boolean verificaDni(String dni) {
		// TODO Auto-generated method stub
		for(int i = 0; i < dni.length(); i++) {
			if((dni.charAt(i) != '0' && dni.charAt(i) != '1'
					&& dni.charAt(i) != '2' && dni.charAt(i) != '3'
					&& dni.charAt(i) != '4' && dni.charAt(i) != '5'
					&& dni.charAt(i) != '6' && dni.charAt(i) != '7'
					&& dni.charAt(i) != '8' && dni.charAt(i) != '9') && dni.charAt(i) != '-') {
				return false;
			}
		}
		return true;
	}

	public ResponseEntity<Pessoa> cadastrarPessoa(String nome, String dni, String estado, String interesses, String partido) {
		if((nome == null || nome.isEmpty()) || (dni == null || dni.isEmpty()) || (estado == null || estado.isEmpty())) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Preencha todos os campos corretamente");
		} else if (!(verificaDni(dni))) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "dni inexistente");
		}else if(pessoaDao.existsById(dni)) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "pessoa com dni ja cadastrada");
		} else {
			Pessoa pessoa = new Pessoa(nome, dni, estado, interesses);
			pessoaDao.save(pessoa);
			return new ResponseEntity<Pessoa>(pessoa, HttpStatus.CREATED);
		}
	}



	public ResponseEntity<String> exibirPessoa(String dni){
		Pessoa pessoa = pessoaDao.dni(dni);
		return new ResponseEntity<String>(pessoa.toString(), HttpStatus.FOUND);
	}
}
