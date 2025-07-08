package com.example.artbackend.Controller;

import com.example.artbackend.Entities.*;
import com.example.artbackend.Service.AtelierService;
import com.example.artbackend.Service.EvenementService;
import com.example.artbackend.Service.MediaService;
import com.example.artbackend.Service.TableauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Admin")
@CrossOrigin(origins = "*"  )

public class Admin {

    @Autowired
    TableauService  TS;
    @Autowired
    AtelierService AS;

    @Autowired
    MediaService MS;
    @Autowired
    EvenementService ES;

    @PostMapping("/createArtiste")

    public ResponseEntity<HttpStatus> createArtiste(@RequestBody Artiste a) {
        try {
            TS.createArtiste(a);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/createTableau")
    public ResponseEntity<HttpStatus> createTableau(@RequestBody Tableau t) {
        try {
            TS.createTableau(t);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/DeletArtiste")
    public  ResponseEntity<HttpStatus> deleteArtiste(@RequestBody Artiste a) {
        try {
            TS.deleteArtiste(a);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/DeletTableau")
    public  ResponseEntity<HttpStatus> deleteTableau(@RequestParam int id ) {
        try {
            TS.deleteTableau(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/addAtelier")
    public ResponseEntity<HttpStatus> addAtelier(@RequestBody Atelier a) {
        try{
            AS.AddAtelier(a);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/DeleteAtelier/{id}")
    public ResponseEntity<HttpStatus> DeleteAtelier(@PathVariable int id ) {
        try{
            AS.DeleteAtelier(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addSousAtelier")
    public ResponseEntity<Integer> SousAtelier(@RequestBody SousAtelier a) {
        try{
            int id = AS.AddSousAtelier(a);
            return new ResponseEntity<>(id,HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/DeleteSousAtelier")
    public ResponseEntity<HttpStatus> DeleteSousAtelier(@RequestBody SousAtelier a) {
        try{
            AS.DeleteSousAtelier(a);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @PostMapping("/AddMedia")
    public ResponseEntity<HttpStatus> addMedia(@RequestBody Media m ,@RequestParam String type , @RequestParam int id  ) {
        try {

            MS.AddMedia(m , type , id );
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @GetMapping("/DeletMedia/{id}")
    public ResponseEntity<HttpStatus> DeleteMedia(@PathVariable int id ){
        try{
            MS.DeleteMedia(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/AddEvenement")
    public ResponseEntity<HttpStatus>  addEvenement(@RequestBody Evenement evenement){
        try {
            ES.AddEvenement(evenement);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e ){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
