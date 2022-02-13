package com.meli.service.dto;

import lombok.Data;

import javax.validation.Valid;

/**
 * Clase Utilizada para una Solicitud (Request)
 * 
 * @author Eduardo Guerere
 */

@Data
@Valid
public class DnaDto {
	@Valid
	private String[] dna;

}
