package com.meli.mutans.util;

/**
 * Clase utilizada para crear
 * todos los metodos que sean
 * comunes
 *
 * @author eduardo guerere
 */
public class Utils {
    /**
     * Metodo que se encarga de convertir un arreglo
     * a un arreglo bidimensional
     *
     * @param arrayOneDimension recibe el arreglo de palabras
     * @return char[][] retorna un arreglo de caracteres
     */
    public static char[][] convertArrayTwoDimensions(String[] arrayOneDimension) {
        char[][] arrayTwoDimension = new char[arrayOneDimension.length][];
        for (int i = 0; i < arrayOneDimension.length; i++) {
            arrayTwoDimension[i] = arrayOneDimension[i].toCharArray();
        }
        return arrayTwoDimension;
    }
}
