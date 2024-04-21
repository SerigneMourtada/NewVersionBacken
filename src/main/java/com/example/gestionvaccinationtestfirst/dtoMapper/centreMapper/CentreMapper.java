package com.example.gestionvaccinationtestfirst.dtoMapper.centreMapper;
import com.example.gestionvaccinationtestfirst.DTos.CentreDTO;
import com.example.gestionvaccinationtestfirst.model.Centre;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper( componentModel = "spring")
public interface CentreMapper {
    Centre asCentre(CentreDTO centreDTO);
    List<Centre> asCentres(List<CentreDTO> centreDTOs);
    List<CentreDTO> asCentreDTOs(List<Centre> centre);
    CentreDTO asCentreDTO(Centre centre);
}
