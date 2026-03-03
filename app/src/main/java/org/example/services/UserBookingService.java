package org.example.services;

import org.example.entities.Ticket;
import org.example.entities.user;
import org.example.utils.userutilservice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
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
     //cancel booking function homework
     
}
