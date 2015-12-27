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
public class Carrera {
    
    private int codigoCarrera;
    private String nombre;
    
    
    
    public Carrera(int codigo, String name){
        codigoCarrera= codigo;
        nombre= name;
    }
    /**
     * @return the codigoCarrera
     */
    public int getCodigoCarrera() {
        return codigoCarrera;
    }

    /**
     * @param codigoCarrera the codigoCarrera to set
     */
    public void setCodigoCarrera(int codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
