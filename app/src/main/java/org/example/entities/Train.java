package org.example.entities;
import java.sql.Time;
import java.util.*;

public class Train {
   private String Train_id;
   
   private String Train_No;

   private Date Datetime;

   private List<List<Integer>> seats;

   private List<String> stations; 

   private Map<String, Time> StationTimes;
   
}
