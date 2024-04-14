package com.example.gestionvaccinationtestfirst.repository;

import com.example.gestionvaccinationtestfirst.model.Vaccin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VaccinRepository extends JpaRepository<Vaccin,Long> {
}
