package com.camara.demo.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.camara.demo.models.Deputado;

@Repository
public interface DeputadoDao<T, ID extends Serializable> extends JpaRepository<Deputado, String> {
	Deputado findByDni(String dni);
	
	Deputado save(Deputado deputado);
	
	boolean existsByDni(String dni);
}
