package com.example.gestionvaccinationtestfirst.dtoMapper.maladieMapper;
import com.example.gestionvaccinationtestfirst.DTos.MaladieDTO;
import com.example.gestionvaccinationtestfirst.model.Maladie;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Service;

import java.util.List;
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")

public interface MaladieMapper {
    Maladie asMaladie(MaladieDTO maladieDTO);
    List<Maladie> asMaladies(List<MaladieDTO> maladieDTOS);
    List<MaladieDTO> asMaladieDTOs(List<Maladie> maladies);
    MaladieDTO asMaladieDTO(Maladie maladie);
}
