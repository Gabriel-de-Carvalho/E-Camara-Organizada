package dao;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import models.Pessoa;

@Repository
public interface PessoaDao<T, ID extends Serializable> extends JpaRepository<Pessoa, String> {
	Pessoa save(Pessoa pessoa);
	
	@Query(value= "Select * from pessoa p where p.dni = :identificador", nativeQuery= true)
	Pessoa Dni(@Param("identificador") String dni);
}
