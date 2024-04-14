package com.example.gestionvaccinationtestfirst.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Centre {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nom;

     String addresse;

    LocalTime heure_Ouverture;

    LocalTime heure_De_Fermeture;

    String email;




}
