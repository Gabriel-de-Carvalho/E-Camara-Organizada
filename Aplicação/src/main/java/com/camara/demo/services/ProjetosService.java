package com.camara.demo.services;

import org.springframework.stereotype.Service;

import com.camara.demo.dao.EmentaDao;
import com.camara.demo.dao.LeiComplementarDao;
import com.camara.demo.dao.ProjetoLeiDao;

@Service
public class ProjetosService {
	
	private EmentaDao ementaDao;
	private LeiComplementarDao leiComplementarDao;
	private ProjetoLeiDao projeto;
	
	public ProjetosService(EmentaDao ementaDao,LeiComplementarDao leiComplementarDao,ProjetoLeiDao projeto){
		this.ementaDao = ementaDao;
		this.leiComplementarDao = leiComplementarDao;
		this.projeto = projeto;
	}
}
