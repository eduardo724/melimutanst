package com.meli.service.mapper;

import com.meli.service.dto.DnaDto;
import com.meli.service.model.Dna;

/**
 * Clase utilizada para las conversiones
 * @author Eduardo Guerere
 */
public class DnaMapper {

    public static Dna dnaDtoToDna(DnaDto dnaDto, boolean isMutant) {

        Dna dna = new Dna();
        dna.setIsMutant(isMutant);
        dna.setAdn(dnaDto.getDna());
        return dna;

    }

}
