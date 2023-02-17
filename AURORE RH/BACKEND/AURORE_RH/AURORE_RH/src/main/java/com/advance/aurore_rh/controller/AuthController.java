package com.advance.aurore_rh.controller;

import com.advance.aurore_rh.dto.request.AuthenticateRequestDTO;
import com.advance.aurore_rh.dto.request.SignInRequestDTO;
import com.advance.aurore_rh.dto.response.ApiResponse;
import com.advance.aurore_rh.dto.response.AuthenticateResponseDTO;
import com.advance.aurore_rh.dto.response.SingInResponseDTO;
import com.advance.aurore_rh.service.auth.ApplicationUserService;
import com.advance.aurore_rh.service.auth.AuthService;
import com.advance.aurore_rh.utils.GeneralUtil;
import com.advance.aurore_rh.utils.JwtUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")

public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ApplicationUserService userService;

    @Autowired
    private AuthService authService;
    @Autowired
    private JwtUtils jwtUtils;



    @PostMapping("/login")
    @ApiOperation("api de connexion")

    public ResponseEntity<ApiResponse> login(@RequestBody AuthenticateRequestDTO request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                )
        );
        final UserDetails userDetails = userService.loadUserByUsername(request.getLogin());

        final String jwt = jwtUtils.generateToken(userDetails.getUsername());

        AuthenticateResponseDTO data = AuthenticateResponseDTO.builder().token(jwt).build();

        return ResponseEntity.ok(ApiResponse.builder()
                .data(data)
                .message("login reuissi")
                .sucsess(true)
                .build());
    }


    @PostMapping("/signIn")
    public ResponseEntity<ApiResponse<SingInResponseDTO>> signIn(@RequestBody SignInRequestDTO user){

        if (authService.existByEmail(user.getEmail()))
            throw new RuntimeException("cette addresse mail existe deja ");


        return ResponseEntity.ok(
                ApiResponse.<SingInResponseDTO>builder()
                .message("Enregistrement reuissie")
                .sucsess(true)
                .data(authService.createUser(user))
                .build()
        );


//        return ResponseEntity.ok(ApiResponse.builder()
//                .data(user.getUsername())
//                .sucsess(true)
//                .message("Operation effectuer")
//                .build());
//        //return ResponseEntity.ok(new ApiResponse(true,"operation effectuer", user.getUsername()));
    }

}
