package com.advance.aurore_rh.dto.response;

import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.model.Sanction;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Builder
public class SanctionResponseDTO {

    public Long id;

    public String type_sanction;

    public Date debut_sanction;

    public Date fin_sanction;
    private EmployerResponseDTO employerResponseDTO;

    public  static SanctionResponseDTO buildFromEntity(Sanction entity){
        return SanctionResponseDTO.builder()
                .fin_sanction(entity.getFin_sanction())
                .debut_sanction(entity.getDebut_sanction())
                .type_sanction(entity.getType_sanction())
                .employerResponseDTO(EmployerResponseDTO.buildFromEntity((Employer) entity.getEmployer()))
                .build();



    }


    public static  List<SanctionResponseDTO> buildFromEntity(List<Sanction> sanctionList){
        return sanctionList.stream().map(SanctionResponseDTO::buildFromEntity).collect(Collectors.toList());
    }


//    public static <T> SanctionResponseDTO buildFromEntity(Optional<Sanction> byId) {
//        return SanctionResponseDTO.builder()
//                .fin_sanction(byId.get().getFin_sanction())
//                .debut_sanction(byId.get().getDebut_sanction())
//                .type_sanction(byId.get().getType_sanction())
//                .build();
//    }
}
