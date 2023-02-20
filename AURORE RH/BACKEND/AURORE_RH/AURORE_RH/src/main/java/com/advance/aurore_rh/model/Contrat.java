package com.advance.aurore_rh.model;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "APP_CONTRAT")
@Data
@RequiredArgsConstructor

public class Contrat extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_contrat;

    @Column(length = 50)
    private String nom;

    @Column(length = 50)
    private String prenom;

    @Column(length = 50)
    private String lieu_recrutememnt;

    private Date date_embauche;

    @Column(length = 50)
    private String periode_essaie;

    private Date debut_periode_essaie;

    private Date fin_periode_essaie;

    @Column(length = 50)
    private String type_contrat;

    @Column(length = 50)
    private String poste;

    @Column(length = 50)
    private String lieu_travail;

    @Column(length = 50)
    private String Salaire_brut;

    @Column(length = 50)
    private String etat_civil;

    @OneToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne
    @JoinColumn(name  = "typecontrat_id")
    private TypeContrat typeContrat;

    public static final class ContratBuilder {
        private long id_contrat;
        private String nom;
        private String prenom;
        private String lieu_recrutememnt;
        private Date date_embauche;
        private String periode_essaie;
        private Date debut_periode_essaie;
        private Date fin_periode_essaie;
        private String type_contrat;
        private String poste;
        private String lieu_travail;
        private String Salaire_brut;
        private String etat_civil;
        private Employer employer;
        private Long version;
        private LocalDateTime date_creation;
        private LocalDateTime date_modif;
        private String util_creation;
        private String util_modif;
        private Character forwarded;

        private ContratBuilder() {
        }

        public static ContratBuilder aContrat() {
            return new ContratBuilder();
        }

        public ContratBuilder id_contrat(long id_contrat) {
            this.id_contrat = id_contrat;
            return this;
        }

        public ContratBuilder nom(String nom) {
            this.nom = nom;
            return this;
        }

        public ContratBuilder prenom(String prenom) {
            this.prenom = prenom;
            return this;
        }

        public ContratBuilder lieu_recrutememnt(String lieu_recrutememnt) {
            this.lieu_recrutememnt = lieu_recrutememnt;
            return this;
        }

        public ContratBuilder date_embauche(Date date_embauche) {
            this.date_embauche = date_embauche;
            return this;
        }

        public ContratBuilder periode_essaie(String periode_essaie) {
            this.periode_essaie = periode_essaie;
            return this;
        }

        public ContratBuilder debut_periode_essaie(Date debut_periode_essaie) {
            this.debut_periode_essaie = debut_periode_essaie;
            return this;
        }

        public ContratBuilder fin_periode_essaie(Date fin_periode_essaie) {
            this.fin_periode_essaie = fin_periode_essaie;
            return this;
        }

        public ContratBuilder type_contrat(String type_contrat) {
            this.type_contrat = type_contrat;
            return this;
        }

        public ContratBuilder poste(String poste) {
            this.poste = poste;
            return this;
        }

        public ContratBuilder lieu_travail(String lieu_travail) {
            this.lieu_travail = lieu_travail;
            return this;
        }

        public ContratBuilder Salaire_brut(String Salaire_brut) {
            this.Salaire_brut = Salaire_brut;
            return this;
        }

        public ContratBuilder etat_civil(String etat_civil) {
            this.etat_civil = etat_civil;
            return this;
        }

        public ContratBuilder employer(Employer employer) {
            this.employer = employer;
            return this;
        }

        public ContratBuilder version(Long version) {
            this.version = version;
            return this;
        }

        public ContratBuilder date_creation(LocalDateTime date_creation) {
            this.date_creation = date_creation;
            return this;
        }

        public ContratBuilder date_modif(LocalDateTime date_modif) {
            this.date_modif = date_modif;
            return this;
        }

        public ContratBuilder util_creation(String util_creation) {
            this.util_creation = util_creation;
            return this;
        }

        public ContratBuilder util_modif(String util_modif) {
            this.util_modif = util_modif;
            return this;
        }

        public ContratBuilder forwarded(Character forwarded) {
            this.forwarded = forwarded;
            return this;
        }

        public Contrat build() {
            Contrat contrat = new Contrat();
            contrat.setId_contrat(id_contrat);
            contrat.setNom(nom);
            contrat.setPrenom(prenom);
            contrat.setLieu_recrutememnt(lieu_recrutememnt);
            contrat.setDate_embauche(date_embauche);
            contrat.setPeriode_essaie(periode_essaie);
            contrat.setDebut_periode_essaie(debut_periode_essaie);
            contrat.setFin_periode_essaie(fin_periode_essaie);
            contrat.setType_contrat(type_contrat);
            contrat.setPoste(poste);
            contrat.setLieu_travail(lieu_travail);
            contrat.setSalaire_brut(Salaire_brut);
            contrat.setEtat_civil(etat_civil);
            contrat.setEmployer(employer);
            contrat.setVersion(version);
            contrat.setDate_creation(date_creation);
            contrat.setDate_modif(date_modif);
            contrat.setUtil_creation(util_creation);
            contrat.setUtil_modif(util_modif);
            contrat.setForwarded(forwarded);
            return contrat;
        }
    }
}
