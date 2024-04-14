package com.example.gestionvaccinationtestfirst.service.ConsultationService;

import com.example.gestionvaccinationtestfirst.DTos.ConsultationDTO;
import com.example.gestionvaccinationtestfirst.dtoMapper.consultationMapper.ConsultationMapper;
import com.example.gestionvaccinationtestfirst.dtoMapper.enfantMapper.EnfantMapper;
import com.example.gestionvaccinationtestfirst.model.Consultation;
import com.example.gestionvaccinationtestfirst.repository.ConsulationRepository;
import com.example.gestionvaccinationtestfirst.repository.EnfantRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@AllArgsConstructor
public class ConsultationServiceImpl implements ConsultationService {
    private ConsulationRepository consulationRepository;

    private ConsultationMapper consultationMapper;

    private EnfantRepository enfantRepository;

    private EnfantMapper enfantMapper;


    @Override
    public List<ConsultationDTO> readConsultations(){
        List<Consultation> consultations=consulationRepository.findAll();
        return consultationMapper.asConsultationDTOs(consultations);
    }

    @Override
    public ConsultationDTO getConsultationById(Long consultationId) {
        Consultation consultation=consulationRepository.findById(consultationId)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Not found Consultation with id {0}", consultationId)));
        return consultationMapper.asConsultationDTO(consultation);
    }

    @Override
    public ConsultationDTO createConsultation(ConsultationDTO consultationDTO){
        Consultation consultation=consultationMapper.asConsultation(consultationDTO);
        Consultation consultation1=consulationRepository.save(consultation);
        return consultationMapper.asConsultationDTO(consultation1);
    }

    @Override
    public ConsultationDTO updateConsultation(ConsultationDTO consultationDTO){
       Consultation consultation= consulationRepository.findById(consultationDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Not found Consultation with id {0}", consultationDTO.getId())));
        return consultationMapper.asConsultationDTO(consulationRepository.save(consultation));
    }

    @Override
    public void deleteCarnet(Long consultationId){
        Consultation consultation=consulationRepository.findById(consultationId)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Not found Consultation with id {0}", consultationId)));
        consulationRepository.delete(consultation);
    }
}
