package com.example.gestionvaccinationtestfirst.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Carnet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enfant_id", referencedColumnName = "id")
    Enfant enfant;

    @OneToMany(mappedBy = "carnet")
    List<Rendez_Vous> rendezVousList;

    @ManyToOne
    Utilisateur parent;


    @OneToMany(mappedBy = "carnet",cascade = CascadeType.ALL, orphanRemoval = true)
    List<Vaccination> vaccinationList;
}
