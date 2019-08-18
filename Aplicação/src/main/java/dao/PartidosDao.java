package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import models.Partido;

public interface PartidosDao<T, ID extends Serializable> extends JpaRepository<Partido, String> {
	
	Partido save(Partido dni);
	
	@Query(value = "Select p.partido from Partido p", nativeQuery = true)
	ArrayList<String> lista();
}
