package com.citas.citas.converters;

import org.springframework.core.convert.converter.Converter;

import com.citas.citas.dto.ClienteDto;
import com.citas.citas.entities.Cliente;

public class ClienteEntityToClienteDto implements Converter<Cliente, ClienteDto> {

	@Override
	public ClienteDto convert(Cliente source) {
		ClienteDto clienteDto = new ClienteDto();
		clienteDto.setIdCliente(source.getId());
		clienteDto.setNombre(source.getNombre());
		clienteDto.setApellido(source.getApellido());
		clienteDto.setCorreo(source.getCorreo());
		clienteDto.setTelefono(source.getTelefono());
		//TODO revisar lista de citas
		return clienteDto;
	}

}
