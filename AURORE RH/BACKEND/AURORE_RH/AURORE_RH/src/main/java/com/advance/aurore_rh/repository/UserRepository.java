package com.advance.aurore_rh.repository;

import com.advance.aurore_rh.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long > {

    Optional <User> findByNom(String nom);
    Optional <User> findByEmail(String email);


    boolean existsByEmail(String email);

}
