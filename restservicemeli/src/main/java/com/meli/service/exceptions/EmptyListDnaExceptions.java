package com.meli.service.exceptions;

/**
 * Exception creada por lista de adn vacia
 *
 * @author eduardo guerere
 */
public class EmptyListDnaExceptions extends Exception {
    public EmptyListDnaExceptions(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
    public EmptyListDnaExceptions(String errorMessage) {
        super(errorMessage);
    }
}
