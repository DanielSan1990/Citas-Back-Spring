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

import com.citas.citas.dto.CitaDto;

import com.citas.citas.service.CitaService;

@RestController
public class CitaController {

	@Autowired
	private CitaService citaService;
	
	@PostMapping("/cita")
	public void addCitae(@RequestBody  CitaDto citaDto) {		
		citaService.addCita(citaDto);		
	}
	
	@PutMapping("/cita/{idCita}")
	public void updateCita(HttpServletRequest request, @RequestBody  CitaDto citaDto, @PathVariable Long idCita){
		citaService.updateCita(citaDto, idCita);
    }
	
	@GetMapping("/cita")
	public ResponseEntity<Object> getCitas(HttpServletRequest request) throws Exception {		
		return new ResponseEntity<Object>(citaService.getCitas(), HttpStatus.OK);		
	}
	
	@GetMapping("/cita/{idCita}")
	public ResponseEntity<Object> getCitae(HttpServletRequest request,@PathVariable Long idCita) throws Exception {		
		return new ResponseEntity<Object>(citaService.getCita(idCita), HttpStatus.OK);		
	}
	
	@DeleteMapping("/cita/{idCita}")
	public void deleteCliente(HttpServletRequest request, @PathVariable Long idCita){
		citaService.deleteCita(idCita);
    }
}
