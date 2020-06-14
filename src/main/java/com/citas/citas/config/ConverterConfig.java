package com.citas.citas.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.citas.citas.converters.CitaDtoToCitaEntityConverter;
import com.citas.citas.converters.CitaEntityToCitaDto;
import com.citas.citas.converters.ClienteDtoToClienteEntity;
import com.citas.citas.converters.ClienteEntityToClienteDto;



@Configuration
public class ConverterConfig implements WebMvcConfigurer{

	@Override
    public void addFormatters(FormatterRegistry registry) {

		registry.addConverter(new CitaDtoToCitaEntityConverter());
		registry.addConverter(new CitaEntityToCitaDto());
		registry.addConverter(new ClienteDtoToClienteEntity());
		registry.addConverter(new ClienteEntityToClienteDto());
	}
	
}