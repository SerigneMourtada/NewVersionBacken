package com.example.gestionvaccinationtestfirst.dtoMapper.vaccinationMapper;

import com.example.gestionvaccinationtestfirst.DTos.VaccinationDTO;
import com.example.gestionvaccinationtestfirst.model.Vaccination;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface VaccinationMapper{

    Vaccination asVaccination(VaccinationDTO vaccinationDTO);

    VaccinationDTO asVaccinationDTO(Vaccination vaccination);

    List<VaccinationDTO> asVaccinationDTOs(List<Vaccination> vaccinations);

    List<Vaccination> asVaccinations(List<VaccinationDTO> vaccinationDTOS);

}
