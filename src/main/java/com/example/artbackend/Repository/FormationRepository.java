package com.example.artbackend.Repository;

import com.example.artbackend.Entities.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormationRepository extends JpaRepository<Formation, Integer> {
}
