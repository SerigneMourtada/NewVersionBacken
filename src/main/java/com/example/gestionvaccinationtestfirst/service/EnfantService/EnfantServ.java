package com.example.gestionvaccinationtestfirst.service.EnfantService;


import com.example.gestionvaccinationtestfirst.DTos.EnfantDTO;

import java.util.List;

public interface EnfantServ {
    List<EnfantDTO> readEnfants();

    EnfantDTO getEnfantById(Long enfantId);

    EnfantDTO createEnfant(EnfantDTO enfantDTO);

    EnfantDTO updateEnfant(EnfantDTO enfantDTO);

    void deleteEnfant(Long enfantId);

   // EnfantDTO createEnfant(EnfantDTO enfantDTO,Long parentId);


}
