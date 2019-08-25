package com.camara.demo.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.camara.demo.models.Pessoa;



@Repository
public interface PessoaDao<T, ID extends Serializable> extends JpaRepository<Pessoa, String> {
	Pessoa save(Pessoa pessoa);

	@Query(value = "SELECT * FROM pessoa p  WHERE p.dni = :identificador", nativeQuery= true)
	Pessoa dni(@Param("identificador") String dni);
	
	boolean existsById(String dni);
}
