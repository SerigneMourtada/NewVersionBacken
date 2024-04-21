package com.example.gestionvaccinationtestfirst.DTos;

import lombok.Data;

@Data
public class VaccinDTO{
    private Long id;

    private String nomVaccin;

    private Long numeroDeLot;

    private String effetSecondaires;
}
