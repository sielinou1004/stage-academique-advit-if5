package com.advance.aurore_rh.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "APP_TYPECONTRAT")
@Data
@RequiredArgsConstructor

public class TypeContrat extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type_contrat;

    @OneToMany(mappedBy = "typeContrat")
    private List<Contrat> contrat;
}
