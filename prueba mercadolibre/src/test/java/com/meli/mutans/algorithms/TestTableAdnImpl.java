package com.meli.mutans.algorithms;

import com.meli.mutans.util.PropertiesMutans;
import com.meli.mutans.util.Utils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Clase creada para las pruebas unitarias
 * de la clase TableAdnImpl
 *
 * @author eduardo guerere
 */
public class TestTableAdnImpl {
    private TableAdnImpl tableAdn;
    private String arrayWords[];

    @Before
    public void setUp() throws Exception {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(PropertiesMutans.class);
        context.refresh();

        HashMap properties = context.getBean(HashMap.class);

        String[] dna = {"ATGCGA", "AATGGC", "AAGTCT", "AGACTG", "GGCACA", "GCCCTG"};

        char matrix[][] = Utils.convertArrayTwoDimensions(dna);

        String words = (String) properties.get("number.of.words");
        arrayWords = words.split(",");
        tableAdn = new TableAdnImpl(matrix);
    }

    @Test
    public void testExistsByColumn() {
        assertEquals(true, tableAdn.searchWord("AAAA"));
    }

    @Test
    public void testNotExistsByColumn() {
        assertEquals(false, tableAdn.searchWord("TGTA"));
    }

    @Test
    public void testExistsByRow() {
        assertEquals(true, tableAdn.searchWord("CCCC"));
    }

    @Test
    public void testNotExistsByRow() {
        assertEquals(false, tableAdn.searchWord("GGGA"));
    }

    @Test
    public void testValidateExistsDiagonalSup() {
        assertEquals(true, tableAdn.validateExistsDiagonalSup("GGGG"));
    }

    @Test
    public void testValidateNotExistsDiagonalSup() {
        assertEquals(false, tableAdn.validateExistsDiagonalSup("CCCC"));
    }

    @Test
    public void testValidateExistsDiagonalInf() {
        assertEquals(false, tableAdn.validateExistsDiagonalSup("CCCC"));
    }

    @Test
    public void testValidateNotExistsDiagonalInf() {
        assertEquals(false, tableAdn.validateExistsDiagonalSup("CCCC"));
    }

    @Test
    public void testValidateExistsTransversalSup() {
        assertEquals(true, tableAdn.validateExistsTransversalSup("TTTT"));
    }

    @Test
    public void testValidateNotExistsTransversalSup() {
        assertEquals(false, tableAdn.validateExistsTransversalSup("GGGG"));
    }

    @Test
    public void testValidateExistsTransversalInf() {
        assertEquals(true, tableAdn.validateExistsTransversalInf("AAAA"));
    }

    @Test
    public void testValidateNotExistsTransversalInf() {
        assertEquals(false, tableAdn.validateExistsTransversalInf("TTTT"));
    }

    @Test
    public void testExistsWord() {
        assertEquals(true, tableAdn.searchWord("GGGG"));
        assertEquals(true, tableAdn.searchWord("ATGC"));
        assertEquals(true, tableAdn.searchWord("GGCG"));
        assertEquals(true, tableAdn.searchWord("AGCC"));
    }
}
