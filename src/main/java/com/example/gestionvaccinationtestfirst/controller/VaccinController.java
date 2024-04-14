package com.example.gestionvaccinationtestfirst.controller;

import com.example.gestionvaccinationtestfirst.DTos.EnfantDTO;
import com.example.gestionvaccinationtestfirst.DTos.VaccinDTO;
import com.example.gestionvaccinationtestfirst.Excepyion.VaccinNotFoundException;
import com.example.gestionvaccinationtestfirst.service.VaccinService.VaccinServ;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/vaccin")
public class VaccinController {
    private VaccinServ vaccinServ;


    @Operation(summary = "Read Vaccin by Id", description = "Read Vaccin by identified")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<VaccinDTO> readVaccins(){
        return vaccinServ.readVaccins();
    }





    @Operation(summary = "Vaccin", description = "Create Vaccin")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public VaccinDTO saveVaccin(@Validated @RequestBody VaccinDTO vaccinDTO){
        return vaccinServ.createVaccin(vaccinDTO);
    }





    @Operation(summary = "Read Vaccin by Id", description = "Read an Vaccin by identified")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })

    @GetMapping("/{vaccinId}")
    @ResponseStatus(HttpStatus.OK)
    public VaccinDTO readVaccinById(@Parameter(description = "Vaccin identifier", name = "vaccinId", required = true) @PathVariable("vaccinId") Long vaccinId) {
        return vaccinServ.getVaccinById(vaccinId);
    }





    @Operation(summary = "Delete Vaccin", description = "Delete Vaccin")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @DeleteMapping("/{vaccinId}")
    public void deleteVaccin(@PathVariable("vaccinId") Long vaccinId){

        vaccinServ.deleteVaccin(vaccinId);
    }
}
