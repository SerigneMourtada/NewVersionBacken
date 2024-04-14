package com.example.gestionvaccinationtestfirst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.lang.management.ManagementFactory;


@SpringBootApplication
@CrossOrigin("*")
public class GestionVaccinationTestFirstApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionVaccinationTestFirstApplication.class, args);
    }

}
