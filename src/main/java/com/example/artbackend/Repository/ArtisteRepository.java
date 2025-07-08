package com.example.artbackend.Repository;

import com.example.artbackend.Entities.Artiste;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtisteRepository extends JpaRepository<Artiste,Integer> {
}
