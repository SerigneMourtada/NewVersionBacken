package com.example.gestionvaccinationtestfirst.dtoMapper.carnetMapper;

import com.example.gestionvaccinationtestfirst.DTos.CarnetDTO;
import com.example.gestionvaccinationtestfirst.model.Carnet;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CarnetMapper {

    Carnet asCarnet(CarnetDTO CarnetDTO);
    List<Carnet> asCarnets(List<CarnetDTO> carnetDTOs);
    List<CarnetDTO> asCarnetDTOs(List<Carnet> carnet);
    CarnetDTO asCarnetDTO(Carnet carnet);


}
