package com.camara.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.camara.demo.dao.ComissaoDao;
import com.camara.demo.dao.DeputadoDao;
import com.camara.demo.dao.EmentaDao;
import com.camara.demo.dao.LeiComplementarDao;
import com.camara.demo.dao.ProjetoLeiDao;
import com.camara.demo.models.Comissao;
import com.camara.demo.models.Ementa;
import com.camara.demo.models.LeiComplementar;
import com.camara.demo.models.ProjetoLei;

public class VotacaoService {
	
	private EmentaDao ementaDao;
	private LeiComplementarDao leiComplementar;
	private ProjetoLeiDao projetos;
	private ComissaoDao comissoes;
	private DeputadoDao deputados;
	
	@Autowired
	public VotacaoService(EmentaDao e, LeiComplementarDao l, ProjetoLeiDao p, ComissaoDao c, DeputadoDao d) {
		this.ementaDao = e;
		this.leiComplementar = l;
		this.projetos = p;
		this.comissoes = c;
		this.deputados = d;
	}
	
	public String votarComissao(String codigo, String governista, String proximoLocal) {
		Ementa ementa = ementaDao.find(Long.parseLong(codigo));
		ProjetoLei projeto = projetos.find(Long.parseLong(codigo));
		LeiComplementar lei = leiComplementar.find(Long.parseLong(codigo));
		
		if(ementa != null) {
			return votarEmenta(ementa, governista, proximoLocal);
		} else if(projeto != null) {
			return votarProjeto(projeto, governista, proximoLocal);
		} else if(lei != null){
			return votarComplementar(lei, governista, proximoLocal);
		} else {
			return null;
		}
	}

	private String votarComplementar(LeiComplementar lei, String governista, String proximoLocal) {
		 Optional<Comissao> retorno = comissoes.findById(lei.getLocal());
		 Comissao comissao = retorno.orElseThrow(IllegalArgumentException::new);
		 
		 String[] participantes = comissao.getListaDeputados();
		 int favor = 0;
		 for(int i = 0 ; i < participantes.length; i++) {
			 
		 }
		return null;
	}

	private String votarProjeto(ProjetoLei projeto, String governista, String proximoLocal) {
		// TODO Auto-generated method stub
		return null;
	}

	private String votarEmenta(Ementa ementa, String governista, String proximoLocal) {
		// TODO Auto-generated method stub
		return null;
	}
}
