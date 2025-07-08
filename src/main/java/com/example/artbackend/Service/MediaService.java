package com.example.artbackend.Service;

import com.example.artbackend.Entities.Evenement;
import com.example.artbackend.Entities.Formation;
import com.example.artbackend.Entities.Media;
import com.example.artbackend.Entities.SousAtelier;
import com.example.artbackend.Repository.EvenementRepository;
import com.example.artbackend.Repository.FormationRepository;
import com.example.artbackend.Repository.MediaInterface;
import com.example.artbackend.Repository.SousAtelierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MediaService {

    @Autowired
    MediaInterface MI;
    @Autowired
    EvenementRepository eRepository;
    @Autowired
    FormationRepository fRepository;
    @Autowired
    SousAtelierRepository saRepository;


    public  void   AddMedia(Media media , String type , int id  ){
        System.out.println(id);
        if (type.equals("E")) {
                Evenement evenement = eRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Evenement not found"));
            media.setEvenement(evenement);
        } else if (type.equals("F")) {
            Formation formation = fRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Formation not found"));
            media.setFormation(formation);
        } else if (type.equals("S")) {
            SousAtelier sousAtelier = saRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("SousAtelier not found"));
            media.setSousAtelier(sousAtelier);
        }

         MI.save(media);
    }

    public void DeleteMedia(int id ){
        MI.deleteById(id);
    }
}
