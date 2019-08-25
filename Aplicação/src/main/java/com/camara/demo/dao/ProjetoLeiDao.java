package com.camara.demo.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.camara.demo.models.ProjetoLei;



@Repository
public interface ProjetoLeiDao<T, ID extends Serializable > extends JpaRepository<ProjetoLei, Long>{
		
	ProjetoLei save(ProjetoLei lei);
}
