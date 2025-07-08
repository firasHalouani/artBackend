package com.example.artbackend.Repository;

import com.example.artbackend.Entities.Tableau;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TableauRepository  extends JpaRepository<Tableau, Integer> {
    List<Tableau> findByArtiste_Id(int id );
}
