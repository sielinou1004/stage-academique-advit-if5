package com.advance.aurore_rh.controller;


import com.advance.aurore_rh.dto.request.ContratRequestDTO;
import com.advance.aurore_rh.dto.request.EmployerRequestDTO;
import com.advance.aurore_rh.dto.response.ApiResponse;
import com.advance.aurore_rh.dto.response.ContratResponseDTO;
import com.advance.aurore_rh.service.inter.ContratServiceInter;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contrat")
@CrossOrigin("*")
public class ContratController {

    @Autowired
    private final ContratServiceInter contratServiceInter;


    public ContratController(ContratServiceInter contratServiceInter) {
        this.contratServiceInter = contratServiceInter;
    }


    @DeleteMapping("/delete/{id}")
    @ApiOperation("suppression d'un contrat")

    public ResponseEntity<ApiResponse<String>> deletecontrById(@PathVariable Long id){
        return ResponseEntity.ok(ApiResponse.<String>builder()
                .sucsess(true)
                .message("suppression du contrat reuissi")
                .data(contratServiceInter.deleteContrById(id))
                .build());
    }


    @PutMapping("/update/{id}/")
    @ApiOperation("modification d'un contrat")

    public ResponseEntity<ApiResponse<ContratResponseDTO>> updateContr(@RequestBody ContratRequestDTO contratRequestDTO){
        return ResponseEntity.ok(ApiResponse.<ContratResponseDTO>builder()
                .sucsess(true)
                .data(contratServiceInter.updateContr(contratRequestDTO))
                .message("modification effectuer")
        .build());
    }


    @PostMapping("/create/")
    @ApiOperation("creation d'un contrat ")

    public ResponseEntity<ApiResponse<ContratResponseDTO>> createcontrat(@RequestBody ContratRequestDTO contratRequestDTO){
        return ResponseEntity.ok(ApiResponse.<ContratResponseDTO>builder()
                .sucsess(true)
                .message("creation contrat d'un employer")
                .data(contratServiceInter.createcontrat(contratRequestDTO))
                .build());
    }

    



}
