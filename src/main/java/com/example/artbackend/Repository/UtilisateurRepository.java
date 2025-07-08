package com.example.artbackend.Repository;

import com.example.artbackend.Entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur , Integer> {
    Optional<Utilisateur> findByUsername(String username);
    Utilisateur findUtilisateurByEmail(String email);
}
