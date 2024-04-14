package com.example.gestionvaccinationtestfirst.service.CentreVaccinationService;
import com.example.gestionvaccinationtestfirst.DTos.CentreDTO;
import com.example.gestionvaccinationtestfirst.dtoMapper.centreMapper.CentreMapper;
import com.example.gestionvaccinationtestfirst.model.Centre;
import com.example.gestionvaccinationtestfirst.repository.CentreRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
        centreRepository.deleteById(id);

    }

    @Override
    public CentreDTO updateCentre(CentreDTO CentreDTO) {

        Centre centre = centreMapper.asCentre(CentreDTO);
        Centre centre1 = centreRepository.save(centre);
        return centreMapper.asCentreDTO(centre1);
    }
}

