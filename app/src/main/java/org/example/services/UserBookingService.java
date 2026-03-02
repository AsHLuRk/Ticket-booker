package org.example.services;

import org.example.entities.user;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;


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
}
