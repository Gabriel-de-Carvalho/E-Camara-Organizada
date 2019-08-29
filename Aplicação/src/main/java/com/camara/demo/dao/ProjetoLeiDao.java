package com.camara.demo.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.camara.demo.models.ProjetoLei;



@Repository
public interface ProjetoLeiDao<T, ID extends Serializable > extends JpaRepository<ProjetoLei, Long>{
	boolean existsById(Long id);
	
	@Query(value = "FROM ProjetoLei where id = :id")
	ProjetoLei find(@Param("id") String id);
	
	ProjetoLei save(ProjetoLei lei);
}
