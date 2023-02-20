package com.advance.aurore_rh.model;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "APP_TYPESANCTION")
@Data
@RequiredArgsConstructor
public class TypeSanction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type_sanction;


    @OneToMany(mappedBy = "typeSanction")
    private List<Sanction> sanction;
}
