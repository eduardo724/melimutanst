
package com.meli.mutans.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de validar si existe o
 * no una secuencia de palabras en el tablero
 * de secuencias de adn
 *
 * @author eduardo guerere
 */
public class TableAdnImpl implements TableAdn {
    // variable usada para listar todas las filas del tablero
    private List<String> listRow = new ArrayList<>();
    // variable usada para listar todas las columnas del tablero
    private List<String> listColumn = new ArrayList<>();
    // matriz de caracteres de la sopa de letras
    private char tableAdn[][] = null;


    /**
     * constructor de la clase la cual
     * recibe la matriz de caracteres
     * por parametro
     *
     * @param mat matriz de caracteres
     */
    public TableAdnImpl(char mat[][]) {
        tableAdn = mat;
        fillListByColumn();
        fillListByRow();
    }

    /**
     * metodo encargado de llenar la lista de palabras de las filas
     * de la matriz
     */
    public void fillListByRow() {

        for (int indice = 0; indice < tableAdn.length; indice++) {
            listRow.add(String.valueOf(tableAdn[indice]));
        }
    }

    /**
     * metodo encargado de llenar la lista de palabras de las oclumnas
     * de la matriz
     */
    public void fillListByColumn() {

        for (int row = 0; row < tableAdn.length; row++) {
            String word = "";
            for (int column = 0; column < tableAdn.length; column++) {
                word += tableAdn[column][row];
            }
            listColumn.add(word);
        }
    }

    /**
     * metodo encargado de realizar la busqueda en la matriz de manera
     * diagonal superior
     *
     * @param word es la palabra a buscar en las diagonales superiores de la matriz
     * @return true si encuentra la palabra y false en caso de no conseguir la palabra
     */
    public boolean validateExistsDiagonalSup(String word) {

        int rowAux = 0;
        int column = 0;
        String diagonal = "";
        for (int row = tableAdn.length - 1; row >= 0 && row >= (word.length() - 1); row--) {
            for (rowAux = row, column = 0, diagonal = ""; column < tableAdn.length && rowAux >= 0; rowAux--, column++) {
                diagonal += tableAdn[rowAux][column];
            }

            if (diagonal.contains(word)) return true;

        }
        return false;
    }

    /**
     * metodo encargado de realizar la busqueda en la matriz de manera
     * diagonal inferior
     *
     * @param word es la palabra a buscar en las diagonales inferiores de la matriz
     * @return true si encuentra la palabra y false en caso de no conseguir la palabra
     */
    public boolean validateExistsDiagonalInf(String word) {

        int rowAux = 0;
        int column = 1;
        int columnAux = 0;
        String diagonal = word.concat("x");

        for (int row = tableAdn.length - 1; row >= 0 && (diagonal.length() - 1) > (word.length() - 1); ) {
            columnAux = column;
            for (rowAux = row, diagonal = ""; columnAux < tableAdn.length && rowAux >= 0; rowAux--, columnAux++) {
                diagonal += tableAdn[rowAux][columnAux];
            }

            column++;
            if (diagonal.contains(word)) return true;
        }
        return false;
    }

    /**
     * metodo encargado de realizar la busqueda en la matriz de manera
     * transversal inferior
     *
     * @param word es la palabra a buscar en las transversales de la matriz
     * @return true si encuentra la palabra y false en caso de no conseguir la palabra
     */
    public boolean validateExistsTransversalInf(String word) {

        int rowAux = 1;
        int column = 0;
        int columnAux = 0;
        String diagonal = word.concat(word);
        return searchTransversalinf(rowAux, diagonal, word, column, columnAux);
    }

    /**
     * metodo encargado de realizar la busqueda en la matriz de manera
     * transversal superior
     *
     * @param word es la palabra a buscar en las transversales de la matriz
     * @return true si encuentra la palabra y false en caso de no conseguir la palabra
     */
    public boolean validateExistsTransversalSup(String word) {

        int rowAux = 0;
        int column = 1;
        int columnAux = 0;
        String diagonal = word.concat(word);
        return searchTransversal(rowAux, diagonal, word, column, columnAux);
    }

    /**
     * metodo que se encarga de buscar en una palabra en una matriz
     * la busqueda la hace por filas, columnas, diagonales y transversles
     *
     * @param word palabra a buscar en la matriz de caracteres
     * @return true si encuentra la palabra y false en caso de no conseguir la palabra
     */
    public boolean searchWord(String word) {

        if (existsWord(listRow, word))
            return true;
        else if (existsWord(listColumn, word))
            return true;
        else if (this.validateExistsDiagonalSup(word))
            return true;
        else if (this.validateExistsDiagonalInf(word))
            return true;
        else if (this.validateExistsTransversalInf(word))
            return true;
        else if (this.validateExistsTransversalSup(word))
            return true;
        else return false;
    }

    /**
     * metodo que se encargar de buscar una palabra
     * en la lista de palabras en este contexto
     * la lista puede ser de columnas o de filas
     *
     * @param list lista de palabras de todas las filas o columnas de la matriz de adn
     * @param word es la palabra que se va a buscar en la lista
     * @return true si encontro la palabra, false si no la encuentra
     */
    public boolean existsWord(List<String> list, String word) {
        for (String column : list) {
            if (column.contains(word))
                return true;
        }
        return false;
    }

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
    public boolean searchTransversal(int rowAux, String diagonal, String palabra, int column, int columnAux) {
        for (int row = rowAux; row >= 0 && (diagonal.length() - 1) > (palabra.length() - 1); column++) {
            for (rowAux = row, columnAux = column, diagonal = ""; columnAux < tableAdn.length && rowAux < tableAdn.length; rowAux++, columnAux++) {
                diagonal += tableAdn[rowAux][columnAux];
            }
            if (diagonal.contains(palabra)) return true;
        }
        return false;
    }

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
    public boolean searchTransversalinf(int rowAux, String diagonal, String palabra, int column, int columnAux) {
        for (int row = rowAux; row >= 0 && (diagonal.length() - 1) > (palabra.length() - 1); row++) {
            for (rowAux = row, columnAux = column, diagonal = ""; columnAux < tableAdn.length && rowAux < tableAdn.length; rowAux++, columnAux++) {
                diagonal += tableAdn[rowAux][columnAux];
            }
            if (diagonal.contains(palabra)) return true;
        }
        return false;
    }

}
