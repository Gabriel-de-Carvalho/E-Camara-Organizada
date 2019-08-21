package dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Comissao;

public interface ComissaoDao<T, ID extends Serializable> extends JpaRepository<Comissao, String> {

		Comissao save(Comissao comissao);
		
		boolean existsById(String tema);
}
