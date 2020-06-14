package com.citas.citas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citas.citas.entities.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {	
	
	
}