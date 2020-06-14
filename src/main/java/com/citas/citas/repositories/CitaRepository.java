package com.citas.citas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citas.citas.entities.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {

}