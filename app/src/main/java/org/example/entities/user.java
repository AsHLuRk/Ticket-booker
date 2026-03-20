package org.example.entities;

import java.util.ArrayList;
import java.util.List;

public class user {
  private String name;

  private String password;

  private String hashed_password;

  private List<Ticket> tickets_booked;

  private String user_id;

  

  public user(String name , String password, String hashed_password, List<Ticket> tickets_booked, String user_id  ){
     
    this.name = name;
    this.password = password;
    this.hashed_password = hashed_password;
    this.tickets_booked = tickets_booked;
    this.user_id = user_id;
     }

     //default constructor
    public user(){
      this.tickets_booked = new ArrayList<>();
    }

    public String getname(){
      return name;
    }

    public String getPassword(){
      return password;
    }

    public String gethashed_password(){
      return hashed_password;
    }
    public List<Ticket> getTickets_booked(){
    return tickets_booked;
}

    public String getUser_id(){
      return user_id;
    }
    public void setName(String name){
      this.name  = name;
    }

    public void getticket(){
     
     for(int i =0; i<tickets_booked.size(); i++){
         System.out.println(tickets_booked.get(i).getTicket());
         
     }
    }
    public void setPassword(String password){

      this.password = password;
    }
    public void setHashed_password(String hashed_password){
      this.hashed_password = hashed_password;
    }
   public void setUser_id(String user_id){
    this.user_id = user_id;
   }

   public void setTickets_booked(List<Ticket> ticket_booked){
    this.tickets_booked = ticket_booked;
   }

}
