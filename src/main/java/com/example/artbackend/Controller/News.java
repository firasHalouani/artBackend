package com.example.artbackend.Controller;

import com.example.artbackend.Entities.Atelier;
import com.example.artbackend.Entities.Evenement;
import com.example.artbackend.Entities.Formation;
import com.example.artbackend.Entities.Tableau;
import com.example.artbackend.Service.AtelierService;
import com.example.artbackend.Service.EvenementService;
import com.example.artbackend.Service.FormationService;
import com.example.artbackend.Service.TableauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/news")
@CrossOrigin(origins = "*")
public class News {

    @Autowired
    FormationService FS;
    @Autowired
    EvenementService ES;
    @Autowired
    TableauService TS;
    @Autowired
    AtelierService AS;

    public List<Formation> FormationgetLastTwo() {
        List<Formation> allFormations = FS.GetAllFormation();
        int size = allFormations.size();
        return allFormations.subList(Math.max(size - 2, 0), size); // Get last two
    }
    public List<Evenement> EvenementgetLastTwo() {
        List<Evenement> allFormations = ES.GetAllEvents();
        int size = allFormations.size();
        return allFormations.subList(Math.max(size - 2, 0), size); // Get last two
    }

  public List<Tableau> TableautgetLastTwo() {
        List<Tableau> allFormations = TS.getAllTableau();
        int size = allFormations.size();
        return allFormations.subList(Math.max(size - 2, 0), size); // Get last two
    }

    public List<Atelier> AteliergetLastTwo() {
        List<Atelier> allFormations = AS.GetAllAtelier();
        int size = allFormations.size();
        return allFormations.subList(Math.max(size - 2, 0), size);
    }


    @GetMapping("/latest")
    public Map<String, Object> getLatestNews() {
        Map<String, Object> response = new HashMap<>();

        response.put("formations", FormationgetLastTwo());
        response.put("evenements", EvenementgetLastTwo());
        response.put("tableaux", TableautgetLastTwo());
        response.put("ateliers", AteliergetLastTwo());

        return response;
    }

}
