package com.example.demos.dto.requests;

import com.example.demos.Model.Client;
import lombok.Data;


@Data
public class ProduitRequestDTO {
    private String nomProduit;
    private String description;
    private Integer prix;

}
