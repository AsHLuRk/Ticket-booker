package org.example.services;

import org.example.entities.Ticket;
import org.example.entities.Train;
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
    private static final String USER_PATH="app/src/main/resources/LocalDB/users.json";
    private List<user> userlists;
    private ObjectMapper objectMapper = new ObjectMapper();
    private boolean loggedStatus;

    public UserBookingService(user User1) throws IOException{
        this.User = User1;
        
         loaduser();

    }
    public UserBookingService() throws IOException{
    File users = new File(USER_PATH);
    System.out.println(users.getAbsolutePath());
    loaduser();
    }



    public List<user> loaduser() throws IOException{
        File users = new File(USER_PATH);
        return  userlists = objectMapper.readValue(users, new TypeReference<List<user>>() {});
    }
    public void returnuser(String name1, String password1){
        user usernew = userlists.stream().filter(e->e.getname().equals(name1)&& userutilservice.checkpassword(password1, e.gethashed_password())).findFirst().orElse(null);
        this.User = usernew;
       
    }
    public void setloggedstatus(boolean status){
        loggedStatus = status;
    }
    public boolean getloggedstatus(){
        return loggedStatus;
        
    }

 
    public boolean userlogin(){

         if(User==null) return false;

         Optional<user> founduser = userlists.stream().filter(User1-> {

            return User1.getname().equals(User.getname()) && userutilservice.checkpassword(User.getPassword(),User1.gethashed_password());

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
    public void bookticket( Trainservices trainservice, Scanner scn){

        
        scn.nextLine();
        System.out.println("Enter the Source Station");
        String source = scn.nextLine();
        System.out.println("Enter the destination Station");
        String destination = scn.nextLine();
        System.out.println("Enter the Date of Travel");
        String date_of_travel = scn.nextLine();
        System.out.println("Enter the Train Number: ");
        String train_no = scn.next();
        try{
        List<Train> trains = trainservice.SearchTrain(source , destination);
        int a =  trainservice.checkseats(trains, train_no);
        System.out.println("Number of Seats Availabl: "+a);
        System.out.println("Press 1 to proceed");
        int x = scn.nextInt();
        String s = trainservice.get_train_info(train_no);
        
        if(a>0){
            if(x==1){
        Ticket newTicket = new Ticket(UUID.randomUUID().toString(), User.getUser_id(),source, destination, date_of_travel ,  s);
        
          confirmticket(newTicket);



            }
        }
        else{
            System.out.println("Ticket is not Available");
        }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void confirmticket(Ticket newTicket){

        User.getTickets_booked().add(newTicket);
        try{

        userlists.stream().filter(e-> e.getUser_id().equals(User.getUser_id())).findFirst().ifPresent(e->e.setTickets_booked(User.getTickets_booked()));
        saveuserlisttofile();
        System.out.println("Ticket Has Been Booked Successfully");
        }
        catch(Exception e){
            e.printStackTrace();
        }
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
                    if(ticket.get("ticket_id").asText().equals(Ticket_id)){
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
        User.getTickets_booked().removeIf(t -> t.getTicket_id().equals(Ticket_id));
        userlists.stream()
            .filter(e -> e.getUser_id().equals(User.getUser_id()))
            .findFirst()
            .ifPresent(e -> e.setTickets_booked(User.getTickets_booked()));
        loaduser();
        
        
        System.out.println("Ticket has been cancelled succesfully");
        }

        else{
            System.out.println("Ticket id not found, Please recheck the ticket id");
        }

    }
     
}
