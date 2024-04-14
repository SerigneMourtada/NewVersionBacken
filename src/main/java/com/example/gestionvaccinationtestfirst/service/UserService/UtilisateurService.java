package com.example.gestionvaccinationtestfirst.service.UserService;

import com.example.gestionvaccinationtestfirst.DTos.EnfantDTO;
import com.example.gestionvaccinationtestfirst.DTos.UtilisateurDTO;
import com.example.gestionvaccinationtestfirst.Excepyion.EntityNotFoundException;
import com.example.gestionvaccinationtestfirst.Excepyion.UtilisateurNotFoundException;

import java.util.List;

public interface UtilisateurService {

    List<UtilisateurDTO> readUtilisateurs();

    UtilisateurDTO getUtilisateurById(Long userId);

    UtilisateurDTO createUtilisateur(UtilisateurDTO utilisateurDTO);

    UtilisateurDTO updateUtilisateur(UtilisateurDTO utilisateurDTO);

    void deleteUtilisateur(Long userId);


}
