package com.example.gestionvaccinationtestfirst.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity @AllArgsConstructor @NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Maladie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nomMaladie;

    @ManyToMany(mappedBy = "maladies",fetch = FetchType.EAGER)
    List<Vaccin> vaccinList=new ArrayList<>();

}
