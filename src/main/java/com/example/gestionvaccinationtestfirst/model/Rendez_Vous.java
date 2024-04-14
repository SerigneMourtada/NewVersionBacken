package com.example.gestionvaccinationtestfirst.model;

import com.example.gestionvaccinationtestfirst.enumerations.Etat_Rendez_Vous;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Rendez_Vous {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate  date;

    @DateTimeFormat(pattern = "HH:mm")
    LocalTime heure;

    String telephone;

    Etat_Rendez_Vous etat_rendez_vous;


    @ManyToOne
    Utilisateur secretaire;

    @ManyToOne
    Carnet carnet;


}
