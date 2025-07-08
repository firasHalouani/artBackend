package com.example.artbackend.Controller;

import com.example.artbackend.Entities.Atelier;
import com.example.artbackend.Entities.SousAtelier;
import com.example.artbackend.Service.AtelierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Atelier")

@CrossOrigin(origins = "*")

public class ControllerAtelier {
    @Autowired
    AtelierService AS;

    @GetMapping("/GetAllAtelier")
    public ResponseEntity<List<Atelier>> getAllAtelier() {
        try {
            List<Atelier> ateliers = AS.GetAllAtelier();
            return new ResponseEntity<>( ateliers , HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>( null , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

   @GetMapping("/GetSousAtelier/{id}")
    public ResponseEntity<List<SousAtelier>> getAllAtelier(@PathVariable int id ) {
        try {
            List<SousAtelier> Sousateliers = AS.GetAllSousAtelier(id);
            return new ResponseEntity<>( Sousateliers , HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>( null , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }






}
