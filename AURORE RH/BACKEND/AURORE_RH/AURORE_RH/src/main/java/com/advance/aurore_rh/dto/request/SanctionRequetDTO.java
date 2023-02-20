package com.advance.aurore_rh.dto.request;


import com.advance.aurore_rh.model.Sanction;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder

public class SanctionRequetDTO {

    public Long id;

    public String type_sanction;

    public Date debut_sanction;

    public Date fin_sanction;

    public static Sanction buildFromDto(SanctionRequetDTO dto){
        return Sanction.SanctionBuilder.aSanction()
                .fin_sanction(dto.getFin_sanction())
                .debut_sanction(dto.getDebut_sanction())
                .type_sanction(dto.getType_sanction())
                .date_creation(LocalDateTime.now())
                .build();
    }
}
