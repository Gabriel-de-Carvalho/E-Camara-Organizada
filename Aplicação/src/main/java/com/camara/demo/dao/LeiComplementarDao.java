package com.camara.demo.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.camara.demo.models.LeiComplementar;

@Repository
public interface LeiComplementarDao<T, ID extends Serializable> extends JpaRepository<LeiComplementar, Long>{
	LeiComplementar save(LeiComplementar lei);
}
