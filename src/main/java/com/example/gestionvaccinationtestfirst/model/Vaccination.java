package com.example.gestionvaccinationtestfirst.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Vaccination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate date;

    Long nombreDeDose;


    @ManyToOne
    @JoinColumn(name = "vaccin_id")
    Vaccin vaccin;


    @ManyToOne
    Carnet carnet;

    @ManyToOne
    Utilisateur medcin;


}

