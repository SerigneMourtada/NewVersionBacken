package com.example.gestionvaccinationtestfirst.controller;

import com.example.gestionvaccinationtestfirst.DTos.CarnetDTO;
import com.example.gestionvaccinationtestfirst.DTos.UtilisateurDTO;
import com.example.gestionvaccinationtestfirst.Excepyion.EntityNotFoundException;
import com.example.gestionvaccinationtestfirst.Excepyion.UtilisateurNotFoundException;
import com.example.gestionvaccinationtestfirst.service.UserService.UtilisateurService;
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
@RequestMapping("/utilisateur")
@AllArgsConstructor
@CrossOrigin("*")

public class UtilisateurController {
    private UtilisateurService utilisateurService;

    @Operation(summary = "Read Utilisateur by Id", description = "Read an utilisateur by identified")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UtilisateurDTO> readUtilisateurs(){
        return utilisateurService.readUtilisateurs();
    }


    @Operation(summary = "Utilisateur", description = "Create utiisateur")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public UtilisateurDTO createUser(@Validated @RequestBody UtilisateurDTO utilisateurDTO){
        return utilisateurService.createUser(utilisateurDTO);
    }

    @Operation(summary = "Read Utilisateur by Id", description = "Read an Utilisateur by identified")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping("/{utilisateurId}")
    @ResponseStatus(HttpStatus.OK)
    public UtilisateurDTO readUtilisateurById(@Parameter(description = "Utilisateur identifier", name = "utilisateurId", required = true) @PathVariable("utilisateurId") Long utilisateurId) {
        return utilisateurService.getUtilisateurById(utilisateurId);
    }



    @Operation(summary = "Delete Utilisateur", description = "Delete Utilisateur")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @DeleteMapping("/{utilisateurId}")
    public void deleteUtilisateur(@PathVariable("utilisateurId") Long utilisateurId){
        utilisateurService.deleteUtilisateur(utilisateurId);
    }

    @Operation(summary = "Update Utilisateur", description = "Update Utilisateur")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Resource access does not exist"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @PutMapping("/{utilisateurId}")
    public UtilisateurDTO updateUtilisateur(@Validated @RequestBody UtilisateurDTO utilisateurDTO,
            @PathVariable("utilisateurId") Long utilisateurId){
        utilisateurDTO.setId(utilisateurId);
        return utilisateurService.updateUtilisateur(utilisateurDTO);
    }



}
