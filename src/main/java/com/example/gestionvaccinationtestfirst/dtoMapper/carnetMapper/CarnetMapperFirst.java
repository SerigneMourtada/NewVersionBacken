package com.example.gestionvaccinationtestfirst.dtoMapper.carnetMapper;


import com.example.gestionvaccinationtestfirst.DTos.CarnetDTO;
import com.example.gestionvaccinationtestfirst.dtoMapper.Utilisateur.UtilisateurMapper;
import com.example.gestionvaccinationtestfirst.dtoMapper.enfantMapper.EnfantMapper;
import com.example.gestionvaccinationtestfirst.model.Carnet;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
@Data
public class CarnetMapperFirst {
    private EnfantMapper enfantMapper;
    private UtilisateurMapper utilisateurMapper;

    public CarnetDTO asCarnetDTO(Carnet carnet){
        CarnetDTO carnetDTO=new CarnetDTO();
        BeanUtils.copyProperties(carnet,carnetDTO);
        carnetDTO.setEnfantDTO(enfantMapper.asEnfantDTO(carnet.getEnfant()));
        carnetDTO.setParentDTO(utilisateurMapper.asUtilisateurDTO(carnet.getParent()));
        return carnetDTO;
    }


    public Carnet asCarnet(CarnetDTO carnetDTO){
        Carnet carnet=new Carnet();
        BeanUtils.copyProperties(carnetDTO,carnet);
        carnet.setEnfant(enfantMapper.asEnfant(carnetDTO.getEnfantDTO()));
        carnet.setParent(utilisateurMapper.asUtilisateur(carnetDTO.getParentDTO()));
        return carnet;
    }
}
