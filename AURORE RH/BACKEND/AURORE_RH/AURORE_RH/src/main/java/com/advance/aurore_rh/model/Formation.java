package com.advance.aurore_rh.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "APP_FORMATION")
@Data
@RequiredArgsConstructor

public class Formation extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String theme_form;

    private Date debut_form;

    private Date fin_form;

    private String description;

    @ManyToMany(mappedBy = "formations")
    private List<Employer> employers;
}
