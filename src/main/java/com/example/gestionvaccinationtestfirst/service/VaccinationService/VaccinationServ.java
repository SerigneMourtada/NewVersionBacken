package com.example.gestionvaccinationtestfirst.service.VaccinationService;

import com.example.gestionvaccinationtestfirst.DTos.*;
import com.example.gestionvaccinationtestfirst.Excepyion.*;
import com.example.gestionvaccinationtestfirst.model.Vaccination;

import java.util.List;

public interface VaccinationServ {
    public List<VaccinationDTO> getAllVaccination();

    public VaccinationDTO getVaccinationById(Long vaccinationId)throws VaccinationNotFound;

    public void deleteVaccination(Long vaccinationId);
    public VaccinationDTO updateVaccination(VaccinationDTO vaccinationDTO);

    /**public VaccinationDTO saveVaccinatio(VaccinationDTO vaccinationDTO,Long enfantId,Long vaccinId,Long carnetId,Long userId) throws EnfantNotFoundException, VaccinNotFoundException, UtilisateurNotFoundException, EntityNotFoundException;




    List<HistoriqueDeVaccinationDTO> getHistoriqueVaccinationById(Long enfantId);

    List<VaccinationDTO> getHistory(Long enfantId);

    ***/
    void ValiderVaccination(Long vaccinationId) throws VaccinationNotFound;
}
