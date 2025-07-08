package com.example.artbackend.Repository;

import com.example.artbackend.Entities.SousAtelier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SousAtelierRepository extends JpaRepository<SousAtelier,Integer> {
    List<SousAtelier> findByAtelier_Id(int id);
}
