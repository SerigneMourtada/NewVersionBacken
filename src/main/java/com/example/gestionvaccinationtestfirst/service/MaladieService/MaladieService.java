package com.example.gestionvaccinationtestfirst.service.MaladieService;

import com.example.gestionvaccinationtestfirst.DTos.MaladieDTO;

import java.util.List;

public interface MaladieService {

    List<MaladieDTO> readMaladies();

    MaladieDTO getMaladieById(Long maladieId);

    MaladieDTO createMaladie(MaladieDTO maladieDTO);

    MaladieDTO updateMaladie(MaladieDTO maladieDTO);

    void deleteMaladie(Long maladieId);


}
