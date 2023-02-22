package com.advance.aurore_rh.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.LifecycleState;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "APP_SANCTION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sanction extends AuditEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String nom;

    @Column(length = 50)
    private String type_sanction;

    private Date debut_sanction;

    private Date fin_sanction;


    @ManyToOne
    @JoinColumn(name = "typesaction_id")
    private TypeSanction typeSanction;

    @ManyToMany(mappedBy = "sanctions")
    private List<Employer> employer;

    public static final class SanctionBuilder {
        private Long id;
        private String nom;
        private String type_sanction;
        private Date debut_sanction;
        private Date fin_sanction;
        private TypeSanction typeSanction;
        private List<Employer> employer;
        private Long version;
        private LocalDateTime date_creation;
        private LocalDateTime date_modif;
        private String util_creation;
        private String util_modif;
        private Character forwarded;

        private SanctionBuilder() {
        }

        public static SanctionBuilder aSanction() {
            return new SanctionBuilder();
        }

        public SanctionBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public SanctionBuilder nom(String nom) {
            this.nom = nom;
            return this;
        }

        public SanctionBuilder type_sanction(String type_sanction) {
            this.type_sanction = type_sanction;
            return this;
        }

        public SanctionBuilder debut_sanction(Date debut_sanction) {
            this.debut_sanction = debut_sanction;
            return this;
        }

        public SanctionBuilder fin_sanction(Date fin_sanction) {
            this.fin_sanction = fin_sanction;
            return this;
        }

        public SanctionBuilder typeSanction(TypeSanction typeSanction) {
            this.typeSanction = typeSanction;
            return this;
        }

        public SanctionBuilder employer(List<Employer> employer) {
            this.employer = employer;
            return this;
        }

        public SanctionBuilder version(Long version) {
            this.version = version;
            return this;
        }

        public SanctionBuilder date_creation(LocalDateTime date_creation) {
            this.date_creation = date_creation;
            return this;
        }

        public SanctionBuilder date_modif(LocalDateTime date_modif) {
            this.date_modif = date_modif;
            return this;
        }

        public SanctionBuilder util_creation(String util_creation) {
            this.util_creation = util_creation;
            return this;
        }

        public SanctionBuilder util_modif(String util_modif) {
            this.util_modif = util_modif;
            return this;
        }

        public SanctionBuilder forwarded(Character forwarded) {
            this.forwarded = forwarded;
            return this;
        }

        public Sanction build() {
            Sanction sanction = new Sanction();
            sanction.setId(id);
            sanction.setNom(nom);
            sanction.setType_sanction(type_sanction);
            sanction.setDebut_sanction(debut_sanction);
            sanction.setFin_sanction(fin_sanction);
            sanction.setTypeSanction(typeSanction);
            sanction.setEmployer(employer);
            sanction.setVersion(version);
            sanction.setDate_creation(date_creation);
            sanction.setDate_modif(date_modif);
            sanction.setUtil_creation(util_creation);
            sanction.setUtil_modif(util_modif);
            sanction.setForwarded(forwarded);
            return sanction;
        }
    }
}
