package com.meli.service.dto;

import lombok.Data;

/**
 * Clase Dto para devolver las estadisticas
 *
 * @author Eduardo Guerere.
 */
@Data
public class StatsAdnDto {

    Long count_mutant_dna;
    Long count_human_dna;
    Double ratio;
}
