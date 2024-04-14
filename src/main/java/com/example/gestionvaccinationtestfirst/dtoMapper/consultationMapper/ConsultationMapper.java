package com.example.gestionvaccinationtestfirst.dtoMapper.consultationMapper;

import com.example.gestionvaccinationtestfirst.DTos.ConsultationDTO;
import com.example.gestionvaccinationtestfirst.model.Consultation;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")

public interface ConsultationMapper {
    ConsultationDTO asConsultationDTO(Consultation consultation);

    Consultation asConsultation(ConsultationDTO consultationDTO);

    List<ConsultationDTO> asConsultationDTOs(List<Consultation> consultations);

    List<Consultation> asConsultations(List<ConsultationDTO> consultationDTOS);
}
