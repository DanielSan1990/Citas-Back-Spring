package com.citas.citas.controller;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.citas.citas.dto.ClienteDto;
import com.citas.citas.service.ClienteService;



@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("/cliente")
	public void addCliente(@RequestBody  ClienteDto clienteDto) {		
		clienteService.addCliente(clienteDto);		
	}
	
	@PutMapping("/cliente/{idCliente}")
	public void updateCliente(HttpServletRequest request, @RequestBody  ClienteDto clienteDto, @PathVariable Long idCliente){
		clienteService.updateCliente(clienteDto, idCliente);
    }
	
	@GetMapping("/cliente")
	public ResponseEntity<Object> getClientes(HttpServletRequest request) throws Exception {		
		return new ResponseEntity<Object>(clienteService.getClientes(), HttpStatus.OK);		
	}
	
	@GetMapping("/cliente/{idCliente}")
	public ResponseEntity<Object> getCliente(HttpServletRequest request,@PathVariable Long idCliente) throws Exception {		
		return new ResponseEntity<Object>(clienteService.getCliente(idCliente), HttpStatus.OK);		
	}
	
	@DeleteMapping("/cliente/{idCliente}")
	public void deleteCliente(HttpServletRequest request, @PathVariable Long idCliente){
		clienteService.deleteCliente(idCliente);
    }
}
