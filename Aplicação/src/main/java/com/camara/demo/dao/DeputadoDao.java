package com.camara.demo.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.camara.demo.models.Deputado;

@Repository
public interface DeputadoDao<T, ID extends Serializable> extends JpaRepository<Deputado, String> {
	
	DeputadoDao save(DeputadoDao deputado);
}
