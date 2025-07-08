package com.example.artbackend.Service;

import com.example.artbackend.Entities.Atelier;
import com.example.artbackend.Entities.SousAtelier;
import com.example.artbackend.Repository.AtelierRepository;
import com.example.artbackend.Repository.SousAtelierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtelierService {
    @Autowired
    AtelierRepository AR;

    @Autowired
    SousAtelierRepository SR;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

public void AddAtelier(Atelier atelier){
    
		
    	AR.save(atelier);
	List<Atelier> Allatelier = this.GetAllAtelier();
	messagingTemplate.convertAndSend("/topic/atelier" , Allatelier );
}


public int  AddSousAtelier(SousAtelier atelier){


   
    SousAtelier sousAtelier = SR.save(atelier);
messagingTemplate.convertAndSend("/topic/sous-atelier" , atelier);
		
    return sousAtelier.getId();
}
public void DeleteSousAtelier(SousAtelier atelier){

    messagingTemplate.convertAndSend("/topic/Sousatelier" ,atelier);
    SR.delete(atelier);



}

public void DeleteAtelier(int id ){
    messagingTemplate.convertAndSend("/topic/atelier" ,"Hello,this is a test message!");
    AR.deleteById(id);

}


    public List<Atelier> GetAllAtelier(){
        return  AR.findAll();
    }


    public List<SousAtelier> GetAllSousAtelier(int id ){
        return  SR.findByAtelier_Id( id );}






}
