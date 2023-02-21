package com.advance.aurore_rh.dto.request;

import com.advance.aurore_rh.model.Conger;
import lombok.Builder;
import lombok.Data;


import java.util.Date;

@Data
@Builder

public class CongerRequestDTO {
    private Long id ;

    private String nom;

    private String prenom;

    private Date date_debut;

    private Date date_fin;

    private String type_conger;

    private Date date_reprise;

    private Date etablissement_conger;

    public static Conger buildFromDto(CongerRequestDTO dto){
        return Conger.CongerBuilder.aConger()
                .prenom(dto.getPrenom())
                .nom(dto.getNom())
                .etablissement_conger(dto.getEtablissement_conger())

                .build();
    }
}
