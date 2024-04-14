package com.example.gestionvaccinationtestfirst.DTos;

import lombok.Data;

@Data
public class UtilisateurDTO {
    private Long id;

    private String nom;

    private String prenom;

    private String addresse;

    private String email;

    private String telephone;

    private String password;


    private CentreDTO centreVaccinationDTO;

}
