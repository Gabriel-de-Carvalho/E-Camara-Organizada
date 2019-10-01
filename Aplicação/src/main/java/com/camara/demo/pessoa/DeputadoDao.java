package com.camara.demo.pessoa;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeputadoDao<T, ID extends Serializable> extends JpaRepository<Deputado, String> {
	Deputado findByDni(String dni);
	
	Deputado save(Deputado deputado);
	
	boolean existsByDni(String dni);
}
