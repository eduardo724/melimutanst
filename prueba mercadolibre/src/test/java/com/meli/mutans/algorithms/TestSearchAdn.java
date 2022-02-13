package com.meli.mutans.algorithms;

import com.meli.mutans.business.SearchAdn;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Clase creada para las pruebas unitarias
 * de la clase TableAdnImpl
 *
 * @author eduardo guerere
 */
public class TestSearchAdn {

    SearchAdn searchAdn;

    @Before
    public void setUp() {
        searchAdn = new SearchAdn();
    }

    @Test
    public void testExistWordInSearchAdn() {

        String[] dna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        assertEquals(true, searchAdn.isMutant(dna));
    }

    @Test
    public void testNotExistWordInSearchAdn() {

        String[] dna = {"ATGCGA", "AAGTGC", "ATATTT", "AGACGG", "GCGTCA", "TCACTG"};
        assertEquals(false, searchAdn.isMutant(dna));
    }

}
