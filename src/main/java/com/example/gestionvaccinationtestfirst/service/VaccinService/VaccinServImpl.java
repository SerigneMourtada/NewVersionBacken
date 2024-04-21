package com.example.gestionvaccinationtestfirst.service.VaccinService;

import com.example.gestionvaccinationtestfirst.DTos.VaccinDTO;
import com.example.gestionvaccinationtestfirst.Excepyion.VaccinNotFoundException;
import com.example.gestionvaccinationtestfirst.dtoMapper.vaccinMapper.VaccinMapper;
import com.example.gestionvaccinationtestfirst.dtoMapper.vaccinMapper.VaccinMapperTest;
import com.example.gestionvaccinationtestfirst.model.Vaccin;
import com.example.gestionvaccinationtestfirst.repository.VaccinRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VaccinServImpl implements VaccinServ{
    private VaccinRepository vaccinRepository;

    //private VaccinMapper vaccinMapper;

    private VaccinMapperTest vaccinMapperTest;

    @Override
    public List<VaccinDTO> readVaccins(){
        List<Vaccin> vaccins = vaccinRepository.findAll();
        List<VaccinDTO> vaccinDTOList=vaccins.stream().map(vaccin -> vaccinMapperTest.asVaccinDTO(vaccin))
                .collect(Collectors.toList());
        return vaccinDTOList;
    }

    @Override
    public VaccinDTO getVaccinById(Long vaccinId){
       Vaccin vaccin=vaccinRepository.findById(vaccinId)
                .orElseThrow((() -> new EntityNotFoundException(MessageFormat.format("Not found Vaccin with id {0}", vaccinId))));
       return vaccinMapperTest.asVaccinDTO(vaccin);
    }

    @Override
    public VaccinDTO createVaccin(VaccinDTO vaccinDTO){
        Vaccin vaccin=vaccinMapperTest.asVaccin(vaccinDTO);
        System.out.println("=========>"+vaccinDTO);
        Vaccin vaccin1=vaccinRepository.save(vaccin);
        return vaccinMapperTest.asVaccinDTO(vaccin1);
    }

    @Override
    public VaccinDTO updateVaccin(VaccinDTO vaccinDTO){
        Vaccin vaccin=vaccinRepository.findById(vaccinDTO.getId())
                .orElseThrow((() -> new EntityNotFoundException(MessageFormat.format("Not found Vaccin with id {0}",vaccinDTO.getId()))));
       Vaccin vaccin1=vaccinRepository.save(vaccin);
        return vaccinMapperTest.asVaccinDTO(vaccin1);
    }

    @Override
    public void deleteVaccin(Long vaccinId){
        Vaccin vaccin=vaccinRepository.findById(vaccinId)
                .orElseThrow((() -> new EntityNotFoundException(MessageFormat.format("Not found Vaccin with id {0}", vaccinId))));
        vaccinRepository.delete(vaccin);

    }
}
