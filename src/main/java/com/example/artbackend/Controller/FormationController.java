package com.example.artbackend.Controller;

import com.example.artbackend.Entities.Formation;
import com.example.artbackend.Service.FormationService;
import jakarta.servlet.http.HttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Formation")
@CrossOrigin(origins = "*")

public class FormationController {


    @Autowired
    private FormationService formationService;



    @GetMapping("/GetFormation")
    public ResponseEntity<List<Formation>> GetFormation() {
        try {
            List<Formation> formations = formationService.GetAllFormation();
            return ResponseEntity.ok(formations);
        }catch (Exception e){

            return ResponseEntity.notFound().build();

        }
    }

    @PostMapping("/AddFormation")
    public ResponseEntity<HttpServlet> addServlet( @RequestBody Formation formation) {
        try {

            formationService.AddFormation(formation);
            return ResponseEntity.ok().build();

        }catch (Exception e ){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/DeleteFormation/{id}")
    public ResponseEntity<HttpServlet> deleteFormation( @PathVariable  int id  ) {
        try{
            formationService.DeleteFormation(id);
            return ResponseEntity.ok().build();
        }catch (Exception e ){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }

    }

}
