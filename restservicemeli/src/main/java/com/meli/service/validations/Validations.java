package com.meli.service.validations;

import com.meli.service.exceptions.DnaNotNullExceptions;
import com.meli.service.exceptions.EmptyListDnaExceptions;
import com.meli.service.exceptions.ExistsListDnaExceptions;
import com.meli.service.service.ServiceDna;

/**
 * Clase creada para realizar
 * todas las validaciones
 *
 * @author Eduardo Guerere
 */
public class Validations {
    public static void validations(String[] dna, ServiceDna serviceDna)
            throws EmptyListDnaExceptions, ExistsListDnaExceptions, DnaNotNullExceptions {

        if (dna == null)
            throw new DnaNotNullExceptions("Properties DNA cannot be null");

        if (dna.length == 0)
            throw new EmptyListDnaExceptions("DNA list cannot be empty");

        if (serviceDna.existsAdn(dna))
            throw new ExistsListDnaExceptions("DNA list exists");
    }

}
