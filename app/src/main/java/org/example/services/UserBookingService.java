package org.example.services;

import org.example.entities.Ticket;
import org.example.entities.user;
import org.example.utils.userutilservice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class UserBookingService {
    
    private user User;
    private static final String USER_PATH= "../LocalDB/users.json";
    private List<user> userlists;
    private ObjectMapper objectMapper = new ObjectMapper();

    public UserBookingService(user User1) throws IOException{
        this.User = User1;
        
        File users = new File(USER_PATH);
        userlists = objectMapper.readValue(users, new TypeReference<List<user>>() {});
    }

    public boolean userlogin(){

         Optional<user> founduser = userlists.stream().filter(User1-> {

            return User1.getname().equals(User.getname()) && userutilservice.checkpassword(User.getPassword(),User.gethashedpassword());

         }).findFirst();
         return founduser.isPresent();
    }
    public Boolean signup(user User1){

        try{
            userlists.add(User1);
            saveuserlisttofile();
            return Boolean.TRUE;
        }
        catch(IOException ex){
            return Boolean.FALSE;
        }
    
    }

    public void saveuserlisttofile() throws IOException{
        File userFile = new File(USER_PATH);

        objectMapper.writeValue(userFile, userlists);
    }

    public void fetchticket(){
      
        User.getticket();
        
    }
    
    public void Cancelticket(String Ticket_id) throws IOException{

        File data = new File(USER_PATH);
        JsonNode nodeobj = objectMapper.readTree(data);

        ArrayNode users = (ArrayNode) nodeobj;
        boolean found = false;

        for(JsonNode iternode: users){
          
            ArrayNode tickets = (ArrayNode) iternode.get("tickets_booked");
            if(tickets!=null && tickets.isArray()){

                Iterator<JsonNode> it = tickets.elements();
                
                while(it.hasNext()){
                    JsonNode ticket = it.next();
                    if(ticket.get("Ticket_id").asText().equals(Ticket_id)){
                        found = true;
                        it.remove();
                        break;
                    }
                }
                
            }
            if(found){
                    break;
                }

        }
        if(found){
        objectMapper.writeValue(data, nodeobj);
        System.out.println("Ticket has been cancelled succesfully");
        }

        else{
            System.out.println("Ticket id not found, Please recheck the ticket id");
        }

    }
     
}
