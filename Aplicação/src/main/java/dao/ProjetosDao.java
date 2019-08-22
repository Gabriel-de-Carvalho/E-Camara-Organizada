package dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Projeto;

public interface ProjetosDao<T, ID extends Serializable > extends JpaRepository<T, String>{

}
