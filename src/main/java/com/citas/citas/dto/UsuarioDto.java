package com.citas.citas.dto;



import lombok.Data;
@Data
public class UsuarioDto {
	
	private String userName;
	
	private String pass;

	private boolean habilitado = true;
	
}
