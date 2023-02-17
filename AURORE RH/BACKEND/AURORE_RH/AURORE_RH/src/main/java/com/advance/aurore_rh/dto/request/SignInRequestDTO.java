package com.advance.aurore_rh.dto.request;


import com.advance.aurore_rh.model.User;
import com.advance.aurore_rh.utils.GeneralUtils;
import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class SignInRequestDTO {


    private String nom;
    private String password;
    private String email;

    public static User buildFromDto(SignInRequestDTO dto){
        return User.UserBuilder.anUser()

                .nom(dto.getNom())
                .email(dto.getEmail())
                .password(GeneralUtils.genererPasswordUser(dto.getPassword()))
                .build();
    }
}
