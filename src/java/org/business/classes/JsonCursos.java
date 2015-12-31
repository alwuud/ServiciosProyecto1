/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.business.classes;

import java.sql.SQLException;
import java.util.ArrayList;
import org.input.negocio.GameLogic;
import org.json.simple.*;

/**
 *
 * @author Daniel
 */
public class JsonCursos {
    
    ArrayList<Curso> cursos;
    ArrayList<Carrera> carreras;
    
    
    public JsonCursos(){
        cursos= new ArrayList<Curso>();
        carreras= new ArrayList<Carrera>();
    }
    
    public void lecturaArchivo(String s) throws SQLException{
        JSONObject lista= (JSONObject)JSONValue.parse(s);
        JSONArray array= (JSONArray)lista.get("cursos");
        
        
        for(int j=0; j< array.size(); j++){
            JSONObject carreraActual= (JSONObject)array.get(j);
            int codigo= Integer.parseInt(String.valueOf(carreraActual.get("codigo carrera")));
            String nombre= String.valueOf(carreraActual.get("carrera"));
            
            carreras.add(new Carrera(codigo,nombre));
           
            
            JSONArray cs= (JSONArray) carreraActual.get("cursos");
            for(int k=0; k<cs.size(); k++){
                JSONObject cursoActual= (JSONObject) cs.get(k);
                int c= Integer.parseInt(String.valueOf(cursoActual.get("id")));
                String n= String.valueOf(cursoActual.get("nombre"));
                boolean a= Boolean.parseBoolean(String.valueOf(cursoActual.get("activo")));
                
                cursos.add(new Curso(c,codigo,a,n,""));
                
                
            }
                    
            
        }
        
        for(Carrera carrera: carreras){
            carrera.insertDB();
            
        }
        
        for(Curso curso: cursos){
            curso.insertDB();
        }
        
        
        
    }
    
   
    
}
