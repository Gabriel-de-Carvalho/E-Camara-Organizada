package com.camara.demo.projetos;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface ProjetoLeiDao<T, ID extends Serializable > extends JpaRepository<ProjetoLei, Long>{
	boolean existsById(Long id);
	
	@Query(value = "FROM ProjetoLei where id = :id")
	ProjetoLei find(@Param("id") long id);
	
	ProjetoLei save(ProjetoLei lei);
}
