package com.example.artbackend.Service;

import com.example.artbackend.Entities.Artiste;
import com.example.artbackend.Entities.Tableau;
import com.example.artbackend.Repository.ArtisteRepository;
import com.example.artbackend.Repository.TableauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableauService {
@Autowired
TableauRepository TB;

@Autowired
ArtisteRepository AR;




    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    public void createArtiste(Artiste  artiste ){
        messagingTemplate.convertAndSend("/topic/artiste" ,"Hello,this is a test message!");
        AR.save(artiste);
    }

public void deleteArtiste(Artiste artiste){

    messagingTemplate.convertAndSend("/topic/artiste" ,"Hello,this is a test message!");
        AR.delete(artiste);

}
public List<Tableau> getAllTableau(){
        return TB.findAll();
}

public void createTableau(Tableau tableau){
    messagingTemplate.convertAndSend("/topic/Tableau" ,"Hello,this is a test message!");
    TB.save(tableau);
}


public void  deleteTableau(int id ){
    messagingTemplate.convertAndSend("/topic/tableau" ,"Hello,this is a test message!");
    TB.deleteById(id);

}




public List<Artiste> GetArtistes(){


    return
            AR.findAll();
}

public List<Tableau> GetTableau(int id ){
    return  TB.findByArtiste_Id(id);
}





}
