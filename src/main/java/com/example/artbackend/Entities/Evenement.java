package com.example.artbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name ;
    private String Description ;
    private Date dateDebut;
    private  Date dateFin;
    private Float prix ;
    private  String image ;
    @OneToMany(mappedBy = "evenement" , cascade = CascadeType.ALL ,orphanRemoval = true )
    private  List<Media> media;







}
