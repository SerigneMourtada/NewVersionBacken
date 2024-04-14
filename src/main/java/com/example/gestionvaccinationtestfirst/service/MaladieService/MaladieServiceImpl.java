package com.example.gestionvaccinationtestfirst.service.MaladieService;
import com.example.gestionvaccinationtestfirst.DTos.MaladieDTO;
import com.example.gestionvaccinationtestfirst.dtoMapper.maladieMapper.MaladieMapper;
import com.example.gestionvaccinationtestfirst.model.Maladie;
import com.example.gestionvaccinationtestfirst.repository.MaladieRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@AllArgsConstructor

public class MaladieServiceImpl implements MaladieService {
    private MaladieRepository maladieRepository;

    private MaladieMapper maladieMapper;




    @Override
    public List<MaladieDTO> readMaladies(){
        List<Maladie> maladies=maladieRepository.findAll();
        return maladieMapper.asMaladieDTOs(maladies);
    }

    @Override
    public MaladieDTO getMaladieById(Long maladieId){
        Maladie maladie=maladieRepository.findById(maladieId)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Not found Consultation with id {0}", maladieId)));
        return maladieMapper.asMaladieDTO(maladie);
    }

    @Override
    public MaladieDTO createMaladie(MaladieDTO maladieDTO){
        Maladie maladie=maladieMapper.asMaladie(maladieDTO);
        return maladieMapper.asMaladieDTO(maladieRepository.save(maladie));
    }

    @Override
    public MaladieDTO updateMaladie(MaladieDTO maladieDTO){
        Maladie maladie=maladieRepository.findById(maladieDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Not found Maladie with id {0}",maladieDTO.getId())));
        return maladieMapper.asMaladieDTO(maladieRepository.save(maladie));
    }

    @Override
    public void deleteMaladie(Long maladieId){
       Maladie maladie= maladieRepository.findById(maladieId)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Not found Maladie with id {0}",maladieId)));
       maladieRepository.delete(maladie);
    }
}
