package com.example.gestionvaccinationtestfirst.dtoMapper.Utilisateur;

import com.example.gestionvaccinationtestfirst.DTos.UtilisateurDTO;
import com.example.gestionvaccinationtestfirst.model.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Data
@Service
@AllArgsConstructor
public class UtilisateurMapperFirst {

    public UtilisateurDTO asUtilisateurDTO(Utilisateur utilisateur){
        UtilisateurDTO utilisateurDTO=new UtilisateurDTO();
        BeanUtils.copyProperties(utilisateur,utilisateurDTO);
        return  utilisateurDTO;

    }

    public Utilisateur asUtilisateur(UtilisateurDTO utilisateurDTO){
        Utilisateur utilisateur=new Utilisateur();
        BeanUtils.copyProperties(utilisateurDTO,utilisateur);
        return utilisateur;
    }
}
