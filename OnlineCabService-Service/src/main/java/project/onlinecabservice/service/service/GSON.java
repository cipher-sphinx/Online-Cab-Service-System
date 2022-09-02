/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.onlinecabservice.service.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author Sumaiya
 */
public class GSON {
    //create an object of SingleObject
    private static GSON instance = new GSON();
   
    //make the constructor private so that this class cannot be instantiated
    private GSON(){}
   
    //Get the only object available
    public static GSON getInstance(){
       return instance;
    }
    
    public Gson createGSON() {
        Gson gson = new GsonBuilder().create();
        
        return gson;
    }
   
}
