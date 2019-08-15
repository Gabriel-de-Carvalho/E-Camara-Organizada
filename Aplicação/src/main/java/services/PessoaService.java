package services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dao.PessoaDao;
import models.Deputado;
import models.Pessoa;

@Service
public class PessoaService {
	
	private final PessoaDao pessoaDao;
	private Util util;
	
	public PessoaService(PessoaDao pessoadao) {
		this.pessoaDao = pessoadao;
	}
	
	public ResponseEntity<Pessoa> cadastrarPessoa(String nome, String dni, String estado, String interesses) {
		if((nome == null || nome.isEmpty()) || (dni == null || dni.isEmpty()) || (estado == null || estado.isEmpty())) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Preencha todos os campos corretamente");
		} else if (!(util.verificaDni(dni))) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "dni inexistente");
		}else if(pessoaDao.existsById(dni)) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "pessoa com dni ja cadastrada");
		} else {
			Pessoa pessoa = new Pessoa(nome, dni, estado, interesses);
			pessoaDao.save(pessoa);
			return new ResponseEntity<Pessoa>(pessoa, HttpStatus.CREATED);
		}
	}
	

	public ResponseEntity<Pessoa> cadastrarPessoa(String nome, String dni, String estado, String interesses, String partido) {
		if((nome == null || nome.isEmpty()) || (dni == null || dni.isEmpty()) || (estado == null || estado.isEmpty())) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Preencha todos os campos corretamente");
		} else if (!(util.verificaDni(dni))) {
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
		if(!(util.verificaDni(dni)) || !(pessoaDao.existsById(dni))) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		Pessoa pessoa = pessoaDao.dni(dni);
		return new ResponseEntity<String>(pessoa.toString(), HttpStatus.FOUND);
	}
	
	public ResponseEntity<Deputado> cadastrarDeputado(String dni, String dataInicio){
		if(pessoaDao.existsById(dni)) {
			Pessoa pessoa = pessoaDao.dni(dni);
			if(!(util.verificaDni(dni)) || !(util.verificaData(dataInicio)) || pessoa.getPartido() == null || pessoa.getPartido().isEmpty() || pessoa instanceof Deputado) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
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
	
}
