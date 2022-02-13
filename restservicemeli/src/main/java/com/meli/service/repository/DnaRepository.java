package com.meli.service.repository;

import com.meli.service.model.Dna;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Interfaz DAO springDataMongo para el collection Dna
 *
 * @author Eduardo Guerere
 */
public interface DnaRepository extends MongoRepository<Dna, String> {

    Long countByIsMutant(Boolean isMutant);

    boolean existsByAdn(String[] adn);
}