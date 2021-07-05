package com.example.moodmanager;

import java.util.ArrayList;

public class DAO {
    static ArrayList<Humour> HumourTab= new ArrayList();
   static public void addHumour(Humour humour){
        HumourTab.add(humour);
    }
}
