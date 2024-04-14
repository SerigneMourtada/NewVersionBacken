package com.example.gestionvaccinationtestfirst.dtoMapper.vaccinationMapper;

import com.example.gestionvaccinationtestfirst.DTos.VaccinationDTO;
import com.example.gestionvaccinationtestfirst.dtoMapper.vaccinMapper.VaccinMapper;
import com.example.gestionvaccinationtestfirst.model.Vaccination;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VaccinationMapper {

    private VaccinMapper vaccinMapper;


    //private EnfantMapper enfantMapper;

    public Vaccination fromVaccinationDTO(VaccinationDTO vaccinationDTO){
        Vaccination vaccination=new Vaccination();
        BeanUtils.copyProperties(vaccinationDTO,vaccination);
        return vaccination;
    }
    public VaccinationDTO fromVaccination(Vaccination vaccination){
        VaccinationDTO vaccinationDTO=new VaccinationDTO();
        BeanUtils.copyProperties(vaccination,vaccinationDTO);
        return vaccinationDTO;
    }
}
