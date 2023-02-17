package com.advance.aurore_rh.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "User")
@RequiredArgsConstructor
//@EqualsAndHashCode(callSuper = false)


public class User extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long create_id;

    @Column(length = 50)
    private String nom;

    @Column(length = 150)
    private String password;

    @Email
     @Column(unique =true )
    private String email;


    @OneToOne
    private Employer employer;

    public static final class UserBuilder {
        private long create_id;
        private String nom;
        private String password;
        private @Email String email;
        private Long version;
        private LocalDateTime date_creation;
        private LocalDateTime date_modif;
        private String util_creation;
        private String util_modif;

        private UserBuilder() {
        }

        public static UserBuilder anUser() {
            return new UserBuilder();
        }

        public UserBuilder create_id(long create_id) {
            this.create_id = create_id;
            return this;
        }

        public UserBuilder nom(String nom) {
            this.nom = nom;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder version(Long version) {
            this.version = version;
            return this;
        }

        public UserBuilder date_creation(LocalDateTime date_creation) {
            this.date_creation = date_creation;
            return this;
        }

        public UserBuilder date_modif(LocalDateTime date_modif) {
            this.date_modif = date_modif;
            return this;
        }

        public UserBuilder util_creation(String util_creation) {
            this.util_creation = util_creation;
            return this;
        }

        public UserBuilder util_modif(String util_modif) {
            this.util_modif = util_modif;
            return this;
        }

        public User build() {
            User user = new User();
            user.setCreate_id(create_id);
            user.setNom(nom);
            user.setPassword(password);
            user.setEmail(email);
            user.setVersion(version);
            user.setDate_creation(date_creation);
            user.setDate_modif(date_modif);
            user.setUtil_creation(util_creation);
            user.setUtil_modif(util_modif);
            return user;
        }
    }
}
