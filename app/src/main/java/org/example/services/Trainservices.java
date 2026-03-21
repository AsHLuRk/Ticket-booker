package org.example.services;

import org.example.entities.Train;
import org.example.entities.user;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class Trainservices {
    
    private static final String USER_PATH="app/src/main/resources/LocalDB/trains.json";
    Train train = new Train();
    List<Train> trainlist = new ArrayList<>();
  ObjectMapper objectMapper = new ObjectMapper();
 



    public Trainservices() throws IOException{
 File Trains = new File(USER_PATH);
 
loadtrains();
    }


    public List<Train> SearchTrain(String a, String b) throws IOException{
      
        return trainlist.stream().filter(e->{
             List<String> desire = e.getStations();
             return desire.contains(a) 
             && desire.contains(b)
             && desire.indexOf(a)<desire.indexOf(b);
        }
        ).collect(Collectors.toList());
        

    }

    public void loadtrains() throws IOException {
 File Trains = new File(USER_PATH);
trainlist = objectMapper.readValue(Trains, new TypeReference<List<Train>>() {});
    }

public void seleted_trains(String a, String b , Scanner scn) throws IOException{
        List<Train> selected_Trains = SearchTrain(a, b);
        for(int i=0; i<selected_Trains.size(); i++){
            System.out.println(selected_Trains.get(i).getTrain_info());
           
        }
        
        System.out.println("Press 1, If you Want to see available Seats");
        int x = scn.nextInt();
        System.out.println("Enter the train number: ");
        String train_no = scn.next();
        if(x==1){
            checkseats(selected_Trains, train_no);
        }
        
    }

    public String get_train_info(String train_no){
        
       
            Train s = trainlist.stream().filter(e->e.getTrain_no().equals(train_no)).findFirst().orElse(null);
           
         
            return s.getTrain_info();
         }
      
    

    public int checkseats(List<Train> n1, String train_no ){
      

       Train dest_train= n1.stream().filter(e-> e.getTrain_no().equals(train_no)).findFirst().orElse(null);;
       int count =0;
        for(List<Integer> row : dest_train.getseats()){
        count += row.stream().filter(e -> e == 0).count();
    }
      
      System.out.println("The number of Available Seats is : "+count);
      return count;
       }
    // public void Bookticket(){
    //   System.out.println("Enter the Train Number: ");
    //    String train_no = scn.next();
    //    List<Train> dest_train= trainlist.stream().filter(e-> e.getTrain_no().equals(train_no)).collect(Collectors.toList());
    //    int count = checkseats(dest_train);
    //    if(count<0){
    // System.out.println("Sorry No Available Seats");
    //    }
    //    else{
    //     System.out.println("Number of Seatch Available: "+count);

    //    }
    //    System.out.println("Press 1 to proceed to booking");
    //    int x = scn.nextInt();

    // }
     
    }


