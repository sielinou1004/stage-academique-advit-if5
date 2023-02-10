package com.example.demos.repository;

import com.example.demos.Model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitRepository extends JpaRepository <Produit, Long> {

    List<Produit> findByDescriptionLike(String description);
    Produit findByNomProduit(String nonProduit);
    boolean existsByNomProduit(String nonProduit);
}
