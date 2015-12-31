/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.input.negocio;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.soap.*;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import org.output.classes.Carrera;
import org.output.classes.Curso;
import org.output.classes.Dificultad;
import org.output.classes.Pregunta;
import org.output.classes.Respuesta;
import org.output.classes.Retornos;
import org.output.classes.Usuario;

/**
 *
 * @author Daniel
 */
@WebService(serviceName = "ResponseLogic")

public class ResponseLogic {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getCarreras")
    public ArrayList<Carrera> getCarreras() {
        //TODO write your implementation code here:
        try{
            return new Retornos().getCarreras();
        }catch(Exception e){
            System.out.println("joder");
        }
        return null;
    }
    

    /**
     * Web service operation
     */
    @WebMethod(operationName = "hola")
    public Pregunta hola() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "adios")
    public Respuesta adios() {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getCurso")
    public ArrayList<Curso> getCurso(@WebParam(name = "carrera") int carrera) {
        //TODO write your implementation code here:
        
        
        try{
            return new Retornos().getCurso(carrera);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getDificultades")
    public ArrayList<Dificultad> getDificultades() {
        //TODO write your implementation code here:
        try{
            return new Retornos().getDificultades();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "checkPassword")
    public Usuario checkPassword(@WebParam(name = "user") String user, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        
        
        try{
            return new Retornos().checkPassword(user, password);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getExperiencia")
    public Integer getExperiencia(@WebParam(name = "id_usuario") int id_usuario) {
        //TODO write your implementation code here:
        try{
            return new Retornos().Exeriencia(id_usuario);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "numAvatares")
    public Integer numAvatares(@WebParam(name = "id_usuario") int id_usuario) {
        //TODO write your implementation code here:
        try{
            return new Retornos().numAvatares(id_usuario);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    

   
    
    
    
}
