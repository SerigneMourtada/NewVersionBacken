package com.example.gestionvaccinationtestfirst.DTos;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
@Data
public class VaccinationDTO {
    private Long id;

    private LocalDate date;

    private Long nombreDeDose;

    private VaccinDTO vaccinDTO;

    private UtilisateurDTO medcinDTO;

    private CarnetDTO carnetDTO;


}
