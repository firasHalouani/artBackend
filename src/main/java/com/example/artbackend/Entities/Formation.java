package com.example.artbackend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name ;
    private String Description ;
    private String Formateur ;
    private Date Debut ;
    private Date Fin ;
    private int  heures ;
    private Float prix ;
    private String image ;




    @OneToMany(mappedBy = "formation")
    private  List<Media> media;




}
