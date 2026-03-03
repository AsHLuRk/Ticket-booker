package org.example.entities;
import java.util.*;

public class Ticket {
     
    private String ticket_id;
    
    private String user_id;

    private String source;

    private String destination;

    private Date date_of_travel;

    private Train train;

    private String ticket_info;

    public String getTicket(){
        return ticket_info;
    }
}
