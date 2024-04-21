package com.example.gestionvaccinationtestfirst.controller;
import com.example.gestionvaccinationtestfirst.DTos.CarnetDTO;
import com.example.gestionvaccinationtestfirst.DTos.EnfantDTO;
import com.example.gestionvaccinationtestfirst.model.Carnet;
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
@CrossOrigin("*")
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
   // @PostMapping(consumes = "application/json")
    @PostMapping("/{parentId}")
    public CarnetDTO saveCarnet(@Validated @RequestBody EnfantDTO enfantDTO,
                                @PathVariable("parentId") Long parentId){
        return carnetService.createCarnet(enfantDTO,parentId);
    }




    @Operation(summary = "Read Carnet by Id", description = "Read an kpi by identified")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping("/{parentId}")
    @ResponseStatus(HttpStatus.OK)
    public List<CarnetDTO> readCarnetById(@Parameter(description = "Carnet identifier", name = "parentId", required = true) @PathVariable("parentId") Long parentId) {
        return carnetService.getCarnetsById(parentId);
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


    @Operation(summary = "Update Carnet", description = "Update Carnet")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @PutMapping("/{carnetId}")
    public CarnetDTO updateCarnet(@Validated @RequestBody CarnetDTO carnetDTO,
                                  @PathVariable("carnetId") Long carnetId){
        //carnetDTO.setId(carnetId);

        return carnetService.updateCarnet(carnetDTO);
    }
}
