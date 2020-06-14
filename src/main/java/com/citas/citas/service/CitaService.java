package com.citas.citas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.citas.citas.dto.CitaDto;


@Service
public interface CitaService {
	public void addCita(CitaDto citaDto);
	public CitaDto getCita(Long idCita);
	public List<CitaDto> getCitas();
	public void deleteCita(Long idCita);
	public void updateCita(CitaDto citaDto, Long idCita);

}
