package com.example.gestionvaccinationtestfirst.DTos;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
@Data
public class VaccinationDTO {
    private Long id;

    private LocalDate dateVaccinationActuelle;

    private LocalDate dateProchaineVaccination;

    private Long nombreDeDose;

    private Boolean estEffectuer;

    private String siteDadministration;

    private EnfantDTO enfantDTO;

    private VaccinDTO vaccinDTO;

    private CarnetDTO carnetVaccinationDTO;

    private UtilisateurDTO utilisateurDTO;

}
