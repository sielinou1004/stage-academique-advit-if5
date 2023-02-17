package com.advance.aurore_rh.controller;


import com.advance.aurore_rh.dto.request.EmployerRequestDTO;
import com.advance.aurore_rh.dto.response.ApiResponse;
import com.advance.aurore_rh.dto.response.EmployerResponseDTO;
import com.advance.aurore_rh.service.inter.EmployerServiceinter;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employer")
@CrossOrigin("*")

public class EmployerController {

    @Autowired
    private final EmployerServiceinter employerServiceinter;


    public EmployerController(EmployerServiceinter employerServiceinter) {
        this.employerServiceinter = employerServiceinter;

    }


    @DeleteMapping("/delete/{id}")
    @ApiOperation("Suppression d'un employer")

    public ResponseEntity<ApiResponse<String>> deleteById(@PathVariable Long id){
        return ResponseEntity.ok(ApiResponse.<String>builder()
                .sucsess(true)
                .message("operation effectuer")
                .data(employerServiceinter.deleteById(id))
                .build());
//    public String delete(@PathVariable Long id) {
//        return employerServiceinter.delete(id);
    }

    @PutMapping("/update/{id}/")
    @ApiOperation(("Api suppression d'un employer"))

    public ResponseEntity<ApiResponse<EmployerResponseDTO>>  updateEmpl(@RequestBody EmployerRequestDTO employerRequestDTO){
        return ResponseEntity.ok(ApiResponse.<EmployerResponseDTO>builder()
                .sucsess(true)
                .message("operation effectuer")
                .data(employerServiceinter.updateEmpl(employerRequestDTO))
        .build());
//    public EmployerResponseDTO update(@RequestBody EmployerRequestDTO employerRequestDTO) {
//        return employerServiceinter.updateEmpl(employerRequestDTO);
    }

    @PostMapping("/create")
    @ApiOperation("creation d'un nouvel employer")

    public ResponseEntity<ApiResponse<EmployerResponseDTO>> createEmpl(@RequestBody EmployerRequestDTO employerRequestDTO){
        return ResponseEntity.ok(ApiResponse.<EmployerResponseDTO>builder()
                .message("operation effectuer")
                .sucsess(true)
                .data(employerServiceinter.createEmpl(employerRequestDTO))
                .build());
//    public EmployerResponseDTO createEmpl(@RequestBody EmployerRequestDTO employerRequestDTO){
//        return employerServiceinter.createEmpl(employerRequestDTO);
    }

    @GetMapping("/read")
    @ApiOperation("Api qui permet le listing de tout les employers")

    public ResponseEntity<ApiResponse <List<EmployerResponseDTO>>> getAllEmpl(){
        return ResponseEntity.ok(ApiResponse.<List<EmployerResponseDTO>>builder()
                .sucsess(true)
                .message("operation effectuer")
               .data(employerServiceinter.getAllEmpl())
        .build());

//    public List <EmployerResponseDTO> getAllEmpl(){
//        return employerServiceinter.getAllEmpl();
    }

    @GetMapping("/read/{id}")
    @ApiOperation("api de listing d'un employer par l'id ")
    public ResponseEntity<ApiResponse<EmployerResponseDTO>> getEmplById(@PathVariable Long id){
        return ResponseEntity.ok(ApiResponse.<EmployerResponseDTO>builder()
                .data(employerServiceinter.getEmplById(id))
                .message("operation effectuer")
                .sucsess(true)
                .build());

//    public EmployerResponseDTO getEmplById(@PathVariable Long id ){
//        return employerServiceinter.getEmplById(id);
    }
}
