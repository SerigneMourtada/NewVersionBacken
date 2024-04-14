package com.example.gestionvaccinationtestfirst.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Entity @AllArgsConstructor @NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Consultation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String poids;

    Long temperature;

    @ManyToOne
    Enfant enfant;

}
