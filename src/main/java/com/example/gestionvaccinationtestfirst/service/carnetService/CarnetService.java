package com.example.gestionvaccinationtestfirst.service.carnetService;

import com.example.gestionvaccinationtestfirst.DTos.CarnetDTO;
import com.example.gestionvaccinationtestfirst.DTos.EnfantDTO;
import com.example.gestionvaccinationtestfirst.Excepyion.EntityNotFoundException;
import com.example.gestionvaccinationtestfirst.model.Carnet;

import java.util.List;

public interface CarnetService {

    List<CarnetDTO> readCarnets();

    List<CarnetDTO> getCarnetsById(Long idParent);

    CarnetDTO createCarnet(EnfantDTO enfantDTO, Long idParent);

    CarnetDTO updateCarnet(CarnetDTO CarnetDTODto);

    void deleteCarnet(Long CarnetDTOId);
}
