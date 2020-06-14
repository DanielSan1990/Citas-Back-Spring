package com.citas.citas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.citas.citas.dto.ClienteDto;

@Service
public interface ClienteService {
	
	public void addCliente(ClienteDto clienteDto);
	public ClienteDto getCliente(Long idCliente);
	public List<ClienteDto> getClientes();
	public void deleteCliente(Long idCliente);
	public void updateCliente(ClienteDto clienteDto, Long idCliente);
}
