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

   public String getTrainno(){
     return train_no;
   }
   public String getTrainid(){
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
   public Map<String , String> getStationtime(){
      return station_times;
   }
   public void setTrainid(String Train_id){
      this.train_id = Train_id;
   }
   public void setTrainno(String Train_no){
      this.train_no = Train_no;
   }
   public void setDatetime(Date Datetime){
      this.datetime = Datetime;
   }
   public void setseats(List<List<Integer>> Seats){
      this.seats = Seats;
   }
   public void setStations(List<String> Stations){
      this.stations = Stations;
   }
   public void setStationsTime(Map<String, String> Station_times){
     this.station_times = Station_times;
   }

}

