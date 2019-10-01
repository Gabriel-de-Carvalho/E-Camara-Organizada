package com.camara.demo.services;

import org.springframework.stereotype.Service;

import com.camara.demo.dao.EmentaDao;
import com.camara.demo.dao.LeiComplementarDao;
import com.camara.demo.dao.ProjetoLeiDao;
import com.camara.demo.models.Ementa;
import com.camara.demo.models.LeiComplementar;
import com.camara.demo.models.ProjetoLei;

@Service
public class ProjetosService {
	
	private EmentaDao ementaDao;
	private LeiComplementarDao leiComplementarDao;
	private ProjetoLeiDao projeto;
	private PessoaService pessoas;
	
	public ProjetosService(EmentaDao ementaDao,LeiComplementarDao leiComplementarDao,ProjetoLeiDao projeto, PessoaService pessoa){
		this.ementaDao = ementaDao;
		this.leiComplementarDao = leiComplementarDao;
		this.projeto = projeto;
		this.pessoas = pessoa;
	}
	
	public Ementa cadastrarEmenta(Ementa ementa) {
		if(pessoas.ehDeputado(ementa.getAutor().getDni()) && !(ementaDao.existsById(ementa.getId()))) {
			Ementa retorno = ementaDao.save(ementa);
			return retorno;
		} else {
			return null;
		}
		
	}
	
	public LeiComplementar cadastrarLeiComplementar(LeiComplementar lei) {
		if(pessoas.ehDeputado(lei.getAutor().getDni()) && !(leiComplementarDao.existsById(lei.getId()))) {
			LeiComplementar retorno = leiComplementarDao.save(lei);
			return retorno;
		} else {
			return null;
		}
		
	}
	
	public ProjetoLei cadastrarProjetoLei(ProjetoLei lei) {
		if(pessoas.ehDeputado(lei.getAutor().getDni()) && !(projeto.existsById(lei.getId()))) {
			ProjetoLei retorno = projeto.save(lei);
			return retorno;
		} else {
			return null;
		}
	}
	
	public String exibirEmenta(String id) {
		Ementa retorno = ementaDao.find(Long.parseLong(id));
		return retorno.toString();
		}
	
	public String exibirLeiComplementar(String id) {
		LeiComplementar lei = leiComplementarDao.find(Long.parseLong(id));
		return lei.toString();
	}
	
	public String exibirProjeto(String id) {
		ProjetoLei sucess = projeto.find(Long.parseLong(id));
		
		return sucess.toString();
	}
}
