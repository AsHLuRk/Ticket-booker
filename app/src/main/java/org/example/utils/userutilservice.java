package org.example.utils;

import org.mindrot.jbcrypt.BCrypt;

public class userutilservice {
    


    public static String gethashpass(String plainpassword){

        return BCrypt.hashpw(plainpassword, BCrypt.gensalt());
    }

    public static boolean checkpassword(String plainpassword , String hashpassword){
     
        return BCrypt.checkpw(plainpassword, hashpassword);

    }
}
