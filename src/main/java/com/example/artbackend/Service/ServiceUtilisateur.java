package com.example.artbackend.Service;

import com.example.artbackend.Entities.*;
import com.example.artbackend.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceUtilisateur {


 @Autowired
 RepositoryAdhrenet RA;
 @Autowired
 EvenementRepository ER;
 @Autowired
 SousAtelierRepository SR;
 @Autowired
 FormationRepository FR;
 @Autowired
 UtilisateurRepository AR;

 public void addadhrenet(adherent ad  ){
     RA.save(ad);
 }

public List<adherent> getAlladhrenet(int id ){
  return RA.findAllByUtilisateur_Id(id);
}
 public Optional<Evenement> getEvenement(int id){
     return ER.findById(id);

 }

 public Optional<SousAtelier> getSousAtelier(int id){
     return SR.findById(id);
 }

 public Optional<Formation> getFormation(int id){
     return FR.findById(id);
 }




}
