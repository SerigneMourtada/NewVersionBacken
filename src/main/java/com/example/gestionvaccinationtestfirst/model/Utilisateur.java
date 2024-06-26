package com.example.gestionvaccinationtestfirst.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Utilisateur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nom;

    String prenom;

    String addresse;

    @Column(unique = true)
    String email;

    String telephone;

    String password;

    @ManyToOne
    @JoinColumn(name = "centreVaccination_id")
    Centre centre;

    @OneToMany(mappedBy = "parent",cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    List<Carnet> carnetList;

    @OneToMany(mappedBy = "medcin")
    @ToString.Exclude
    List<Vaccination> vaccinationList;


    @OneToMany(mappedBy = "secretaire",fetch = FetchType.EAGER)
    List<Rendez_Vous> rendezVousList;


    @OneToMany(mappedBy = "parent")
    List<Enfant> enfants=new ArrayList<>();


}
