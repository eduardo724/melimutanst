package com.meli.service.iservice;

import com.meli.service.dto.DnaDto;
import com.meli.service.dto.StatsAdnDto;

/**
 * Interfaz con todos los metodos a usar
 * por DNA
 *
 * @author Eduardo Guerere
 */
public interface IserviceDna {


    /**
     * metodo utilizado para almacenar un cliente en la
     * base de datos
     *
     * @param dnaDto  objeto recibido con el adn
     * @param isMutant true es mutante false humano
     */
    public void saveDna(DnaDto dnaDto, boolean isMutant);

    /**
     * metodo utilizado para devolver las
     * estadisticas
     *
     * @return StatsAdnDto objeto que tendra la cantidad de humanos, mutantes y el ratio
     */
    public StatsAdnDto getStats();

    /**
     * metodo que se encarga de validar si la cadena de adn
     * es humano o mutante
     *
     * @param dna arreglo de adn
     * @return true si es mutante y false si es humano
     */
    public boolean isMutant(String dna[]);

    /**
     * Metodo que se encarga de validar
     * si existe o no la cadena
     *
     * @param dna arreglo de adn
     * @return true existe false no existe el arreglo de cadena
     */
    public boolean existsAdn(String[] dna);


}
