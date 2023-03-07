package com.advance.aurore_rh.dto.request;


import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.model.Sanction;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Builder

public class SanctionRequetDTO {

    private Long id;

    private String nom;

    private String type_sanction;

    private Date debut_sanction;

    private Date fin_sanction;

    private String description;

    private Long id_Employer;

    public static Sanction buildFromDto(SanctionRequetDTO dto, Employer employer){
        return Sanction.SanctionBuilder.aSanction()
                .nom(dto.getNom())
                .fin_sanction(dto.getFin_sanction())
                .debut_sanction(dto.getDebut_sanction())
                .type_sanction(dto.getType_sanction())
                .employer((Employer) employer)
                .build();
    }
}
