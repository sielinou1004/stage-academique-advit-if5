package com.example.demos.controller;

import com.example.demos.Model.Produit;
import com.example.demos.Service.inter.ProduitService;
import com.example.demos.dto.requests.ProduitRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produit")
@CrossOrigin("*")
public class ProduitController {

    @Autowired
    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }


    @PostMapping("/create")
    public Produit  create(@RequestBody Produit produit) {
        return produitService.creer(produit);

    }
    @PostMapping("/cereate-v1")
    public Produit  create(@RequestBody ProduitRequestDTO produitRequestDTO) {
        return produitService.addProduit(produitRequestDTO);

    }

    @GetMapping("/read")
    public List<Produit> read(){
        return produitService.lire();
    }

    @PutMapping("/update/{id}")
    public Produit update(@PathVariable Long id, @RequestBody Produit produit){
        return produitService.modifier(id, produit);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return produitService.supprimer(id);
    }

}
