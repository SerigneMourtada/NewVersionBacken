package com.example.gestionvaccinationtestfirst.DTos;

import lombok.Data;

@Data
public class ConsultationDTO {
    private Long id;

    private String poids;

    private Long temperature;

    private EnfantDTO enfantDTO;


}
