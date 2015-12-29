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
public class Dificultad {
     private String nombre;
    private int experiencia,id;
    
       public Dificultad(String nombre, int experiencia){
        this.nombre= nombre;
        this.experiencia= experiencia;
        
    }
       
       /**
        * 
        * @param nombre
        * @param experiencia
        * @param id 
        */
       public Dificultad(String nombre, int experiencia, int id){
        this.nombre= nombre;
        this.experiencia= experiencia;
        this.id= id;
        
        
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

    /**
     * @return the experiencia
     */
    public int getExperiencia() {
        return experiencia;
    }

    /**
     * @param experiencia the experiencia to set
     */
    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
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
