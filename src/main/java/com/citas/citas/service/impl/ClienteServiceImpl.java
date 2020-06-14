package com.citas.citas.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;


import com.citas.citas.dto.ClienteDto;

import com.citas.citas.entities.Cliente;
import com.citas.citas.repositories.ClienteRepository;
import com.citas.citas.service.ClienteService;


@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ConversionService convercionService;
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	
	public void addCliente(ClienteDto clienteDto) {				
		Cliente clienteEnt = convercionService.convert(clienteDto, Cliente.class);		
		clienteRepo.save(clienteEnt);
	}


	@Override
	public ClienteDto getCliente(Long idCliente) {
		Cliente clienteEntity = clienteRepo.findById(idCliente).get();
		ClienteDto clienteDto = convercionService.convert(clienteEntity, ClienteDto.class);
		return clienteDto;
	}


	@Override
	public List<ClienteDto> getClientes() {	
		List<Cliente> clientesEntity = clienteRepo.findAll();
		List<ClienteDto> clientesDto = clientesEntity.stream().map(e -> convercionService.convert(e, ClienteDto.class)).collect(Collectors.toList());		
		return clientesDto;
	}


	@Override
	public void deleteCliente(Long idCliente) {
		Cliente clienteEntity = clienteRepo.findById(idCliente).get();
		clienteRepo.delete(clienteEntity);		
	}


	@Override
	public void updateCliente(ClienteDto clienteDto, Long idCliente) {
		Cliente clienteEntity = clienteRepo.findById(idCliente).get();
		if(!clienteEntity.getNombre().equals(clienteDto.getNombre())) {
			clienteEntity.setNombre(clienteDto.getNombre());
		}
		if(!clienteEntity.getApellido().equals(clienteDto.getApellido())) {
			clienteEntity.setApellido(clienteDto.getApellido());
		}
		if(!clienteEntity.getCorreo().equals(clienteDto.getCorreo())) {
			clienteEntity.setCorreo(clienteDto.getCorreo());
		}
		if(!clienteEntity.getTelefono().equals(clienteDto.getTelefono())) {
			clienteEntity.setTelefono(clienteDto.getTelefono());
		}
		clienteRepo.save(clienteEntity);
	}



}
