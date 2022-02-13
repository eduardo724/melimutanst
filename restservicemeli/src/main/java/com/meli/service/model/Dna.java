package com.meli.service.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase documento para almacenar
 * el adn
 *
 * @author Eduardo Guerere
 */
@Data
@Document("dnas")
public class Dna {
    private String[] adn;
    private Boolean isMutant;
}