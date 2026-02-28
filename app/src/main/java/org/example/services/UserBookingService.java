package org.example.services;

import org.example.entities.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class UserBookingService {
    
    private user User;
    private static final String USER_PATH= "../LocalDB/users.json";

    private ObjectMapper ObjectMapper = new ObjectMapper();

    public UserBookingService(user User1){
        this.User = User1;
        
        File users = new File(USER_PATH);

    }
}
