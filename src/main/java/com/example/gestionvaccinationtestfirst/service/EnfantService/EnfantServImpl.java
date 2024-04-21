package com.example.gestionvaccinationtestfirst.service.EnfantService;

import com.example.gestionvaccinationtestfirst.DTos.CarnetDTO;
import com.example.gestionvaccinationtestfirst.DTos.EnfantDTO;
import com.example.gestionvaccinationtestfirst.DTos.UtilisateurDTO;
import com.example.gestionvaccinationtestfirst.dtoMapper.Utilisateur.UtilisateurMapper;
import com.example.gestionvaccinationtestfirst.dtoMapper.Utilisateur.UtilisateurMapperFirst;
import com.example.gestionvaccinationtestfirst.dtoMapper.carnetMapper.CarnetMapper;
import com.example.gestionvaccinationtestfirst.dtoMapper.enfantMapper.EnfantMapper;
import com.example.gestionvaccinationtestfirst.dtoMapper.enfantMapper.EnfantMapperFirst;
import com.example.gestionvaccinationtestfirst.model.Carnet;
import com.example.gestionvaccinationtestfirst.model.Enfant;
import com.example.gestionvaccinationtestfirst.model.Utilisateur;
import com.example.gestionvaccinationtestfirst.repository.CarnetRepository;
import com.example.gestionvaccinationtestfirst.repository.EnfantRepository;
import com.example.gestionvaccinationtestfirst.repository.UtilisateurRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class EnfantServImpl implements EnfantServ{
    private final CarnetRepository carnetRepository;
    private EnfantRepository enfantRepository;

    private EnfantMapper enfantMapper;

    private UtilisateurRepository utilisateurRepository;

    //private UtilisateurMapper utilisateurMapper;

    private EnfantMapperFirst enfantMapperFirst;

    private CarnetMapper carnetMapper;




    @Override
    public List<EnfantDTO> readEnfants(){
        List<Enfant> enfantList=enfantRepository.findAll();
        List<EnfantDTO> enfantDTOList=enfantList.stream().map(enfant -> enfantMapperFirst.asEnfantDTO(enfant))
                .collect(Collectors.toList());
        return enfantDTOList;
    }

    @Override
    public EnfantDTO getEnfantById(Long enfantId){
      Enfant enfant=enfantRepository.findById(enfantId)
                    .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Not found Enfant with id {0}",enfantId)));

        return enfantMapper.asEnfantDTO(enfant);
    }

    @Override
    public EnfantDTO createEnfant(EnfantDTO enfantDTO){
       Enfant enfant=enfantMapper.asEnfant(enfantDTO);
       Enfant enfant1=enfantRepository.save(enfant);
        return enfantMapperFirst.asEnfantDTO(enfant1);
    }

    @Override
    public EnfantDTO updateEnfant(EnfantDTO enfantDTO){
        Enfant enfant=enfantRepository.findById(enfantDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Not found Enfant with id {0}",enfantDTO.getId())));

        return enfantMapperFirst.asEnfantDTO(enfantRepository.save(enfant));
    }

    @Override
    public void deleteEnfant(Long enfantId){
        enfantRepository.deleteById(enfantId);
//        enfantRepository.findById(enfantId)
//                .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Not found Enfant with id {0}",enfantId)));


    }


//    public EnfantDTO createEnfant(EnfantDTO enfantDTO, Long parentId){
//        Utilisateur parent =utilisateurRepository.findById(parentId)
//                .orElseThrow(()-> new EntityNotFoundException(MessageFormat.format("Not found Parent with id {0}",parentId)));
//        //Enfant enfant=enfantMapper.asEnfant(enfantDTO);
//
//        Enfant enfant1=new Enfant();
//        enfant1.setNom(enfantDTO.getNom());
//        enfant1.setPrenom(enfantDTO.getPrenom());
//        enfant1.setSexe(enfantDTO.getSexe());
//        enfant1.setDateDeNaissance(enfantDTO.getDateDeNaissance());
//        enfant1.setParent(parent);
//        enfantRepository.save(enfant1);
//
//        Carnet carnet=new Carnet();
//        carnet.setEnfant(enfant1);
//        carnet.setParent(parent);
//        carnetRepository.save(carnet);
//
//        //UtilisateurDTO parentDTO=utilisateurMapper.asUtilisateurDTO(parent);
//        //enfantDTO.setParentDTO(parentDTO);
//        EnfantDTO enfantDTO1=new EnfantDTO();
//        enfantDTO1.setId(enfant1.getId());
//        enfantDTO1.setNom(enfant1.getNom());
//        enfantDTO1.setPrenom(enfant1.getPrenom());
//        enfantDTO1.setSexe(enfant1.getSexe());
//        enfantDTO1.setDateDeNaissance(enfant1.getDateDeNaissance());
//        enfantDTO1.setParentDTO(utilisateurMapperF.asUtilisateurDTO(parent));
//
//
//
//        return enfantDTO1;
//    }
}
