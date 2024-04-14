package com.example.gestionvaccinationtestfirst.DTos;

import lombok.Data;

import java.util.Date;

@Data
public class HistoriqueDeVaccinationDTO {
    private String nomEnfant;

    private String prenomEnfant;

    private String nomVaccin;

    private Date dateVaccination;

    private Long numeroLot;

    private String effetSecondaire;


}
