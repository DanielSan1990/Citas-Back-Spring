package com.citas.citas.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class CitaDto {
	private Long idCita;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "Europe/London")
	private LocalDate fecha;
	@NotNull
	@Positive	
	private Integer turno;
	private boolean asistencia;
	private ClienteDto cliente;
}
