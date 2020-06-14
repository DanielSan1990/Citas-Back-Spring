package com.citas.citas.converters;


import org.springframework.core.convert.converter.Converter;

import com.citas.citas.dto.CitaDto;
import com.citas.citas.entities.Cita;


public class CitaDtoToCitaEntityConverter implements Converter<CitaDto, Cita> {
	
	@Override
	public Cita convert(CitaDto source) {
		Cita cita = new Cita();	
		cita.setFecha(source.getFecha());
		cita.setTurno(source.getTurno());			
		
		return cita;
	}

}
