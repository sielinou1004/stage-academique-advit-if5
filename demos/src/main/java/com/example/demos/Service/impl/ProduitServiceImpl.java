package com.example.demos.Service.impl;

import com.example.demos.Model.Produit;
import com.example.demos.Service.inter.ProduitService;
import com.example.demos.dto.requests.ProduitRequestDTO;
import com.example.demos.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService {

   @Autowired
   ProduitRepository produitRepository;


    @Override
    public Produit creer(Produit produit) {

        return produitRepository.save(produit) ;

    }

    @Override
    public List<Produit> lire() {
        return produitRepository.findAll();
//        return produitRepository.findByDescriptionLike("zz");
    }

   @Override
    public Produit modifier(long id, Produit produit)  {
      /* try{
        produitRepository.existsByNomProduit(produit.getNomProduit());

       }catch (Exception ex){
           throw new Exception("messqge",ex.getCause());
       }*/

        return produitRepository.findById(id)
               .map(produit1 -> {
                   produit1.setPrix(produit.getPrix());
                   produit1.setNomProduit(produit.getNomProduit());
                   produit1.setDescription(produit.getDescription());
                   return produitRepository.save(produit1);
               }).orElseThrow(() -> new RuntimeException("produit non trouvé"))
                ;

    }

    @Override
    public String supprimer(Long id) {
         produitRepository.deleteById(id);
        return "produit supprimé";
    }

    @Override
    public Produit addProduit(ProduitRequestDTO produitRequestDTO) {

        Produit produitToSave = Produit.builder()
                .description(produitRequestDTO.getDescription())
                .prix(produitRequestDTO.getPrix())
                .nomProduit(produitRequestDTO.getNomProduit())
                .build();
        return produitRepository.save(produitToSave);
    }
}
