package com.meli.service.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.service.ServiceDnaApplications;
import com.meli.service.dto.DnaDto;
import com.meli.service.dto.StatsAdnDto;
import com.meli.service.routes.RoutesDna;
import com.meli.service.service.ServiceDna;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceDnaApplications.class)
@SpringBootTest
public class DnaControllerTest {


    @InjectMocks
    DnaController dnaController;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @MockBean
    private ServiceDna serviceDna;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void isMutantMutantTest() throws Exception {
        DnaDto dnaDto = new DnaDto();
        String dna[] = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        dnaDto.setDna(dna);

        when(serviceDna.existsAdn(dna)).thenReturn(false);
        when(serviceDna.isMutant(dnaDto.getDna())).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.post(RoutesDna.ROOT + RoutesDna.MUTANT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(dnaDto))
                .accept(MediaType.TEXT_PLAIN_VALUE))
                .andExpect(status().isOk());

    }

    @Test
    public void isMutantHumanTest() throws Exception {
        DnaDto dnaDto = new DnaDto();
        String dna[] = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        dnaDto.setDna(dna);

        when(serviceDna.existsAdn(dna)).thenReturn(false);
        when(serviceDna.isMutant(dnaDto.getDna())).thenReturn(false);


        mockMvc.perform(MockMvcRequestBuilders.post(RoutesDna.ROOT + RoutesDna.MUTANT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(dnaDto))
                .accept(MediaType.TEXT_PLAIN_VALUE))
                .andExpect(status().is4xxClientError());

    }

    @Test()
    public void isMutantArrayExistsTest() throws Exception {
        DnaDto dnaDto = new DnaDto();
        String dna[] = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        dnaDto.setDna(dna);

        when(serviceDna.existsAdn(dna)).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.post(RoutesDna.ROOT + RoutesDna.MUTANT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(dnaDto))
                .accept(MediaType.TEXT_PLAIN_VALUE))
                .andExpect(status().is4xxClientError());

    }

    @Test()
    public void isMutantArrayEmptyTest() throws Exception {
        DnaDto dnaDto = new DnaDto();
        String dna[] = null;
        dnaDto.setDna(dna);

        when(serviceDna.existsAdn(dna)).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.post(RoutesDna.ROOT + RoutesDna.MUTANT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(dnaDto))
                .accept(MediaType.TEXT_PLAIN_VALUE))
                .andExpect(status().is4xxClientError());

    }

    @Test()
    public void isMutantArrayEmptyTest2() throws Exception {
        DnaDto dnaDto = new DnaDto();
        String dna[] = {};
        dnaDto.setDna(dna);

        when(serviceDna.existsAdn(dna)).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.post(RoutesDna.ROOT + RoutesDna.MUTANT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(dnaDto))
                .accept(MediaType.TEXT_PLAIN_VALUE))
                .andExpect(status().is4xxClientError());

    }

    @Test()
    public void isMutantArrayEmptyTest3() throws Exception {
        DnaDto dnaDto = new DnaDto();
        String dna[] = {};
        dnaDto.setDna(dna);

        when(serviceDna.existsAdn(null)).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.post(RoutesDna.ROOT + RoutesDna.MUTANT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(dnaDto))
                .accept(MediaType.TEXT_PLAIN_VALUE))
                .andExpect(status().is4xxClientError());

    }

    @Test()
    public void isMutantArrayDnaDtoEmptyTest() throws Exception {
        DnaDto dnaDto = null;

        mockMvc.perform(MockMvcRequestBuilders.post(RoutesDna.ROOT + RoutesDna.MUTANT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(dnaDto))
                .accept(MediaType.TEXT_PLAIN_VALUE))
                .andExpect(status().is4xxClientError());

    }

    @Test()
    public void getStatsTest() throws Exception {
        StatsAdnDto statsAdnDto = null;
        when(serviceDna.getStats()).thenReturn(statsAdnDto);
        mockMvc.perform(MockMvcRequestBuilders.get(RoutesDna.ROOT + RoutesDna.STATS))
                .andExpect(status().isOk());
    }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
