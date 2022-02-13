package com.meli.service.service;

import com.meli.service.dto.DnaDto;
import com.meli.service.model.Dna;
import com.meli.service.repository.DnaRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.when;

/**
 * Clase para los test unitarias de la
 * ServiceDna.
 *
 * @author eduardo guerere
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ServiceDnaTest {

    @Autowired
    ServiceDna serviceDna;

    @MockBean
    DnaRepository dnaRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void saveDnaTest() {
        DnaDto dnaDto = new DnaDto();
        String dna[] = {};
        dnaDto.setDna(dna);

        when(dnaRepository.save(new Dna())).thenReturn(new Dna());
        serviceDna.saveDna(dnaDto, true);
    }

    @Test
    public void isMutantTrueTest() {
        String[] dna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        Assert.assertTrue(serviceDna.isMutant(dna));
    }

    @Test
    public void isMutantFalseTest() {
        String[] dna = {"ATGCGA", "AAGTGC", "ATATTT", "AGACGG", "GCGTCA", "TCACTG"};
        Assert.assertFalse(serviceDna.isMutant(dna));
    }

    @Test
    public void existsAdnTrueTest() {
        String[] dna = null;
        when(dnaRepository.existsByAdn(dna)).thenReturn(true);
        Assert.assertTrue(serviceDna.existsAdn(dna));
    }

    @Test
    public void existsAdnFalseTest() {
        String[] dna = null;
        when(dnaRepository.existsByAdn(dna)).thenReturn(false);
        Assert.assertFalse(serviceDna.existsAdn(dna));
    }

    @Test
    public void statsAdnDtoTest() {
        when(dnaRepository.countByIsMutant(false)).thenReturn(5L);
        when(dnaRepository.countByIsMutant(true)).thenReturn(5L);
        Assert.assertNotNull(serviceDna.getStats());
    }

}