package com.citas.citas.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "usuario")
	private String userName;
	@Column(name = "contraseña")
	private String pass;
	@Column(name = "estado_usuario")
	private boolean habilitado = true;
	
	@OneToOne(mappedBy = "usuario")
	private Cliente cliente;
	
	@ManyToMany
	private List<Role> roles;
	
}
