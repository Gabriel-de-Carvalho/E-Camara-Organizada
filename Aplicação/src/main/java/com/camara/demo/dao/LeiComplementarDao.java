package com.camara.demo.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.camara.demo.models.LeiComplementar;

@Repository
public interface LeiComplementarDao<T, ID extends Serializable> extends JpaRepository<LeiComplementar, Long>{
	LeiComplementar save(LeiComplementar lei);
	
	boolean existsById(Long id);
	
	@Query(value = "FROM LeiComplementar where id = :id")
	LeiComplementar find(@Param("id") long id);
}
