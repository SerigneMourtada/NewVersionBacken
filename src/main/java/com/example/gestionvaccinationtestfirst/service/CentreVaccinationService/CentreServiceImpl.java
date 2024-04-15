package com.example.gestionvaccinationtestfirst.service.CentreVaccinationService;
import com.example.gestionvaccinationtestfirst.DTos.CentreDTO;
import com.example.gestionvaccinationtestfirst.dtoMapper.centreMapper.CentreMapper;
import com.example.gestionvaccinationtestfirst.model.Carnet;
import com.example.gestionvaccinationtestfirst.model.Centre;
import com.example.gestionvaccinationtestfirst.repository.CentreRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@AllArgsConstructor
public class CentreServiceImpl implements CentreService {
    private CentreRepository centreRepository;

    private CentreMapper centreMapper;

    @Override
    public List<CentreDTO> getAllCentre()  {
        List<Centre> centreList = centreRepository.findAll();
        return centreMapper.asCentreDTOs(centreList);
    }

    @Override
    public CentreDTO saveCentreVaccination(CentreDTO centreDTO) {
        return centreMapper.asCentreDTO(centreRepository.save(centreMapper.asCentre(centreDTO)));
    }

    @Override
    public CentreDTO getCentreById(Long centreId)  {
        Centre centre = centreRepository.findById(centreId)
                .orElseThrow(() -> new EntityNotFoundException("Centre est introuvable"));
        return centreMapper.asCentreDTO(centre);
    }

    @Override
    public void deleteCentre(Long id) {
      Centre centre=centreRepository.findById(id)
               .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Not found Centre with id {0}",id)));
        centreRepository.delete(centre);
    }

    @Override
    public CentreDTO updateCentre(CentreDTO centreDTO) {

        Centre centre= centreRepository.findById(centreDTO.getId()).
                orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Not found Centre with id {0}", centreDTO.getId())));

        return centreMapper.asCentreDTO(centreRepository.save(centre));
    }
}

