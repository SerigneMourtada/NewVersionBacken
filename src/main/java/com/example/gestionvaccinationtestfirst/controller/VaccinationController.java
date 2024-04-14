package com.example.gestionvaccinationtestfirst.controller;

import com.example.gestionvaccinationtestfirst.DTos.HistoriqueDeVaccinationDTO;
import com.example.gestionvaccinationtestfirst.DTos.VaccinationDTO;
import com.example.gestionvaccinationtestfirst.Excepyion.*;
import com.example.gestionvaccinationtestfirst.model.Vaccination;
import com.example.gestionvaccinationtestfirst.service.VaccinationService.VaccinationServ;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Vaccination")
public class VaccinationController {

    private VaccinationServ vaccinationServ;

        @GetMapping("/vaccinations")
    public List<VaccinationDTO> getAllVaccination(){
        return vaccinationServ.getAllVaccination();
    }

    @GetMapping("/vaccinations/{VaccinationId}")
    public VaccinationDTO getVaccinationById(@PathVariable(name="vaccinationId") Long vaccinationId) throws VaccinationNotFound {
        return vaccinationServ.getVaccinationById(vaccinationId);
    }

    /**@PostMapping("/vaccinations/{enfantId}/{vaccinId}/{carnetId}/{userId}")
    public VaccinationDTO saveVaccination(@RequestBody VaccinationDTO vaccinationDTO,
                                          @PathVariable(name="enfantId") Long enfantId,
                                          @PathVariable(name="vaccinId") Long vaccinId,
                                          @PathVariable(name="carnetId") Long carnetId,
                                          @PathVariable(name="userId") Long userId) throws EnfantNotFoundException, VaccinNotFoundException, EntityNotFoundException, UtilisateurNotFoundException {
        return vaccinationServ.saveVaccinatio(vaccinationDTO,enfantId,vaccinId,carnetId,userId);

    }

    @GetMapping("/historiqueVaccination/{enfantId}")
    public List<HistoriqueDeVaccinationDTO> getHistoriqueVaccinationEnfantById(@PathVariable(name = "enfantId") Long enfantId){
        return vaccinationServ.getHistoriqueVaccinationById(enfantId);
    }



    //Premiere end point de Test pour historique Vaccination

    @GetMapping("/vaccinations/{enfantId}/historique")
    public List<VaccinationDTO> getHistoryVaccinationEnfant(@PathVariable Long enfantId){
            return vaccinationServ.getHistory(enfantId);
    }**/





}
