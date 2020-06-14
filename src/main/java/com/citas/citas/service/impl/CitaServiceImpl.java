package com.citas.citas.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.citas.citas.dto.CitaDto;
import com.citas.citas.entities.Cita;
import com.citas.citas.repositories.CitaRepository;
import com.citas.citas.service.CitaService;
@Service
public class CitaServiceImpl implements CitaService {
	
	@Autowired
	private ConversionService convercionService;
	
	@Autowired
	private CitaRepository citaRepo;

	@Override
	public void addCita(CitaDto citaDto) {
		Cita citaEntity = convercionService.convert(citaDto, Cita.class);
		citaRepo.save(citaEntity);
	}

	@Override
	public CitaDto getCita(Long idCita) {
		Cita citanEntity = citaRepo.findById(idCita).get();
		CitaDto citaDto = convercionService.convert(citanEntity, CitaDto.class);
		return citaDto;
	}

	@Override
	public List<CitaDto> getCitas() {
		List<Cita> citasEntity = citaRepo.findAll();
		List<CitaDto> citasDto = citasEntity.stream().map(e -> convercionService.convert(e, CitaDto.class)).collect(Collectors.toList());
		return citasDto;
	}

	@Override
	public void deleteCita(Long idCita) {
		Cita citanEntity = citaRepo.findById(idCita).get();
		citaRepo.delete(citanEntity);		
	}

	@Override
	public void updateCita(CitaDto citaDto, Long idCita) {
		Cita citanEntity = citaRepo.findById(idCita).get();
		if(!citanEntity.getFecha().equals(citaDto.getFecha())) {
			citanEntity.setFecha(citaDto.getFecha());
		}
		if(!citanEntity.getTurno().equals(citaDto.getTurno())) {
			citanEntity.setTurno(citaDto.getTurno());
		}
		citaRepo.save(citanEntity);
	}

	

}
