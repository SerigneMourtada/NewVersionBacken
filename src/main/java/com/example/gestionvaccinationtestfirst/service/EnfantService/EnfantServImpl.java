package com.example.gestionvaccinationtestfirst.service.EnfantService;

import com.example.gestionvaccinationtestfirst.DTos.EnfantDTO;
import com.example.gestionvaccinationtestfirst.dtoMapper.enfantMapper.EnfantMapper;
import com.example.gestionvaccinationtestfirst.model.Enfant;
import com.example.gestionvaccinationtestfirst.repository.EnfantRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
@Service
@AllArgsConstructor
@Slf4j
public class EnfantServImpl implements EnfantServ{
    private EnfantRepository enfantRepository;

    private EnfantMapper enfantMapper;




    @Override
    public List<EnfantDTO> readEnfants(){
        List<Enfant> enfantList=enfantRepository.findAll();
        return enfantMapper.asEnfantDTOs(enfantList);
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
        return enfantMapper.asEnfantDTO(enfant1);
    }

    @Override
    public EnfantDTO updateEnfant(EnfantDTO enfantDTO) {
        return null;
    }

    @Override
    public void deleteEnfant(Long enfantId){
        enfantRepository.findById(enfantId)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Not found Enfant with id {0}",enfantId)));


    }
}
