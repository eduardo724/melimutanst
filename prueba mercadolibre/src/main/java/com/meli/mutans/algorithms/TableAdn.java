package com.meli.mutans.algorithms;

import java.util.List;

/**
 * Interfaz que tendra los mentodos principales
 * para recorrer el tablero
 *
 * @author  Eduardo Guerere
 */
public interface TableAdn {

    void fillListByRow();

    /**
     * metodo encargado de llenar la lista de palabras de las oclumnas
     * de la matriz
     */
    void fillListByColumn();

        /**
         * metodo encargado de realizar la busqueda en la matriz de manera
         * diagonal superior
         *
         * @param word es la palabra a buscar en las diagonales superiores de la matriz
         * @return true si encuentra la palabra y false en caso de no conseguir la palabra
         */
    boolean validateExistsDiagonalSup(String word);

    /**
     * metodo encargado de realizar la busqueda en la matriz de manera
     * diagonal inferior
     *
     * @param word es la palabra a buscar en las diagonales inferiores de la matriz
     * @return true si encuentra la palabra y false en caso de no conseguir la palabra
     */
    boolean validateExistsDiagonalInf(String word);

    /**
     * metodo encargado de realizar la busqueda en la matriz de manera
     * transversal inferior
     *
     * @param word es la palabra a buscar en las transversales de la matriz
     * @return true si encuentra la palabra y false en caso de no conseguir la palabra
     */
    boolean validateExistsTransversalInf(String word);

    /**
     * metodo encargado de realizar la busqueda en la matriz de manera
     * transversal superior
     *
     * @param word es la palabra a buscar en las transversales de la matriz
     * @return true si encuentra la palabra y false en caso de no conseguir la palabra
     */
    boolean validateExistsTransversalSup(String word);

    /**
     * metodo que se encarga de buscar en una palabra en una matriz
     * la busqueda la hace por filas, columnas, diagonales y transversles
     *
     * @param word palabra a buscar en la matriz de caracteres
     * @return true si encuentra la palabra y false en caso de no conseguir la palabra
     */
    boolean searchWord(String word);

    /**
     * metodo que se encargar de buscar una palabra
     * en la lista de palabras en este contexto
     * la lista puede ser de columnas o de filas
     *
     * @param list lista de palabras de todas las filas o columnas de la matriz de adn
     * @param word es la palabra que se va a buscar en la lista
     * @return true si encontro la palabra, false si no la encuentra
     */
    boolean existsWord(List<String> list, String word);

    /**
     * Metodo encargado de hacer la busqueda en transversal superior
     *
     * @param rowAux    variable auxiliar que se utilizar para recorrer las filas
     * @param diagonal  representa la palabra de los caracteres leido en la transversal
     * @param palabra   es la palabra que se va a buscar en la transversal
     * @param column    se utiliza para saber desde que punto va a inicar la columna
     * @param columnAux es una variable auxiliar de la columna que se utiliza para recorrer la matriz
     * @return true si encontro la palabra, false si no la encuentra
     */
    boolean searchTransversal(int rowAux, String diagonal, String palabra, int column, int columnAux);

    /**
     * Metodo encargado de hacer la busqueda en transversal inferior
     *
     * @param rowAux    variable auxiliar que se utilizar para recorrer las filas
     * @param diagonal  representa la palabra de los caracteres leido en la transversal
     * @param palabra   es la palabra que se va a buscar en la transversal
     * @param column    se utiliza para saber desde que punto va a inicar la columna
     * @param columnAux es una variable auxiliar de la columna que se utiliza para recorrer la matriz
     * @return true si encontro la palabra, false si no la encuentra
     */
    boolean searchTransversalinf(int rowAux, String diagonal, String palabra, int column, int columnAux);
}
