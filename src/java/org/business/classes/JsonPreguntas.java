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
public class JsonPreguntas {
    
        ArrayList<Dificultad> dificultades;
        ArrayList<Pregunta> pregs;
   
    
    
    public JsonPreguntas(){
        dificultades= new ArrayList<Dificultad>();
    }
    
    public void lecturaArchivo(String s) throws SQLException{
        JSONObject lista= (JSONObject)JSONValue.parse(s);
        System.out.println(lista);
        JSONArray dif= (JSONArray)lista.get("dificultades");
        JSONArray array= (JSONArray)lista.get("preguntas");    
        
        
        for(int m=0; m< dif.size(); m++){
            JSONObject dificultad= (JSONObject) dif.get(m);
            String nombre= String.valueOf(dificultad.get("nombre"));
            
             int codigo= Integer.parseInt(String.valueOf(dificultad.get("EXP")));
            new Dificultad(nombre, codigo).insertDB();
             
        
        
        }
        
        
        
        for(int j=0; j< array.size(); j++){
            Pregunta nuevaPregunta;
            JSONObject preguntaActual= (JSONObject)array.get(j);
            int curso= Integer.parseInt(String.valueOf(preguntaActual.get("curso")));
            String pregunta= String.valueOf(preguntaActual.get("pregunta"));
            String nivel= String.valueOf(preguntaActual.get("nivel"));
            
            
            int dific= new Dificultad().getIdDificultad(nivel);
            
            //carreras.add(new Carrera(codigo,nombre));
            
            nuevaPregunta= new Pregunta(pregunta, curso, dific);
           
            
            JSONArray cs= (JSONArray) preguntaActual.get("respuestas");
            for(int k=0; k<cs.size(); k++){
                JSONObject cursoActual= (JSONObject) cs.get(k);
                
                String opcion= String.valueOf(cursoActual.get("opcion"));
                boolean correcta= Boolean.parseBoolean(String.valueOf(cursoActual.get("correcta")));
                nuevaPregunta.addRespuesta(opcion, correcta);
                
               // cursos.add(new Curso(c,codigo,a,n,""));
                
                
            }
            
            nuevaPregunta.insertDB();
                    
            
        }
       
        
        
        
    }
    
    
}
