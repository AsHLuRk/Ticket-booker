package org.example.entities;
import java.sql.Time;
import java.util.*;

public class Train {
   private String train_id;
   
   private String train_no;

   private Date datetime;

   private List<List<Integer>> seats;

   private List<String> stations; 

   private Map<String, Time> station_times;
   
}
