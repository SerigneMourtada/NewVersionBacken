package com.example.gestionvaccinationtestfirst.service.UserService;

import com.example.gestionvaccinationtestfirst.DTos.CentreDTO;
import com.example.gestionvaccinationtestfirst.DTos.UtilisateurDTO;
import com.example.gestionvaccinationtestfirst.Excepyion.UtilisateurNotFoundException;
import com.example.gestionvaccinationtestfirst.dtoMapper.Utilisateur.UtilisateurMapper;
import com.example.gestionvaccinationtestfirst.dtoMapper.centreMapper.CentreMapper;
import com.example.gestionvaccinationtestfirst.model.Carnet;
import com.example.gestionvaccinationtestfirst.model.Centre;
import com.example.gestionvaccinationtestfirst.model.Utilisateur;
import com.example.gestionvaccinationtestfirst.repository.CentreRepository;
import com.example.gestionvaccinationtestfirst.repository.UtilisateurRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor

public class UtilisateurServiceImpl implements UtilisateurService{
    private CentreMapper centreVaccMapper;

    private UtilisateurRepository utilisateurRepository;

    private CentreRepository centreRepository;

    private UtilisateurMapper utilisateurMapper;


    @Override
    public List<UtilisateurDTO> readUtilisateurs(){
       List<Utilisateur> utilisateurs= utilisateurRepository.findAll();
        return utilisateurMapper.asUtilisateurDTOs(utilisateurs);
    }

    @Override
    public UtilisateurDTO getUtilisateurById(Long userId){
        Utilisateur user=utilisateurRepository.findById(userId)
                .orElseThrow((() -> new EntityNotFoundException(MessageFormat.format("Not found Utilisateur with id {0}", userId))));

        return utilisateurMapper.asUtilisateurDTO(user);
    }

    @Override
    public UtilisateurDTO createUtilisateur(UtilisateurDTO utilisateurDTO){
       Utilisateur utilisateur= utilisateurMapper.asUtilisateur(utilisateurDTO);
       Utilisateur utilisateur1=utilisateurRepository.save(utilisateur);
        return utilisateurMapper.asUtilisateurDTO(utilisateur1);
    }

    @Override
    public UtilisateurDTO updateUtilisateur(UtilisateurDTO utilisateurDTO) {
        Utilisateur utilisateur=utilisateurRepository.findById(utilisateurDTO.getId()).
                orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Not found Utilisateur with id {0}", utilisateurDTO.getId())));

        return utilisateurMapper.asUtilisateurDTO(utilisateurRepository.save(utilisateur));

    }

    @Override
    public void deleteUtilisateur(Long userId){
        Utilisateur utilisateur=utilisateurRepository.findById(userId)
                .orElseThrow((() -> new EntityNotFoundException(MessageFormat.format("Not found Utilisateur with id {0}", userId))));

        utilisateurRepository.delete(utilisateur);
    }
}
