package com.advance.aurore_rh.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "APP_CONGER")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Conger extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(length = 50)
    private String nom;

    @Column(length = 50)
    private String prenom;

    private Date date_debut;

    private Date date_fin;

    @Column(length = 50)
    private String type_conger;

    private Date date_reprise;

    private Date etablissement_conger;

    @Column(length = 50)
    private String Description;

    @ManyToOne
    @JoinColumn(name = "typeconger_id")
    private TypeConger typeConger;

    @ManyToMany(mappedBy = "congers")
    private List<Employer> employers;


    public static final class CongerBuilder {
        private Long id;
        private String nom;
        private String prenom;
        private Date date_debut;
        private Date date_fin;
        private String type_conger;
        private Date date_reprise;
        private Date etablissement_conger;
        private String Description;
        private Long version;
        private LocalDateTime date_creation;
        private LocalDateTime date_modif;
        private String util_creation;
        private String util_modif;
        private Character forwarded;

        private CongerBuilder() {
        }

        public static CongerBuilder aConger() {
            return new CongerBuilder();
        }

        public CongerBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public CongerBuilder nom(String nom) {
            this.nom = nom;
            return this;
        }

        public CongerBuilder prenom(String prenom) {
            this.prenom = prenom;
            return this;
        }

        public CongerBuilder date_debut(Date date_debut) {
            this.date_debut = date_debut;
            return this;
        }

        public CongerBuilder date_fin(Date date_fin) {
            this.date_fin = date_fin;
            return this;
        }

        public CongerBuilder type_conger(String type_conger) {
            this.type_conger = type_conger;
            return this;
        }

        public CongerBuilder date_reprise(Date date_reprise) {
            this.date_reprise = date_reprise;
            return this;
        }

        public CongerBuilder etablissement_conger(Date etablissement_conger) {
            this.etablissement_conger = etablissement_conger;
            return this;
        }

        public CongerBuilder Description(String Description) {
            this.Description = Description;
            return this;
        }

        public CongerBuilder version(Long version) {
            this.version = version;
            return this;
        }

        public CongerBuilder date_creation(LocalDateTime date_creation) {
            this.date_creation = date_creation;
            return this;
        }

        public CongerBuilder date_modif(LocalDateTime date_modif) {
            this.date_modif = date_modif;
            return this;
        }

        public CongerBuilder util_creation(String util_creation) {
            this.util_creation = util_creation;
            return this;
        }

        public CongerBuilder util_modif(String util_modif) {
            this.util_modif = util_modif;
            return this;
        }

        public CongerBuilder forwarded(Character forwarded) {
            this.forwarded = forwarded;
            return this;
        }

        public Conger build() {
            Conger conger = new Conger();
            conger.setId(id);
            conger.setNom(nom);
            conger.setPrenom(prenom);
            conger.setDate_debut(date_debut);
            conger.setDate_fin(date_fin);
            conger.setType_conger(type_conger);
            conger.setDate_reprise(date_reprise);
            conger.setEtablissement_conger(etablissement_conger);
            conger.setDescription(Description);
            conger.setVersion(version);
            conger.setDate_creation(date_creation);
            conger.setDate_modif(date_modif);
            conger.setUtil_creation(util_creation);
            conger.setUtil_modif(util_modif);
            conger.setForwarded(forwarded);
            return conger;
        }
    }
}
