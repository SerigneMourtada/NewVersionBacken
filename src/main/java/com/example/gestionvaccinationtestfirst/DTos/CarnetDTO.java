package com.example.gestionvaccinationtestfirst.DTos;

import com.example.gestionvaccinationtestfirst.model.Enfant;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
public class CarnetDTO {
    private Long id;

    private UtilisateurDTO parentDTO;

    private EnfantDTO enfantDTO;



}
