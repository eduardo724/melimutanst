package com.meli.service.controller;

import com.meli.service.dto.DnaDto;
import com.meli.service.dto.StatsAdnDto;
import com.meli.service.exceptions.DnaNotNullExceptions;
import com.meli.service.exceptions.EmptyListDnaExceptions;
import com.meli.service.exceptions.ExistsListDnaExceptions;
import com.meli.service.routes.RoutesDna;
import com.meli.service.service.ServiceDna;
import com.meli.service.validations.Validations;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RequestMapping(RoutesDna.ROOT)
@Api(tags = "meli")
@RestController
public class DnaController {

    private static final Logger log = LogManager.getLogger(DnaController.class);

    @Autowired
    private ServiceDna serviceDna;

    @PostMapping(path = RoutesDna.MUTANT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE)
    @ApiOperation(value = "isMutant", notes = " Servicio que verifica si un arreglo de cadena es Mutante")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La secuencia de arreglo de cadena Es Mutante"),
            @ApiResponse(code = 403, message = "La secuencia de arreglo de cadena Es Humano"),
            @ApiResponse(code = 400, message = "El objeto, la propiedad adn y el arreglo no deben ser nulos"),
            @ApiResponse(code = 406, message = "La secuencia de arreglo de cadena ya existe en " +
                    "la base de datos")

    })
    public ResponseEntity<?> isMutant(@Valid @RequestBody DnaDto dnaDto) {

        try {
            log.info("into method DnaDto ", dnaDto.toString());
            log.info("start the webservice");

            Validations.validations(dnaDto.getDna(), serviceDna);

            boolean result = serviceDna.isMutant(dnaDto.getDna());
            serviceDna.saveDna(dnaDto, result);

            if (result) return new ResponseEntity<>(HttpStatus.OK);
            else return new ResponseEntity<>(HttpStatus.FORBIDDEN);


        }catch (DnaNotNullExceptions e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }catch (EmptyListDnaExceptions e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        } catch (ExistsListDnaExceptions e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        } catch (Exception e) {
            log.error("error isMutant: ", e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = RoutesDna.STATS)
    @ApiOperation(value = "stats", notes = "Servicio que devuelve un Json con las estadísticas de las\n" +
            "verificaciones de ADN: {“count_mutant_dna”:40, “count_human_dna”:100: “ratio”:0.4}\n" +
            "(ratio = mutants / humans)\n")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Json con las estadísticas de las\n" +
                    "verificaciones de ADN: {“count_mutant_dna”:40, “count_human_dna”:100: “ratio”:0.4}\\n"+
                    "(ratio = mutants / humans)")
    })
    public StatsAdnDto getStats() {
        log.info("start webservice get stats");
        return serviceDna.getStats();
    }
}
