package com.example.gestionvaccinationtestfirst.service.VaccinationService;

import com.example.gestionvaccinationtestfirst.DTos.VaccinationDTO;
import com.example.gestionvaccinationtestfirst.dtoMapper.vaccinationMapper.VaccinationMapper;
import com.example.gestionvaccinationtestfirst.model.Vaccination;
import com.example.gestionvaccinationtestfirst.repository.VaccinationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
@Service
@AllArgsConstructor
public class VaccinationServiceImpl implements VaccinationService{
    private VaccinationMapper vaccinationMapper;

    private VaccinationRepository vaccinationRepository;
    @Override
    public List<VaccinationDTO> readVaccinations(){

        List<Vaccination> vaccinationList=vaccinationRepository.findAll();

        List<VaccinationDTO> vaccinationDTOS=vaccinationMapper.asVaccinationDTOs(vaccinationList);

        return vaccinationDTOS;
    }

    @Override
    public VaccinationDTO getVaccinationById(Long vaccinationId){
        Vaccination vaccination=vaccinationRepository.findById(vaccinationId)
                .orElseThrow((() -> new EntityNotFoundException(MessageFormat.format("Not found Vaccination with id {0}", vaccinationId))));
        return vaccinationMapper.asVaccinationDTO(vaccination);
    }

    @Override
    public VaccinationDTO createVaccination(VaccinationDTO vaccinationDTO){

        Vaccination vaccination=vaccinationMapper.asVaccination(vaccinationDTO);

        Vaccination vaccination1=vaccinationRepository.save(vaccination);
        return vaccinationMapper.asVaccinationDTO(vaccination1);
    }

    @Override
    public VaccinationDTO updateVaccination(VaccinationDTO vaccinationDTO){
        Vaccination vaccination=vaccinationRepository.findById(vaccinationDTO.getId())
                .orElseThrow((() -> new EntityNotFoundException(MessageFormat.format("Not found Vaccination with id {0}",vaccinationDTO.getId()))));

        vaccinationRepository.save(vaccination);

        return vaccinationMapper.asVaccinationDTO(vaccination);
    }

    @Override
    public void deleteVaccination(Long vaccinationId){
        Vaccination vaccination=vaccinationRepository.findById(vaccinationId)
                .orElseThrow((() -> new EntityNotFoundException(MessageFormat.format("Not found Vaccination with id {0}", vaccinationId))));
        vaccinationRepository.delete(vaccination);
    }
}
