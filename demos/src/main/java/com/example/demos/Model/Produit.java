package com.example.demos.Model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table( name =  "Produit")
@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50,name = "nom",unique = true)
    private String nomProduit;
    @Column(length = 150)
    private String description;

    private Integer prix;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

}
