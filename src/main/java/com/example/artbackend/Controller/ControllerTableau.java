package com.example.artbackend.Controller;

import com.example.artbackend.Entities.Artiste;
import com.example.artbackend.Entities.Tableau;
import com.example.artbackend.Service.TableauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Tableaux")

@CrossOrigin(origins = "*")


public class ControllerTableau {
    @Autowired
    TableauService TS;

    @GetMapping("/GetArtiste")
     ResponseEntity<List<Artiste>> GetTableau() {
        try{
            List<Artiste> artistes=  TS.GetArtistes();
            return ResponseEntity.ok(artistes );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }}

        @GetMapping("/GetTableaux/{id}")
     ResponseEntity<List<Tableau>> GetTableau(@PathVariable int id ) {
            try {
                List<Tableau> tableau = TS.GetTableau(id);
            return ResponseEntity.ok(tableau );
            }catch (Exception e ){return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
                }
            }





    }



