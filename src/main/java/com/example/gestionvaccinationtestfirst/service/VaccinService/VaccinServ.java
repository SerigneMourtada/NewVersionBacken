package com.example.gestionvaccinationtestfirst.service.VaccinService;

import com.example.gestionvaccinationtestfirst.DTos.UtilisateurDTO;
import com.example.gestionvaccinationtestfirst.DTos.VaccinDTO;
import com.example.gestionvaccinationtestfirst.Excepyion.VaccinNotFoundException;

import java.util.List;

public interface VaccinServ {
    List<VaccinDTO> readVaccins();

    VaccinDTO getVaccinById(Long vaccinId);

    VaccinDTO createVaccin(VaccinDTO vaccinDTO);

    VaccinDTO updateVaccin(VaccinDTO vaccinDTO);

    void deleteVaccin(Long vaccinId);
}
