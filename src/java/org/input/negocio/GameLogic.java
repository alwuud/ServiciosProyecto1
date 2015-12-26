/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.input.negocio;

import java.sql.*;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.business.classes.Carrera;
import org.business.classes.Curso;
import org.business.classes.Pregunta;
import org.business.classes.Usuario;

/**
 *
 * @author Daniel
 */
@WebService(serviceName = "GameLogic")
public class GameLogic {

    

    /**
     * Web service operation
     */
    /**
     * 
     * @param codigo
     * @param nombre
     * @return 
     */
    @WebMethod(operationName = "nuevaCarrera")
    public Boolean nuevaCarrera(@WebParam(name = "codigo") int codigo, @WebParam(name = "nombre") String nombre)  {
        //TODO write your implementation code here:
        Carrera nueva = new Carrera(codigo, nombre);
        
        try{
           return nueva.insertDB(); 
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return false;
        
    }

    /**
     * Web service operation
     */
    /**
     * 
     * @param codigo
     * @param nombre
     * @param activo
     * @param descripcion
     * @param carrera
     * @return 
     */
    @WebMethod(operationName = "addCurso")
    public Boolean addCurso(@WebParam(name = "codigo") int codigo, @WebParam(name = "nombre") String nombre, @WebParam(name = "activo") boolean activo, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "carrera") int carrera)  {
        //TODO write your implementation code here:
        Curso nuevo=  new Curso(codigo, carrera,activo, nombre, descripcion);
        
        
        
        
        try{
            return nuevo.insertDB();
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addPregunta")
    public Boolean addPregunta(@WebParam(name = "pregunta") String pregunta, @WebParam(name = "dias") int dias, @WebParam(name = "horas") int horas, @WebParam(name = "minutos") int minutos, @WebParam(name = "curso") int curso, @WebParam(name = "dificultad") int dificultad, @WebParam(name = "respuestas") String[] respuestas) {
        //TODO write your implementation code here:
        Pregunta nueva = new Pregunta(pregunta, dias, horas, minutos,curso,dificultad);
        
        String res[];
        
        for(String respuesta: respuestas){
            res = respuesta.split("~");
            if(res[0].equals("0"))
                nueva.addRespuesta(res[1], false);
            else
                nueva.addRespuesta(res[1], true);
            
            res=null;
            
        }
        try{
          return nueva.insertDB();
          
        }catch(Exception e){
            e.printStackTrace();
            
        }
               
        
        
       return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addUser")
    public Boolean addUser(@WebParam(name = "nombre") String nombre, @WebParam(name = "user") String user, @WebParam(name = "password") String password, @WebParam(name = "email") String email, @WebParam(name = "rol") int rol) {
        //TODO write your implementation code here:
        Usuario u = new Usuario(nombre, user, password, email, rol);
        
        
        try{
           return  u.insertDB();
            
        }catch(Exception e){
            
        }
        return null;
    }
    
    
    
    
    
    

 
    
    
}
