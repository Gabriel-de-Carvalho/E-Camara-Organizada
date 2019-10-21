package com.camara.demo.pessoa;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface PessoaDao<T, ID extends Serializable> extends JpaRepository<Pessoa, String> {
	Pessoa save(Pessoa pessoa);

	@Query(value = "FROM Pessoa WHERE dni = :identificador")
	Pessoa dni(@Param("identificador") String dni);
	
	Pessoa findByDni(String dni);
	
	void deleteByDni(String dni);
	
	boolean existsById(String dni);
}
