package org.example.entities;
import java.sql.Time;
import java.util.*;

public class Train {
   private String train_id;
   
   private String train_no;

   private Date datetime;

   private List<List<Integer>> seats;

   private List<String> stations; 

   private Map<String, String> station_times;
   private String train_info;


//default constructor
   public  Train(){}

   public Train(String train_id , String train_no , Date datetime , List<List<Integer>> seats, List<String> stations, Map<String, String> station_times){

      this.train_id = train_id;
      this.train_no = train_no;
      this.datetime = datetime;
      this.seats = seats;
      this.stations = stations;
      this.station_times = station_times;
   
   }

   public String getTrain_no(){
     return train_no;
   }
   public String getTrain_id(){
      return train_id;
   }
   public Date getDatetime(){
      return datetime;
   }
   public List<List<Integer>> getseats(){
      return seats;
   }
   public List<String> getStations(){
      return stations;
   }
   public Map<String , String> getStation_times(){
      return station_times;
   }
   public void setTrain_id(String train_id){
      this.train_id = train_id;
   }
   public void setTrain_no(String train_no){
      this.train_no = train_no;
   }
   public void setDatetime(Date datetime){
      this.datetime = datetime;
   }
   public void setseats(List<List<Integer>> seats){
      this.seats = seats;
   }
   public void setStations(List<String> stations){
      this.stations = stations;
   }
   public void setStation_times(Map<String, String> station_times){
     this.station_times = station_times;
   }
   public String getTrain_info(){ return train_info; }

// add this setter
public void setTrain_info(String train_info){ this.train_info = train_info; }

}

