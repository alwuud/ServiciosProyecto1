/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.output.classes;

/**
 *
 * @author Daniel
 */
public class Respuesta {
    private String res;
    private boolean correcta;
    private int id;
    
    Respuesta(String res, boolean correcta) {
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
     * @param res the res to set
     */
    public void setRes(String res) {
        this.res = res;
    }

    /**
     * @return the correcta
     */
    public boolean isCorrecta() {
        return correcta;
    }

    /**
     * @param correcta the correcta to set
     */
    public void setCorrecta(boolean correcta) {
        this.correcta = correcta;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
}
