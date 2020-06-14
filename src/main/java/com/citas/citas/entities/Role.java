package com.citas.citas.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.citas.citas.enums.RoleEnum;


import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class Role {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="role")
	@Enumerated(EnumType.STRING)
	private RoleEnum rol;
	
	@ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "roles")
	private List<Usuario> usuarios;
}
