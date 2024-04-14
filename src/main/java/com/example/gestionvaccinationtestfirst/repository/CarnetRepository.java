package com.example.gestionvaccinationtestfirst.repository;

import com.example.gestionvaccinationtestfirst.model.Carnet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarnetRepository extends JpaRepository<Carnet,Long> {

}
