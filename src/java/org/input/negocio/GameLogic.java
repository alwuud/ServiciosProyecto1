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
    public boolean nuevaCarrera(@WebParam(name = "codigo") int codigo, @WebParam(name = "nombre") String nombre)  {
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
    public boolean addCurso(@WebParam(name = "codigo") int codigo, @WebParam(name = "nombre") String nombre, @WebParam(name = "activo") boolean activo, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "carrera") int carrera)  {
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
    public boolean addPregunta(@WebParam(name = "pregunta") String pregunta, @WebParam(name = "tiempo") String tiempo, @WebParam(name = "curso") int curso, @WebParam(name = "dificultad") int dificultad, @WebParam(name = "respuestas") String[] respuestas) {
        //TODO write your implementation code here:
        Pregunta nueva = new Pregunta(pregunta,tiempo,curso,dificultad);
        
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
    public boolean addUser(@WebParam(name = "nombre") String nombre, @WebParam(name = "user") String user, @WebParam(name = "password") String password, @WebParam(name = "email") String email, @WebParam(name = "rol") int rol) {
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
    public boolean addItem(@WebParam(name = "nombre") String nombre, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "rareza") int rareza, @WebParam(name = "efectividad") int efectividad, @WebParam(name = "gana") int gana, @WebParam(name = "pierde") int pierde, @WebParam(name = "unUso") boolean unUso) {
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
    public boolean addItemUsuario(@WebParam(name = "item") int item, @WebParam(name = "usuario") int usuario) {
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
    public boolean addAvatar(@WebParam(name = "nombre") String nombre, @WebParam(name = "usuario") int usuario) {
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
    public boolean equiparItem(@WebParam(name = "avatar") int avatar, @WebParam(name = "usuario") int usuario, @WebParam(name = "item") int item) {
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
    public boolean addDificultad(@WebParam(name = "nombre") String nombre, @WebParam(name = "experiencia") int experiencia) {
        //TODO write your implementation code here:
        Dificultad d= new Dificultad(nombre,experiencia);
        try{
            return d.insertDB();
        }catch(Exception e){
            return false;
        }
        
    }
    
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "getCarrera")
    public String getCarrera(@WebParam(name = "codigo") int codigo) {
        //TODO write your implementation code here:
        try{
            Carrera n= new Carrera();
            return n.getCarreraName(codigo);
            
        }catch(Exception e){
            return null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "changePassword")
    public boolean changePassword(@WebParam(name = "idUsuario") int idUsuario, @WebParam(name = "parameter1") String parameter1) {
        //TODO write your implementation code here:
        
        try{
            Usuario u= new Usuario();
            return u.changePassword(idUsuario, parameter1);
           
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
       
    }
    
    
    
    
     
    

 
    
    
}
