package com.formularioFull.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formularioFull.model.TechnicalAccount;

@Repository
public interface ITechnicalRepository extends JpaRepository<TechnicalAccount, Integer>{
	Optional<TechnicalAccount> findByUser(String user);
}
