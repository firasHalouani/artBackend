package com.example.artbackend.Repository;

import com.example.artbackend.Entities.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvenementRepository extends JpaRepository<Evenement, Integer> {
}
