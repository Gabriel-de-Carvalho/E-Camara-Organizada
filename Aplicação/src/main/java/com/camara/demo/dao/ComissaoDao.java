package com.camara.demo.dao;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.camara.demo.models.Comissao;

@Repository
public interface ComissaoDao<T, ID extends Serializable> extends JpaRepository<Comissao, String> {

		Comissao save(Comissao comissao);
		
		boolean existsById(String id);
		Optional<Comissao> findById(String id);
}
