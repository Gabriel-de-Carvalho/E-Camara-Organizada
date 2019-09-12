package com.camara.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.camara.demo.dao.ComissaoDao;
import com.camara.demo.dao.DeputadoDao;
import com.camara.demo.dao.EmentaDao;
import com.camara.demo.dao.LeiComplementarDao;
import com.camara.demo.dao.PartidosDao;
import com.camara.demo.dao.ProjetoLeiDao;
import com.camara.demo.models.Comissao;
import com.camara.demo.models.Deputado;
import com.camara.demo.models.Ementa;
import com.camara.demo.models.LeiComplementar;
import com.camara.demo.models.ProjetoLei;

public class VotacaoService {
	
	private EmentaDao ementaDao;
	private LeiComplementarDao leiComplementar;
	private ProjetoLeiDao projetos;
	private ComissaoDao comissoes;
	private DeputadoDao deputados;
	private PartidosDao partidos;
	
	@Autowired
	public VotacaoService(EmentaDao e, LeiComplementarDao l, ProjetoLeiDao p, ComissaoDao c, DeputadoDao d, PartidosDao g) {
		this.ementaDao = e;
		this.leiComplementar = l;
		this.projetos = p;
		this.comissoes = c;
		this.deputados = d;
		this.partidos = g;
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
		 ArrayList<String> base = partidos.lista();
		 int favor = 0;

		 for(int i = 0 ; i < participantes.length; i++) {
			 Deputado deputado = deputados.findByDni(participantes[i]);
			 
			 if(governista == "GOVERNISTA" && base.contains(deputado.getPartido())) {
				 favor += 1;
			 } else if(governista == "OPOSICAO" && base.contains(deputado.getPartido())) {
				 favor -= 1;
			 } else if(governista == "LIVRE") {
				 int interesses = 0;
				 for(int j = 0; j < lei.getListaInteresses().length; j++) {
					 for(int k = 0; k < deputado.getListaInteresses().length(); k++) {
						 if(lei.getListaInteresses()[j]  == deputado.getInteresses()[k]) {
							 interesses +=1;
							 break;
						 }
					 }
				 }
				 if(interesses > 0) {
					 favor +=1;
				 } else {
					 favor -=1;
				 }
			 }
		 }
		 if(favor >= (comissao.getListaDeputados().length /2) + 1) {
			 return lei.resultVotacao("APROVADO", comissao.getId(), proximoLocal);
		 } else {
			 return lei.resultVotacao("REJEITADO", comissao.getId(), proximoLocal);
		 }
	}

	private String votarProjeto(ProjetoLei lei, String governista, String proximoLocal) {
		Optional<Comissao> retorno = comissoes.findById(lei.getLocal());
		 Comissao comissao = retorno.orElseThrow(IllegalArgumentException::new);
		 
		 String[] participantes = comissao.getListaDeputados();
		 ArrayList<String> base = partidos.lista();
		 int favor = 0;

		 for(int i = 0 ; i < participantes.length; i++) {
			 Deputado deputado = deputados.findByDni(participantes[i]);
			 
			 if(governista == "GOVERNISTA" && base.contains(deputado.getPartido())) {
				 favor += 1;
			 } else if(governista == "OPOSICAO" && base.contains(deputado.getPartido())) {
				 favor -= 1;
			 } else if(governista == "LIVRE") {
				 int interesses = 0;
				 for(int j = 0; j < lei.getListaInteresses().length; j++) {
					 for(int k = 0; k < deputado.getListaInteresses().length(); k++) {
						 if(lei.getListaInteresses()[j]  == deputado.getInteresses()[k]) {
							 interesses +=1;
							 break;
						 }
					 }
				 }
				 if(interesses > 0) {
					 favor +=1;
				 } else {
					 favor -=1;
				 }
			 }
		 }
		 if(favor >= (comissao.getListaDeputados().length /2) + 1) {
			 return lei.resultVotacao("APROVADO", comissao.getId(), proximoLocal);
		 } else {
			 return lei.resultVotacao("REJEITADO", comissao.getId(), proximoLocal);
		 }
	}

	private String votarEmenta(Ementa lei, String governista, String proximoLocal) {
		Optional<Comissao> retorno = comissoes.findById(lei.getLocal());
		 Comissao comissao = retorno.orElseThrow(IllegalArgumentException::new);
		 
		 String[] participantes = comissao.getListaDeputados();
		 ArrayList<String> base = partidos.lista();
		 int favor = 0;

		 for(int i = 0 ; i < participantes.length; i++) {
			 Deputado deputado = deputados.findByDni(participantes[i]);
			 
			 if(governista == "GOVERNISTA" && base.contains(deputado.getPartido())) {
				 favor += 1;
			 } else if(governista == "OPOSICAO" && base.contains(deputado.getPartido())) {
				 favor -= 1;
			 } else if(governista == "LIVRE") {
				 int interesses = 0;
				 for(int j = 0; j < lei.getListaInteresses().length; j++) {
					 for(int k = 0; k < deputado.getListaInteresses().length(); k++) {
						 if(lei.getListaInteresses()[j]  == deputado.getInteresses()[k]) {
							 interesses +=1;
							 break;
						 }
					 }
				 }
				 if(interesses > 0) {
					 favor +=1;
				 } else {
					 favor -=1;
				 }
			 }
		 }
		 if(favor >= (comissao.getListaDeputados().length /2) + 1) {
			 return lei.resultVotacao("APROVADO", comissao.getId(), proximoLocal);
		 } else {
			 return lei.resultVotacao("REJEITADO", comissao.getId(), proximoLocal);
		 }
	}
}
