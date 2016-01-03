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
public class Avatar {
    
     private String nombre;
    private int usuario, id;
    private Item uno;
    private Item dos;
    
    
    public Avatar(String nombre, int id){
        this.nombre= nombre;
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
     * @return the usuario
     */
    public int getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(int usuario) {
        this.usuario = usuario;
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

    /**
     * @return the uno
     */
    public Item getUno() {
        return uno;
    }

    /**
     * @param uno the uno to set
     */
    public void setUno(Item uno) {
        this.uno = uno;
    }

    /**
     * @return the dos
     */
    public Item getDos() {
        return dos;
    }

    /**
     * @param dos the dos to set
     */
    public void setDos(Item dos) {
        this.dos = dos;
    }
    
}
