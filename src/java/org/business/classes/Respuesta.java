/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.business.classes;

/**
 *
 * @author Daniel
 */
public class Respuesta {
   
    private String res;
    private boolean correcta;
    
    /**
     * 
     * @param res
     * @param correcta 
     */
    public Respuesta(String res, boolean correcta){
        this.res= res;
        this.correcta= correcta;
        
    }

    /**
     * @return the res
     */
    public String getRes() {
        return res;
    }

    /**
     * @return the correcta
     */
    public boolean isCorrecta() {
        return correcta;
    }
    
}
