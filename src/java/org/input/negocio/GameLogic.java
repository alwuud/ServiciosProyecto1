/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.input.negocio;

import java.sql.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.business.classes.Carrera;
import org.business.classes.Curso;
import org.business.classes.Pregunta;

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
    
    
    
    
    
    

 
    
    
}
