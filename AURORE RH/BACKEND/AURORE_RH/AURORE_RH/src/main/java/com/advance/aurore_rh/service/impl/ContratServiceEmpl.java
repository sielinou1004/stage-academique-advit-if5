package com.advance.aurore_rh.service.impl;

import com.advance.aurore_rh.dto.request.ContratRequestDTO;
import com.advance.aurore_rh.dto.response.ContratResponseDTO;
import com.advance.aurore_rh.dto.response.EmployerResponseDTO;
import com.advance.aurore_rh.model.Contrat;
import com.advance.aurore_rh.repository.ContratRepository;
import com.advance.aurore_rh.service.inter.ContratServiceInter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor

public class ContratServiceEmpl implements ContratServiceInter {

    @Autowired
    ContratRepository contratRepository;


    @Override
    public ContratResponseDTO createcontrat(ContratRequestDTO contratRequestDTO) {

        Contrat c = ContratRequestDTO.buildFromDto(contratRequestDTO);
        return ContratResponseDTO.buildFromEntity(contratRepository.save(c));
    }

    @Override
    public List<ContratResponseDTO> getAllcontr() {
        return ContratResponseDTO.buildFromEntity(contratRepository.findAll());
    }

    @Override
    public ContratResponseDTO getcontrById(Long id) {

        return ContratResponseDTO.buildFromEntity(contratRepository.findById(id)
        .orElseThrow(()->new RuntimeException("Aucun contrat trouvé")));

    }

    @Override
    public ContratResponseDTO updateContr(ContratRequestDTO contratRequestDTO) {
        Contrat contartToSave = contratRepository.findById(contratRequestDTO.getId())
                .map( c -> {

                    c.setNom(contratRequestDTO.getNom());
                    c.setPrenom(contratRequestDTO.getPrenom());
                    c.setPoste(contratRequestDTO.getPoste());
                    c.setType_contrat(contratRequestDTO.getType_contrat());
                    c.setEtat_civil(contratRequestDTO.getEtat_civil());
                    c.setLieu_recrutememnt(contratRequestDTO.getLieu_recrutememnt());
                    c.setDebut_periode_essaie(contratRequestDTO.getDebut_periode_essaie());
                    c.setSalaire_brut(contratRequestDTO.getSalaire_brut());
                    c.setFin_periode_essaie(contratRequestDTO.getDate_embauche());
                    c.setLieu_travail(contratRequestDTO.getLieu_travail());
                    c.setDate_embauche(contratRequestDTO.getDate_embauche());
                    c.setPeriode_essaie(contratRequestDTO.getPeriode_essaie());

                    return  contratRepository.save(c);

                        }

                ).orElseThrow(()->new RuntimeException("Aucun contrat trouvé"));
        return null;
    }

    @Override
    public String deleteContrById(Long id) {
        contratRepository.deleteById(id);
        return null;
    }
}
