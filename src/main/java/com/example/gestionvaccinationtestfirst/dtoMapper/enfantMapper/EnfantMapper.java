package com.example.gestionvaccinationtestfirst.dtoMapper.enfantMapper;
import com.example.gestionvaccinationtestfirst.DTos.EnfantDTO;
import com.example.gestionvaccinationtestfirst.model.Enfant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface EnfantMapper {
    Enfant asEnfant(EnfantDTO enfantDTO);
    List<Enfant> asEnfants(List<EnfantDTO> enfantDTOS);
    List<EnfantDTO> asEnfantDTOs(List<Enfant> enfants);
    EnfantDTO asEnfantDTO(Enfant enfant);

}
