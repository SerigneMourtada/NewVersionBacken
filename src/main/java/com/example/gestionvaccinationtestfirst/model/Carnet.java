package com.example.gestionvaccinationtestfirst.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor

//@FieldDefaults(level = AccessLevel.PRIVATE)
public class Carnet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enfant_id", referencedColumnName = "id")
    @ToString.Exclude
    private Enfant enfant;

    @OneToMany(mappedBy = "carnet")
    @ToString.Exclude
    private List<Rendez_Vous> rendezVousList;

    @ManyToOne
    private Utilisateur parent;


    @OneToMany(mappedBy = "carnet",cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<Vaccination> vaccinationList;
}
