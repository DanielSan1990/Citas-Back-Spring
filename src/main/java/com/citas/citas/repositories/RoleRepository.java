package com.citas.citas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citas.citas.entities.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
