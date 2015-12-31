/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.business.classes;

import java.sql.SQLException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author Daniel
 */
public class JsonItems {
     ArrayList<Item> items;
    
    
    public JsonItems(){
        items= new ArrayList<Item>();
    }
    
    public void lecturaArchivo(String s) throws SQLException{
       
              
                
        JSONObject lista= (JSONObject)JSONValue.parse(s);
      
        JSONArray array= (JSONArray)lista.get("items");
        
        
        for(int j=0; j< array.size(); j++){
            JSONObject itemActual= (JSONObject)array.get(j);
            
            String nombre= String.valueOf(itemActual.get("nombre"));
            String des= String.valueOf(itemActual.get("descripcion"));   
            int rareza= Integer.parseInt(String.valueOf( itemActual.get("rareza")));
            int efect= Integer.parseInt(String.valueOf( itemActual.get("efectividad")));
            int gana=Integer.parseInt(String.valueOf( itemActual.get("bonus_gana")));
            int pierde= Integer.parseInt(String.valueOf( itemActual.get("bonus_pierde")));
            
            boolean unUso;
            String tipo= String.valueOf(itemActual.get("tipo")).toLowerCase().trim();
            System.out.println(tipo);
            if(tipo.equals("un uso")){
                
                unUso=true;
                System.out.println(unUso);
            }else{
                unUso=false;
            }
            
            
            items.add(new Item(nombre, des,efect,rareza,gana,pierde,unUso));
            
           
            
                    
            
        }
        
        for(Item i: items){
            i.insertDB();
        }
        
        
        
        
        
    }
}
