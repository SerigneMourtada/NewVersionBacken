package com.example.gestionvaccinationtestfirst.dtoMapper.vaccinMapper;

import com.example.gestionvaccinationtestfirst.DTos.VaccinDTO;
import com.example.gestionvaccinationtestfirst.model.Vaccin;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@Service
public class VaccinMapperTest {

    public Vaccin asVaccin(VaccinDTO vaccinDTO){
        Vaccin vaccin=new Vaccin();
        BeanUtils.copyProperties(vaccinDTO,vaccin);
        return vaccin;
    }

    public VaccinDTO asVaccinDTO(Vaccin vaccin){
        VaccinDTO vaccinDTO=new VaccinDTO();
        BeanUtils.copyProperties(vaccin,vaccinDTO);
        return  vaccinDTO;
    }
}
