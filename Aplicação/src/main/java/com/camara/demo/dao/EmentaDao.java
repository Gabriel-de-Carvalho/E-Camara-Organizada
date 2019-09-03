package com.camara.demo.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.camara.demo.models.Ementa;

@Repository
public interface EmentaDao<T, ID extends Serializable> extends JpaRepository<Ementa, Long> {
	Ementa save(Ementa ementa);
	
	boolean existsById(String id);
	
	@Query(value = "FROM Ementa where id = :id")
	Ementa find(@Param("id") Long id);
}
