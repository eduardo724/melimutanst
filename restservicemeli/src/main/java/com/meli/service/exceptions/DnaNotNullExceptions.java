package com.meli.service.exceptions;

/**
 * Exception creada por lista de adn vacia
 *
 * @author eduardo guerere
 */
public class DnaNotNullExceptions extends Exception {
    public DnaNotNullExceptions(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
    public DnaNotNullExceptions(String errorMessage) {
        super(errorMessage);
    }
}
