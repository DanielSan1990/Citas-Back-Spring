package com.citas.citas.converters;

import org.springframework.core.convert.converter.Converter;

import com.citas.citas.dto.CitaDto;

import com.citas.citas.entities.Cita;

public class CitaEntityToCitaDto  implements Converter<Cita, CitaDto>{


	
	@Override
	public CitaDto convert(Cita source) {
		
		CitaDto citaDto = new CitaDto();
		citaDto.setIdCita(source.getId());
		citaDto.setFecha(source.getFecha());
		citaDto.setTurno(source.getTurno());

		return citaDto;
	}


}
