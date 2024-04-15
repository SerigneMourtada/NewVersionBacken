package com.example.gestionvaccinationtestfirst.controller;

import com.example.gestionvaccinationtestfirst.DTos.UtilisateurDTO;
import com.example.gestionvaccinationtestfirst.DTos.VaccinationDTO;
import com.example.gestionvaccinationtestfirst.Excepyion.*;
import com.example.gestionvaccinationtestfirst.service.VaccinationService.VaccinationService;
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
@RequestMapping("/vaccination")
public class VaccinationController{

    private VaccinationService vaccinationService;


    @Operation(summary = "Read List Vaccination", description = "Read Vaccination List")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<VaccinationDTO> readVaccinations(){
        return vaccinationService.readVaccinations();
    }


    @Operation(summary = "Vaccination", description = "Create Vaccination")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public VaccinationDTO saveVaccination(@Validated @RequestBody VaccinationDTO vaccinationDTO){
        return vaccinationService.createVaccination(vaccinationDTO);
    }


    @Operation(summary = "Read Vaccination by Id", description = "Read an Vaccination By Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping("/{vaccinationId}")
    @ResponseStatus(HttpStatus.OK)
    public VaccinationDTO readVaccinationById(@Parameter(description = "Vaccination identifier", name = "vaccinationId", required = true) @PathVariable("vaccinationId") Long vaccinationId) {
        return vaccinationService.getVaccinationById(vaccinationId);
    }



    @Operation(summary = "Delete Vaccination", description = "Delete Vaccination")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @DeleteMapping("/{vaccinationId}")
    public void deleteVaccination(@PathVariable("vaccinationId") Long vaccinationId){
       vaccinationService.deleteVaccination(vaccinationId);
    }

    @Operation(summary = "Update Vaccination", description = "Update Vaccination")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @PutMapping("/{vaccinationId}")
    public VaccinationDTO updateVaccination(@Validated @RequestBody VaccinationDTO vaccinationDTO,
                                            @PathVariable("vaccinationId") Long vaccinationId){
        vaccinationDTO.setId(vaccinationId);
        return vaccinationService.updateVaccination(vaccinationDTO);
    }






}
