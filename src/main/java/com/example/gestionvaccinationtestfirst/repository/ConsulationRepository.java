package com.example.gestionvaccinationtestfirst.repository;

import com.example.gestionvaccinationtestfirst.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsulationRepository extends JpaRepository<Consultation,Long> {
}
