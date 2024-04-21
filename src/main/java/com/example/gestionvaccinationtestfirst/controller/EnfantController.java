package com.example.gestionvaccinationtestfirst.controller;
import com.example.gestionvaccinationtestfirst.DTos.CarnetDTO;
import com.example.gestionvaccinationtestfirst.DTos.EnfantDTO;
import com.example.gestionvaccinationtestfirst.service.EnfantService.EnfantServ;
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
@RequestMapping("/enfant")
@AllArgsConstructor
@CrossOrigin("*")

public class EnfantController {
    private EnfantServ enfantServ;

    @Operation(summary = "Read Enfant by Id", description = "Read enfant by identified")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EnfantDTO> readEnfants(){
        return enfantServ.readEnfants();
    }



    @Operation(summary = "Enfant", description = "Create enfant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public EnfantDTO saveEnfant(@Validated @RequestBody EnfantDTO enfantDTO){
        return enfantServ.createEnfant(enfantDTO);
    }



    @Operation(summary = "Read Enfant by Id", description = "Read an kpi by identified")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })

    @GetMapping("/{enfantId}")
    @ResponseStatus(HttpStatus.OK)
    public EnfantDTO readEnfantById(@Parameter(description = "Enfant identifier", name = "enfantId", required = true) @PathVariable("enfantId") Long enfantId) {
        return enfantServ.getEnfantById(enfantId);
    }



    @Operation(summary = "Delete Enfant", description = "Delete Enfant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @DeleteMapping("/{enfantId}")
    public void deleteEnfant(@PathVariable("enfantId") Long enfantId){

        enfantServ.deleteEnfant(enfantId);
    }

    @Operation(summary = "Update Enfant", description = "Update Enfant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @PutMapping("/{enfantId}")
    public EnfantDTO updateEnfant(@Validated @RequestBody EnfantDTO enfantDTO,
                                  @PathVariable("enfantId") Long enfantId){
        enfantDTO.setId(enfantId);

        return enfantServ.updateEnfant(enfantDTO);
    }

//    @Operation(summary = "Enfant", description = "Create Enfant")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "201", description = "Success"),
//            @ApiResponse(responseCode = "400", description = "Bad request"),
//            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
//            @ApiResponse(responseCode = "500", description = "Server Error")
//    })
//    @ResponseStatus(HttpStatus.CREATED)
//    // @PostMapping(consumes = "application/json")
//    @PostMapping("/{parentId}")
//    public EnfantDTO saveCarnet(@Validated @RequestBody EnfantDTO enfantDTO,
//                                @PathVariable("parentId") Long parentId){
//        return enfantServ.createEnfant(enfantDTO,parentId);
//    }


}
