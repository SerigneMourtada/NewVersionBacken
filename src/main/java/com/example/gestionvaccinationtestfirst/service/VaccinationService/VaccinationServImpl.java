package com.example.gestionvaccinationtestfirst.service.VaccinationService;

import com.example.gestionvaccinationtestfirst.DTos.*;
import com.example.gestionvaccinationtestfirst.Excepyion.*;
import com.example.gestionvaccinationtestfirst.dtoMapper.Utilisateur.UtilisateurMapper;
import com.example.gestionvaccinationtestfirst.dtoMapper.carnetMapper.CarnetMapper;
import com.example.gestionvaccinationtestfirst.dtoMapper.enfantMapper.EnfantMapper;
import com.example.gestionvaccinationtestfirst.dtoMapper.vaccinationMapper.VaccinationMapper;
import com.example.gestionvaccinationtestfirst.model.*;
import com.example.gestionvaccinationtestfirst.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VaccinationServImpl implements VaccinationServ {
    private UtilisateurMapper utilisateurMapper;

    private CarnetMapper carnetMapper;

    private VaccinationRepository vaccinationRepository;


    private VaccinationMapper vaccinationMapper;

    private UtilisateurRepository utilisateurRepository;;

    private CarnetRepository carnetRepository;


    private EnfantRepository enfantRepository;


    private VaccinRepository vaccinRepository;


    private EnfantMapper enfantMapper;







    @Override
    public List<VaccinationDTO> getAllVaccination(){
        List<Vaccination> vaccinationList=vaccinationRepository.findAll();
        List<VaccinationDTO> vaccinationDTOList=vaccinationList.stream().
                map(vaccination -> vaccinationMapper.fromVaccination(vaccination)).toList();
        return vaccinationDTOList;
    }

    @Override
    public VaccinationDTO getVaccinationById(Long vaccinationId) throws VaccinationNotFound {
        Vaccination vaccination=vaccinationRepository.findById(vaccinationId)
                .orElseThrow(()->new VaccinationNotFound("Vaccination Id does not found"));
        return vaccinationMapper.fromVaccination(vaccination);
    }

    @Override
    public void deleteVaccination(Long vaccinationId){
            vaccinationRepository.deleteById(vaccinationId);

    }

    /**@Override
    public VaccinationDTO saveVaccinatio(VaccinationDTO vaccinationDTO, Long enfantId, Long vaccinId,Long carnetId,Long userId) throws EnfantNotFoundException, VaccinNotFoundException, UtilisateurNotFoundException, EntityNotFoundException {
            Enfant enfant=enfantRepository.findById(enfantId)
                    .orElseThrow(()->new EnfantNotFoundException("Enfant Does not Found"));
            Vaccin vaccin=vaccinRepository.findById(vaccinId)
                    .orElseThrow(()->new VaccinNotFoundException("Vaccin does not found"));

            Utilisateur user=utilisateurRepository.findById(userId)
                    .orElseThrow(()->new UtilisateurNotFoundException("User Does not Found"));

            Carnet carnet=carnetRepository.findById(carnetId)
                    .orElseThrow(()->new EntityNotFoundException("Carnet does not found"));

            EnfantDTO enfantDTO=enfantMapper.fromEnfant(enfant);
            VaccinDTO vaccinDTO=vaccinMapper.fromVaccin(vaccin);
            UtilisateurDTO utilisateurDTO=utilisateurMapper.fromUtilisateur(user);
            CarnetDTO carnetDTO=carnetMapper.asCarnetDTO(carnet);

            vaccinationDTO.setEnfantDTO(enfantDTO);
            vaccinationDTO.setVaccinDTO(vaccinDTO);
            vaccinationDTO.setCarnetVaccinationDTO(carnetDTO);
            vaccinationDTO.setUtilisateurDTO(utilisateurDTO);
            vaccinationDTO.setEstEffectuer(false);
            Vaccination vaccination=vaccinationMapper.fromVaccinationDTO(vaccinationDTO);

            Vaccination vaccination1=vaccinationRepository.save(vaccination);

        return vaccinationMapper.fromVaccination(vaccination1);
    }**/

    @Override
    public VaccinationDTO updateVaccination(VaccinationDTO vaccinationDTO) {
        return null;
    }
    /**@Override
    public List<HistoriqueDeVaccinationDTO> getHistoriqueVaccinationById(Long enfantId){
        List<Object[]> results=vaccinationRepository.findVaccinationsByEnfantId(enfantId);
        List<HistoriqueDeVaccinationDTO> dtos=new ArrayList<>();
        for(Object[] result:results){
            HistoriqueDeVaccinationDTO dto=new HistoriqueDeVaccinationDTO();
            dto.setNomEnfant((String) result[0]);
            dto.setPrenomEnfant((String) result[1]);
            dto.setNomVaccin((String) result[2]);
            dto.setDateVaccination((Date) result[3]);
            dto.setNumeroLot((Long) result[4]);
            dto.setEffetSecondaire((String) result[5]);
            dtos.add(dto);
        }
        return dtos;

    }**/



    /**@Override
    public List<VaccinationDTO> getHistory(Long enfantId) {

        List<Vaccination> vaccinationList=vaccinationRepository.findVaccinationsById(enfantId);

        List<VaccinationDTO> vaccinationDTOList=vaccinationList.stream()
                .map(vaccination->vaccinationMapper.fromVaccination(vaccination))
                .collect(Collectors.toList());
        return vaccinationDTOList;
    }
**/
    @Override
    public void ValiderVaccination(Long vaccinationId) throws VaccinationNotFound {
        Vaccination vaccination=vaccinationRepository.findById(vaccinationId)

                .orElseThrow(()->new VaccinationNotFound("Vaccination Not Exist"));

                //vaccination.setDateVaccinationActuellle(LocalDate.now());

    }






}
