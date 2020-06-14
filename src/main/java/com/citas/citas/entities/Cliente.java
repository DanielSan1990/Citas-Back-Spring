package com.citas.citas.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "clientes")
@Data
public class Cliente {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nombre;
	
	private String apellido;
	
	private String correo;
	
	private Integer telefono;
	
	@OneToOne
	private Usuario usuario;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
	private List<Cita> citas;
}
