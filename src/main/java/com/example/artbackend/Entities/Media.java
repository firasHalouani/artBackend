package com.example.artbackend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Media{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Path;
        @ManyToOne
        @JsonIgnore
        private Evenement evenement;
         @ManyToOne
        @JsonIgnore
        private Formation formation;
         @ManyToOne
        @JsonIgnore
        private SousAtelier sousAtelier;


}
