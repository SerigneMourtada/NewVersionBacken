package com.example.gestionvaccinationtestfirst.service.ConsultationService;

import com.example.gestionvaccinationtestfirst.DTos.ConsultationDTO;

import java.util.List;

public interface ConsultationService {

    List<ConsultationDTO> readConsultations();

    ConsultationDTO getConsultationById(Long consultationId);

    ConsultationDTO createConsultation(ConsultationDTO consultationDTO);

    ConsultationDTO updateConsultation(ConsultationDTO consultationDTO);

    void deleteCarnet(Long consultationId);
}
