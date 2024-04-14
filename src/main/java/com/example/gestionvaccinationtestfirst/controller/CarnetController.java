package com.example.gestionvaccinationtestfirst.controller;
import com.example.gestionvaccinationtestfirst.DTos.CarnetDTO;
import com.example.gestionvaccinationtestfirst.service.carnetService.CarnetService;
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
@RequestMapping("/carnet")
@AllArgsConstructor

public class CarnetController{
    private CarnetService carnetService;

    @Operation(summary = "Read Carnet by Id", description = "Read an carnet by identified")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CarnetDTO> readCarnets(){
        return carnetService.readCarnets();
    }

    @Operation(summary = "Carnet", description = "Create carnet")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public CarnetDTO saveCarnet(@Validated @RequestBody CarnetDTO carnetDTO){
        return carnetService.createCarnet(carnetDTO);
    }

    @Operation(summary = "Read Carnet by Id", description = "Read an kpi by identified")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping("/{carnetId}")
    @ResponseStatus(HttpStatus.OK)
    public CarnetDTO readCarnetById(@Parameter(description = "Carnet identifier", name = "carnetId", required = true) @PathVariable("carnetId") Long carnetId) {
        return carnetService.getCarnetById(carnetId);
    }

    @Operation(summary = "Delete Carnet", description = "Delete Carnet")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @DeleteMapping("/{carnetId}")
    public void deleteCarnet(@PathVariable("carnetId") Long carnetId){
        carnetService.deleteCarnet(carnetId);
    }

}
