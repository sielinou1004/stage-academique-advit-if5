package com.advance.aurore_rh.model;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Employer")
@Data
@RequiredArgsConstructor

public class Employer extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50)
    private String nom;


    @Column(length = 50)
    private String prenom;

    @Column(length = 50)
    private String photo;


    private Date date_naissance;

    @Column(length = 50)
    private String lieu_naissance;

    @Column(length = 50)
    private String statut_matrimoniale;

    @Column(length = 50)
    private String adresse;

    @Column(length = 50)
    private long numero;

    @Column(length = 50)
    private String type_contrat;

    private Date date_debut;

    private  Date date_fin;

    @Column(length = 50)
    private String ville_exertion;

    @Column(length = 50)
    private String nationalite;

    @Column(length = 50)
    private String matricule;

    @Column(length = 50)
    private String sexe;

    @Column(length = 50)
    private long nbr_enfant;

    @Column(length = 50)
    private String profession;

    @Column(length = 50)
    private String poste;

    @OneToOne(mappedBy = "employer")
    @JoinColumn(name = "create_id")
    private User user;


    public static final class EmployerBuilder {
        private long id;
        private String nom;
        private String prenom;
        private String photo;
        private Date date_naissance;
        private String lieu_naissance;
        private String statut_matrimoniale;
        private String adresse;
        private long numero;
        private String type_contrat;
        private Date date_debut;
        private Date date_fin;
        private String ville_exertion;
        private String nationalite;
        private String matricule;
        private String sexe;
        private long nbr_enfant;
        private String profession;
        private String poste;
        private User user;
        private Long version;
        private LocalDateTime date_creation;
        private LocalDateTime date_modif;
        private String util_creation;
        private String util_modif;

        private EmployerBuilder() {
        }

        public static EmployerBuilder anEmployer() {
            return new EmployerBuilder();
        }

        public EmployerBuilder id(long id) {
            this.id = id;
            return this;
        }

        public EmployerBuilder nom(String nom) {
            this.nom = nom;
            return this;
        }

        public EmployerBuilder prenom(String prenom) {
            this.prenom = prenom;
            return this;
        }

        public EmployerBuilder photo(String photo) {
            this.photo = photo;
            return this;
        }

        public EmployerBuilder date_naissance(Date date_naissance) {
            this.date_naissance = date_naissance;
            return this;
        }

        public EmployerBuilder lieu_naissance(String lieu_naissance) {
            this.lieu_naissance = lieu_naissance;
            return this;
        }

        public EmployerBuilder statut_matrimoniale(String statut_matrimoniale) {
            this.statut_matrimoniale = statut_matrimoniale;
            return this;
        }

        public EmployerBuilder adresse(String adresse) {
            this.adresse = adresse;
            return this;
        }

        public EmployerBuilder numero(long numero) {
            this.numero = numero;
            return this;
        }

        public EmployerBuilder type_contrat(String type_contrat) {
            this.type_contrat = type_contrat;
            return this;
        }

        public EmployerBuilder date_debut(Date date_debut) {
            this.date_debut = date_debut;
            return this;
        }

        public EmployerBuilder date_fin(Date date_fin) {
            this.date_fin = date_fin;
            return this;
        }

        public EmployerBuilder ville_exertion(String ville_exertion) {
            this.ville_exertion = ville_exertion;
            return this;
        }

        public EmployerBuilder nationalite(String nationalite) {
            this.nationalite = nationalite;
            return this;
        }

        public EmployerBuilder matricule(String matricule) {
            this.matricule = matricule;
            return this;
        }

        public EmployerBuilder sexe(String sexe) {
            this.sexe = sexe;
            return this;
        }

        public EmployerBuilder nbr_enfant(long nbr_enfant) {
            this.nbr_enfant = nbr_enfant;
            return this;
        }

        public EmployerBuilder profession(String profession) {
            this.profession = profession;
            return this;
        }

        public EmployerBuilder poste(String poste) {
            this.poste = poste;
            return this;
        }

        public EmployerBuilder user(User user) {
            this.user = user;
            return this;
        }

        public EmployerBuilder version(Long version) {
            this.version = version;
            return this;
        }

        public EmployerBuilder date_creation(LocalDateTime date_creation) {
            this.date_creation = date_creation;
            return this;
        }

        public EmployerBuilder date_modif(LocalDateTime date_modif) {
            this.date_modif = date_modif;
            return this;
        }

        public EmployerBuilder util_creation(String util_creation) {
            this.util_creation = util_creation;
            return this;
        }

        public EmployerBuilder util_modif(String util_modif) {
            this.util_modif = util_modif;
            return this;
        }

        public Employer build() {
            Employer employer = new Employer();
            employer.setId(id);
            employer.setNom(nom);
            employer.setPrenom(prenom);
            employer.setPhoto(photo);
            employer.setDate_naissance(date_naissance);
            employer.setLieu_naissance(lieu_naissance);
            employer.setStatut_matrimoniale(statut_matrimoniale);
            employer.setAdresse(adresse);
            employer.setNumero(numero);
            employer.setType_contrat(type_contrat);
            employer.setDate_debut(date_debut);
            employer.setDate_fin(date_fin);
            employer.setVille_exertion(ville_exertion);
            employer.setNationalite(nationalite);
            employer.setMatricule(matricule);
            employer.setSexe(sexe);
            employer.setNbr_enfant(nbr_enfant);
            employer.setProfession(profession);
            employer.setPoste(poste);
            employer.setUser(user);
            employer.setVersion(version);
            employer.setDate_creation(date_creation);
            employer.setDate_modif(date_modif);
            employer.setUtil_creation(util_creation);
            employer.setUtil_modif(util_modif);
            return employer;
        }
    }
}
