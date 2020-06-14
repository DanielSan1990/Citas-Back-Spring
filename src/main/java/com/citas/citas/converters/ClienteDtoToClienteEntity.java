package com.citas.citas.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import com.citas.citas.dto.CitaDto;
import com.citas.citas.dto.ClienteDto;
import com.citas.citas.entities.Cita;
import com.citas.citas.entities.Cliente;

public class ClienteDtoToClienteEntity implements Converter<ClienteDto, Cliente> {

	@Autowired
	private ConversionService conversionService;
	
	@Override
	public Cliente convert(ClienteDto source) {
		Cliente cliente = new Cliente();
		cliente.setNombre(source.getNombre());
		cliente.setApellido(source.getApellido());
		cliente.setCorreo(source.getCorreo());
		cliente.setTelefono(source.getTelefono());

		
		return cliente;
	}

}
