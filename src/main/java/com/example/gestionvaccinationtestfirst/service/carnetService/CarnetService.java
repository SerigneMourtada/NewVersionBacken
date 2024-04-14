package com.example.gestionvaccinationtestfirst.service.carnetService;

import com.example.gestionvaccinationtestfirst.DTos.CarnetDTO;
import com.example.gestionvaccinationtestfirst.Excepyion.EntityNotFoundException;

import java.util.List;

public interface CarnetService {

    List<CarnetDTO> readCarnets();

    CarnetDTO getCarnetById(Long CarnetDTOId);

    CarnetDTO createCarnet(CarnetDTO gestionCarnetDTODto);

    CarnetDTO updateCarnet(CarnetDTO CarnetDTODto);

    void deleteCarnet(Long CarnetDTOId);
}
