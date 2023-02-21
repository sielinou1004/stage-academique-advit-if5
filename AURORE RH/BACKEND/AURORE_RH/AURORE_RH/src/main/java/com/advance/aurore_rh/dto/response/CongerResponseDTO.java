package com.advance.aurore_rh.dto.response;


import com.advance.aurore_rh.model.Conger;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder

public class CongerResponseDTO {
    private Long id ;

    private String nom;

    private String prenom;

    private Date date_debut;

    private Date date_fin;

    private String type_conger;

    private Date date_reprise;

    private Date etablissement_conger;

        public static CongerResponseDTO buildFromEntity(Conger entity){
            return  CongerResponseDTO.builder()
                    .id(entity.getId())
                    .prenom(entity.getPrenom())
                    .nom(entity.getNom())
                    .etablissement_conger(entity.getEtablissement_conger())
                    .build();
        }

}
