package com.example.gestionvaccinationtestfirst.DTos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
@Data
public class EnfantDTO {
    private Long id;

    private String nom;

    private String prenom;

    private String sexe;

    private LocalDate dateDeNaissance;

    private UtilisateurDTO parentDTO;







}
