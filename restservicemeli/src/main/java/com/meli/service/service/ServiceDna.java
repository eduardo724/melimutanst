package com.meli.service.service;

import com.meli.mutans.business.SearchAdn;
import com.meli.service.dto.DnaDto;
import com.meli.service.dto.StatsAdnDto;
import com.meli.service.iservice.IserviceDna;
import com.meli.service.mapper.DnaMapper;
import com.meli.service.model.Dna;
import com.meli.service.repository.DnaRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase que posee la logica de negocio
 *
 * @author Eduardo Guerere
 */
@Service
public class ServiceDna implements IserviceDna {

    private static final Logger log = LogManager.getLogger(ServiceDna.class);


    @Autowired
    private DnaRepository dnaRepository;


    @Override
    public void saveDna(DnaDto dnaDto, boolean isMutant) {
        log.info("into method saveDna");
        log.info("Object Dnadto: ", dnaDto, " isMutant: ", isMutant);
        Dna dna = DnaMapper.dnaDtoToDna(dnaDto, isMutant);
        dnaRepository.save(dna);
        log.info("end method saveDna");
    }

    @Override
    public StatsAdnDto getStats() {
        log.info("into method getStats");
        StatsAdnDto statsAdnDto = new StatsAdnDto();
        statsAdnDto.setCount_human_dna(dnaRepository.countByIsMutant(false));
        statsAdnDto.setCount_mutant_dna(dnaRepository.countByIsMutant(true));
        statsAdnDto.setRatio(statsAdnDto.getCount_mutant_dna().doubleValue() / statsAdnDto.getCount_human_dna().doubleValue());
        log.info("Object stats is: ", statsAdnDto);
        log.info("end method getStats");
        return statsAdnDto;
    }

    @Override
    public boolean isMutant(String[] dna) {
        log.info("into method isMutant");
        SearchAdn searchAdn = new SearchAdn();
        return searchAdn.isMutant(dna);
    }

    @Override
    public boolean existsAdn(String[] dna){
        log.info("into method existsAdn");
        return dnaRepository.existsByAdn(dna);
    }
}

