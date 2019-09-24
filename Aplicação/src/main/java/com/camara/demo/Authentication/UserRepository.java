package com.camara.demo.Authentication;

import java.io.Serializable;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository<T, ID extends Serializable> extends JpaRepository<CustomUser, Long> {
	Optional<CustomUser> findByUsername(String username);
}
