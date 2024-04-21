package com.example.gestionvaccinationtestfirst.service.carnetService;

import com.example.gestionvaccinationtestfirst.DTos.CarnetDTO;
import com.example.gestionvaccinationtestfirst.DTos.EnfantDTO;
import com.example.gestionvaccinationtestfirst.DTos.UtilisateurDTO;
import com.example.gestionvaccinationtestfirst.dtoMapper.Utilisateur.UtilisateurMapper;
import com.example.gestionvaccinationtestfirst.dtoMapper.Utilisateur.UtilisateurMapperFirst;
import com.example.gestionvaccinationtestfirst.dtoMapper.carnetMapper.CarnetMapper;
import com.example.gestionvaccinationtestfirst.dtoMapper.carnetMapper.CarnetMapperFirst;
import com.example.gestionvaccinationtestfirst.dtoMapper.enfantMapper.EnfantMapper;
import com.example.gestionvaccinationtestfirst.dtoMapper.enfantMapper.EnfantMapperFirst;
import com.example.gestionvaccinationtestfirst.model.Carnet;
import com.example.gestionvaccinationtestfirst.model.Enfant;
import com.example.gestionvaccinationtestfirst.model.Utilisateur;
import com.example.gestionvaccinationtestfirst.model.Vaccin;
import com.example.gestionvaccinationtestfirst.repository.CarnetRepository;
import com.example.gestionvaccinationtestfirst.repository.EnfantRepository;
import com.example.gestionvaccinationtestfirst.repository.UtilisateurRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class CarnetServiceImpl implements CarnetService {
    private CarnetRepository carnetRepository;

    private CarnetMapper carnetMapper;

    private EnfantRepository enfantRepository;

    private UtilisateurRepository utilisateurRepository;

    private UtilisateurMapper utilisateurMapper;

    private EnfantMapper enfantMapper;

    private List<CarnetDTO> carnetDTOList=new ArrayList<>();

    private CarnetMapperFirst carnetMapperFirst;

    private EnfantMapperFirst enfantMapperFirst;

    private UtilisateurMapperFirst utilisateurMapperFirst;





    @Override
    public List<CarnetDTO> readCarnets(){

        List<Carnet> carnets=carnetRepository.findAll();


        List<CarnetDTO> carnetDTOList1=carnets.stream().map(
                carnet -> carnetMapper.asCarnetDTO(carnet)
        ).toList();

//        List<CarnetDTO> carnetDTOS=carnetMapper.asCarnetDTOs(carnets);

        return carnetDTOList1;
    }

    @Override
    public List<CarnetDTO> getCarnetsById(Long idParent){
       //Carnet carnet= carnetRepository.findCarnetById(idParent);/
        List<Carnet> carnets = carnetRepository.findCarnetByParent_Id(idParent);
        if(carnets ==null)
            throw new EntityNotFoundException(MessageFormat.format("Not found Parent with id {0}", idParent));

//        System.out.println(carnet);
//        CarnetDTO carnetDTO =carnetMapper.asCarnetDTO(carnet);
//        carnetDTO.setId(carnet.getId());
//        carnetDTO.setNom(carnet.getParent().getNom());
//        carnetDTO.setAddresse(carnet.getParent().getAddresse());
//        carnetDTO.setEmail(carnet.getParent().getEmail());
//        carnetDTO.setPrenom(carnet.getParent().getPrenom());
//        carnetDTO.setTelephone(carnet.getParent().getTelephone());
//        carnetDTO.setPassword(carnet.getParent().getPassword());
        //carnetDTO.getEnfantDTO().setDateDeNaissance(carnet.getEnfant().getDateDeNaissance());
        //carnetDTO.getEnfantDTO().setNom(carnet.getEnfant().getNom());
        //carnetDTO.getEnfantDTO().setPrenom(carnet.getEnfant().getPrenom());
        //carnetDTO.getEnfantDTO().setSexe(carnet.getEnfant().getSexe());
        //CarnetDTO carnetDTO=carnetMapper.asCarnetDTO(carnet);

        List<CarnetDTO> carnetDTOList1=carnets.stream()
                .map(carnet -> carnetMapperFirst.asCarnetDTO(carnet)).collect(Collectors.toList());



        return carnetDTOList1;
    }

    @Override
    public CarnetDTO createCarnet(EnfantDTO enfantDTO,Long idParent){

        Utilisateur user=utilisateurRepository.findById(idParent).orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Not found Paren t with id {0}", idParent)));
//        System.out.println(user);
        enfantDTO.setParentDTO(utilisateurMapperFirst.asUtilisateurDTO(user));

//        CarnetDTO carnetDTO=new CarnetDTO();
//        carnetDTO.setEnfantDTO(enfantDTO);
//        carnetDTO.setParentDTO(utilisateurMapper.asUtilisateurDTO(user));

        Enfant enfant=enfantMapperFirst.asEnfant(enfantDTO);
        enfant.setParent(user);
        Enfant enfant1=enfantRepository.save(enfant);

        Carnet carnet=new Carnet();
        carnet.setEnfant(enfant1);
        carnet.setParent(user);
        Carnet carnet1=carnetRepository.save(carnet);

//        CarnetDTO carnetDTO=new CarnetDTO();
//        carnetDTO.setParentDTO(utilisateurMapper.asUtilisateurDTO(user));
//        carnetDTO.setEnfantDTO(enfantMapper.asEnfantDTO(enfant1));

        return carnetMapperFirst.asCarnetDTO(carnet1);
    }

    @Override
    public CarnetDTO updateCarnet(CarnetDTO carnetDTO) {
        /**
        //Carnet carnet= carnetRepository.findById(carnetDTO.getId()).
                //orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Not found Carnet with id {0}", carnetDTO.getId())));
        return carnetMapper.asCarnetDTO(carnetRepository.save(carnet));
         **/

        return null;
    }

    @Override
    public void deleteCarnet(Long CarnetDTOId) {
        Carnet carnet= carnetRepository.findById(CarnetDTOId).
                orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Not found Carnet with id {0}", CarnetDTOId)));

        carnetRepository.delete(carnet);
    }
}
