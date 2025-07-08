package com.example.artbackend.Repository;

import com.example.artbackend.Entities.Utilisateur;
import com.example.artbackend.Entities.adherent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryAdhrenet extends JpaRepository<adherent, Integer> {
    List<adherent> findAllByUtilisateur_Id(int id);
}
