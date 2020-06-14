package com.citas.citas.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


import lombok.Data;

@Data
public class ClienteDto {
	private Long idCliente;
	@NotEmpty(message="El nombre es obligatorio")
	private String nombre;
	@NotEmpty(message="El apellido es obligatorio")
	private String apellido;
	@Email(message="Introduzca un correo válido")
	private String correo;
	@NotNull
	@Positive
	private Integer telefono;
	
	private List<CitaDto> citasDto;
}
