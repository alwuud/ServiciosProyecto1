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
import org.output.classes.Retornos;

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
    
    
    
}
