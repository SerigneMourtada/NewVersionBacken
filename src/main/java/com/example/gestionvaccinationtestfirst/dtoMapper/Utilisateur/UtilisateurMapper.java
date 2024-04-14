package com.example.gestionvaccinationtestfirst.dtoMapper.Utilisateur;

import com.example.gestionvaccinationtestfirst.DTos.UtilisateurDTO;
import com.example.gestionvaccinationtestfirst.model.Utilisateur;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UtilisateurMapper {
    Utilisateur asUtilisateur(UtilisateurDTO utilisateurDTO);

    UtilisateurDTO asUtilisateurDTO(Utilisateur utilisateur);

    List<Utilisateur> asUtilisateurs(List<UtilisateurDTO> utilisateurDTOs);

    List<UtilisateurDTO> asUtilisateurDTOs(List<Utilisateur> utilisateurs);
}
