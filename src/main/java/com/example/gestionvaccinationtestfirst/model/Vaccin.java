package com.example.gestionvaccinationtestfirst.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor

public class Vaccin {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomVaccin;

    private Long numeroDeLot;

    private String effetSecondaires;

    @ManyToMany(fetch = FetchType.EAGER)
    List<Maladie> maladies=new ArrayList<>();

    @OneToMany(mappedBy ="vaccin",cascade = CascadeType.ALL, orphanRemoval = true)
    List<Vaccination> vaccinationList;


}
