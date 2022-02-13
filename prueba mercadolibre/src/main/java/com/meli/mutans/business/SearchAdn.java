package com.meli.mutans.business;

import com.meli.mutans.algorithms.TableAdnImpl;
import com.meli.mutans.util.PropertiesMutans;
import com.meli.mutans.util.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase encargada de leer las palabras permitidas
 * asi como tambien la cantidad de ocurrencias
 * validas y posteriormente consumir el metodo
 * del tablero de adn para buscar si el adn
 * es humano o mutante
 */
public class SearchAdn {

    private static final Logger log = LogManager.getLogger(SearchAdn.class);

    public boolean isMutant(String[] dna) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(PropertiesMutans.class);
        context.refresh();

        HashMap properties = context.getBean(HashMap.class);

        char matrix[][] = Utils.convertArrayTwoDimensions(dna);
        ArrayList<Boolean> listBoolean = new ArrayList<>();

        int numberOcurrences = Integer.parseInt((String) properties.get("cantOccurrences"));
        String words = (String) properties.get("number.of.words");
        log.info("la lista de palabras es: ", words);
        String arrayWords[] = words.split(",");

        TableAdnImpl tableAdn = new TableAdnImpl(matrix);

        double inicio = System.currentTimeMillis();
        log.info("Inicio " + inicio + " segundos");

        for (int indice = 0; indice < arrayWords.length; indice++) {

            if (tableAdn.searchWord(arrayWords[indice])) {
                log.info("Palabra " + arrayWords[indice]);
                listBoolean.add(true);
            }

            if (listBoolean.size() == numberOcurrences) {
                log.info("es mutante");
                return true;
            }

        }

        double fin = System.currentTimeMillis();
        double tiempo = (fin - inicio) / 1000;
        log.info(tiempo + " segundos");
        log.info("no es mutante");
        return false;

    }
}
