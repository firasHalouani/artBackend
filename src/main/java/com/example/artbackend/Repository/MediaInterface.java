package com.example.artbackend.Repository;

import com.example.artbackend.Entities.Media;
import com.example.artbackend.Entities.adherent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaInterface extends JpaRepository<Media, Integer> {
}
