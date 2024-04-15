package com.example.gestionvaccinationtestfirst.controller;
import com.example.gestionvaccinationtestfirst.DTos.EnfantDTO;
import com.example.gestionvaccinationtestfirst.DTos.MaladieDTO;
import com.example.gestionvaccinationtestfirst.service.MaladieService.MaladieService;
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
@RequestMapping("/maladie")
public class MaladieController {
    private MaladieService maladieServ;

    @Operation(summary = "Read Maladie by Id", description = "Read an maladie by identified")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MaladieDTO> readMaladies(){
        return maladieServ.readMaladies();
    }

    @Operation(summary = "Maladie", description = "Create maladie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public MaladieDTO saveMaladie(@Validated @RequestBody MaladieDTO maladieDTO){
        return maladieServ.createMaladie(maladieDTO);
    }


    @Operation(summary = "Read Maladie by Id", description = "Read an Maladie by identified")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping("/{maladieId}")
    @ResponseStatus(HttpStatus.OK)
    public MaladieDTO readMaladieById(@Parameter(description = "Maladie identifier", name = "maladieId", required = true) @PathVariable("maladieId") Long maladieId) {
        return maladieServ.getMaladieById(maladieId);
    }



    @Operation(summary = "Delete Maladie", description = "Delete Maladie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @DeleteMapping("/{MaladieId}")
    public void deleteMaladie(@PathVariable("maladieId") Long maladieId){

       maladieServ.deleteMaladie(maladieId);
    }


    @Operation(summary = "Update Maladie", description = "Update Maladie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @PutMapping("/{maladieId}")
    public MaladieDTO updateMaladie(@Validated @RequestBody MaladieDTO maladieDTO,
                                  @PathVariable("maladieId") Long maladieId){
        maladieDTO.setId(maladieId);

        return maladieServ.updateMaladie(maladieDTO);
    }

}
