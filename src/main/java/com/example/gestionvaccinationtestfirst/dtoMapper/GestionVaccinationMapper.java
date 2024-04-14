package com.example.gestionvaccinationtestfirst.dtoMapper;

import com.example.gestionvaccinationtestfirst.DTos.EnfantDTO;
import com.example.gestionvaccinationtestfirst.model.Enfant;
import org.springframework.beans.BeanUtils;

public class GestionVaccinationMapper {
   public Enfant fromEnfantDTO(EnfantDTO enfantDTO){
        Enfant enfant=new Enfant();
        BeanUtils.copyProperties(enfantDTO,enfant);
        return  enfant;
    }

    public EnfantDTO fromEnfant(Enfant enfant){
       EnfantDTO enfantDTO=new EnfantDTO();
       BeanUtils.copyProperties(enfant,enfantDTO);
       return enfantDTO;
    }
}
