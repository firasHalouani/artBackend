package com.example.artbackend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Utilisateur  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String numero;
    private int age;
    private String image;
    private boolean statut;
    private String role;


    @OneToMany(mappedBy = "utilisateur")
    private List<adherent> adherents;
}
