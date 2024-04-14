package com.example.gestionvaccinationtestfirst.dtoMapper.vaccinMapper;

import com.example.gestionvaccinationtestfirst.DTos.VaccinDTO;
import com.example.gestionvaccinationtestfirst.model.Vaccin;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface VaccinMapper {
    Vaccin asVaccin(VaccinDTO vaccinDTO);

    VaccinDTO asVaccinDTO(Vaccin vaccin);

    List<Vaccin> asVaccins(List<VaccinDTO> vaccinDTOS);

    List<VaccinDTO> asVaccinDTOs(List<Vaccin> vaccins);
}
