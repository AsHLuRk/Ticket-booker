package org.example.entities;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
public class Ticket {

    private String ticket_id;
    private String user_id;
    private String source;
    private String destination;
    private String date_of_travel;  // String, not Date — avoids parsing issues
    private String ticket_info;

    public Ticket(){} // ← Jackson needs this

    public Ticket(String ticket_id, String user_id, String source, String destination,String date_of_travel, String ticket_info){

        this.ticket_id = ticket_id;
        this.user_id = user_id;
        this.source = source;
        this.destination = destination;
        this.date_of_travel = date_of_travel;
      
        this.ticket_info = ticket_info;
    }

    // Getters
    public String getTicket_id(){ return ticket_id; }
    public String getUser_id(){ return user_id; }
    public String getSource(){ return source; }
    public String getDestination(){ return destination; }
    public String getDate_of_travel(){ return date_of_travel; }
   
    public String getTicket_info(){ return ticket_info; }

    // this is your existing method — keep it
    @JsonIgnore  
    public String getTicket(){ return ticket_info +" Train_id: "+ticket_id; }

    // Setters — names must match JSON fields exactly
    public void setTicket_id(String ticket_id){ this.ticket_id = ticket_id; }
    public void setUser_id(String user_id){ this.user_id = user_id; }
    public void setSource(String source){ this.source = source; }
    public void setDestination(String destination){ this.destination = destination; }
    public void setDate_of_travel(String date_of_travel){ this.date_of_travel = date_of_travel; }

    public void setTicket_info(String ticket_info){ this.ticket_info = ticket_info; }
}