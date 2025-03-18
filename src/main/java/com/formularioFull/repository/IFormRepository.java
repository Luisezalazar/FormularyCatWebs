package com.formularioFull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formularioFull.model.Formulary;

@Repository
public interface IFormRepository extends JpaRepository<Formulary, Integer>{

}
