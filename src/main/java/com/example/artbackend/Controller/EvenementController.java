package com.example.artbackend.Controller;

import com.example.artbackend.Entities.Evenement;
import com.example.artbackend.Service.EvenementService;
import com.example.artbackend.Service.ServiceUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Evenemet")
@CrossOrigin(origins = "*")
public class EvenementController {
    @Autowired
    EvenementService ES;
    @Autowired
    ServiceUtilisateur SU;


    @GetMapping("/GetAll")
    public ResponseEntity<List<Evenement>> GetAll() {
        try {
            List<Evenement> evenements = ES.GetAllEvents();
            return ResponseEntity.ok(evenements);
        }catch (Exception e ){
            return ResponseEntity.status(500).body(null);
        }

    }


    @DeleteMapping("/DeleteEvenement/{id}")
    public ResponseEntity<HttpStatus> DeleteEvenement(@PathVariable int id) {
        try {
            ES.DeleteEvenement(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e ){
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/GetEvents/{id}")
    public ResponseEntity<Evenement> getEvenement(@PathVariable int id ){
        try{
            Optional<Evenement> evenement = SU.getEvenement(id);
            if(evenement.isPresent()){
                return new ResponseEntity<>(evenement.get(), HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
