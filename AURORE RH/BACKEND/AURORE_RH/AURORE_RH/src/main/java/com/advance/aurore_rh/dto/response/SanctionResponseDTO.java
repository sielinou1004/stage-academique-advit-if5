package com.advance.aurore_rh.dto.response;

import com.advance.aurore_rh.model.Sanction;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class SanctionResponseDTO {

    public Long id;

    public String type_sanction;

    public Date debut_sanction;

    public Date fin_sanction;

    public  static SanctionResponseDTO buildFromEntity(Sanction entity){
        return SanctionResponseDTO.builder()
                .fin_sanction(entity.getFin_sanction())
                .debut_sanction(entity.getDebut_sanction())
                .type_sanction(entity.getType_sanction())
                .build();

    }


//    public static List<EmployerResponseDTO> builFromEntityList(List <Employer> employerList){
//
//        return employerList.stream().map(EmployerResponseDTO::buildFromEntity).collect(Collectors.toList());
//
//    }


}
