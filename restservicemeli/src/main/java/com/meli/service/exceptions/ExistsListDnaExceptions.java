package com.meli.service.exceptions;

/**
 * Exception creada por existencia de lista de adn vacia
 *
 * @author eduardo guerere
 */
public class ExistsListDnaExceptions extends Exception {
    public ExistsListDnaExceptions(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
    public ExistsListDnaExceptions(String errorMessage) {
        super(errorMessage);
    }
}
