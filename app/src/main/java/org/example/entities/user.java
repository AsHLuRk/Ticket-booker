package org.example.entities;

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
    public user(){}

    public String getname(){
      return name;
    }

    public String getPassword(){
      return password;
    }

    public String gethashedpassword(){
      return hashed_password;
    }
    public List getTicketbooked(){
      return tickets_booked;
    }

    public String getUserid(){
      return user_id;
    }
    public void setName(String Name){
      this.name  = Name;
    }

    public void getticket(){

     for(int i =0; i<tickets_booked.size(); i++){
         System.out.println(tickets_booked.get(i).getTicket());
     }
    }
    public void setPassword(String Password){

      this.password = Password;
    }
    public void setHashedpassword(String Hashed_password){
      this.hashed_password = Hashed_password;
    }
   public void setUserid(String User_id){
    this.user_id = User_id;
   }

   public void setTicketbooked(List<Ticket> Ticket_booked){
    this.tickets_booked = Ticket_booked;
   }

}
