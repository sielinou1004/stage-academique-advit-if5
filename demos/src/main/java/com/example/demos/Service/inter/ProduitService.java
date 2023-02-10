package com.example.demos.Service.inter;

import com.example.demos.Model.Produit;
import com.example.demos.dto.requests.ProduitRequestDTO;

import java.util.List;

public interface ProduitService {

    Produit creer(Produit produit);

    List<Produit> lire();

    Produit modifier(long id, Produit produit) ;

    String supprimer(Long id);

    Produit addProduit(ProduitRequestDTO produitRequestDTO);
}
