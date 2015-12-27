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
import org.business.classes.Avatar;
import org.business.classes.Carrera;
import org.business.classes.Curso;
import org.business.classes.Dificultad;
import org.business.classes.Item;
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
            return false;
        }
        
        
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
          return false;
            
        }
               
        
        
      
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
            return false;
        }
       
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addItem")
    public Boolean addItem(@WebParam(name = "nombre") String nombre, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "rareza") int rareza, @WebParam(name = "efectividad") int efectividad, @WebParam(name = "gana") int gana, @WebParam(name = "pierde") int pierde, @WebParam(name = "unUso") boolean unUso) {
        //TODO write your implementation code here:
        
        Item i= new Item(nombre,descripcion,efectividad,rareza,gana,pierde,unUso);
        
        try{
            return i.insertDB();
        }catch(Exception e){
            return false;
        }
       
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addItemUsuario")
    public Boolean addItemUsuario(@WebParam(name = "item") int item, @WebParam(name = "usuario") int usuario) {
        //TODO write your implementation code here:
        Item i = new Item();
        try{
            return i.agregarItemUsuario(usuario, item);
        }catch(Exception e){
            return false;
        }
        
      
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addAvatar")
    public Boolean addAvatar(@WebParam(name = "nombre") String nombre, @WebParam(name = "usuario") int usuario) {
        //TODO write your implementation code here:
        Avatar a= new Avatar(nombre, usuario);
        try{
            return a.insertDB();
        }catch(Exception e){
            return false;
            
        }
        
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "equiparItem")
    public Boolean equiparItem(@WebParam(name = "avatar") int avatar, @WebParam(name = "usuario") int usuario, @WebParam(name = "item") int item) {
        //TODO write your implementation code here:
        Avatar a= new Avatar();
        
        
        try{
            return a.equiparItem(avatar, usuario, item);
            
        }catch(Exception e){
            return false;
        }
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addDificultad")
    public Boolean addDificultad(@WebParam(name = "nombre") String nombre, @WebParam(name = "experiencia") int experiencia) {
        //TODO write your implementation code here:
        Dificultad d= new Dificultad(nombre,experiencia);
        try{
            return d.insertDB();
        }catch(Exception e){
            return false;
        }
        
    }
    
    
    
    
     
    

 
    
    
}
