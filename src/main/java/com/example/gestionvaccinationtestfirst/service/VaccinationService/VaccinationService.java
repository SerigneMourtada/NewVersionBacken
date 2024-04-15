package com.example.gestionvaccinationtestfirst.service.VaccinationService;

import com.example.gestionvaccinationtestfirst.DTos.CarnetDTO;
import com.example.gestionvaccinationtestfirst.DTos.VaccinationDTO;

import java.util.List;

public interface VaccinationService {


    List<VaccinationDTO> readVaccinations();

    VaccinationDTO getVaccinationById(Long vaccinationId);

    VaccinationDTO createVaccination(VaccinationDTO vaccinationDTO);

    VaccinationDTO updateVaccination(VaccinationDTO vaccinationDTO);

    void deleteVaccination(Long vaccinationId);

}
