package com.advance.aurore_rh.model;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "APP_TYPECONGER")
@Data
@RequiredArgsConstructor
public class TypeConger extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String type_conger;


    @OneToMany(mappedBy = "typeConger")
    private List<Conger> conger;

}
