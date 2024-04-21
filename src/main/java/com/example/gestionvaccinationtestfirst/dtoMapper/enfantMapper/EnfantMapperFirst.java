package com.example.gestionvaccinationtestfirst.dtoMapper.enfantMapper;

import com.example.gestionvaccinationtestfirst.DTos.EnfantDTO;
import com.example.gestionvaccinationtestfirst.dtoMapper.Utilisateur.UtilisateurMapper;
import com.example.gestionvaccinationtestfirst.dtoMapper.Utilisateur.UtilisateurMapperFirst;
import com.example.gestionvaccinationtestfirst.model.Enfant;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Data
@Service
@AllArgsConstructor
public class EnfantMapperFirst {
    private UtilisateurMapperFirst utilisateurMapperFirst;

    public EnfantDTO asEnfantDTO(Enfant enfant){
        EnfantDTO enfantDTO=new EnfantDTO();
        BeanUtils.copyProperties(enfant,enfantDTO);
        enfantDTO.setParentDTO(utilisateurMapperFirst.asUtilisateurDTO(enfant.getParent()));
        return enfantDTO;
    }

    public Enfant asEnfant(EnfantDTO enfantDTO){
        Enfant enfant=new Enfant();
        BeanUtils.copyProperties(enfantDTO,enfant);
        enfant.setParent(utilisateurMapperFirst.asUtilisateur(enfantDTO.getParentDTO()));
        return  enfant;
    }
}
