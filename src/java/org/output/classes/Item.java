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
public class Item {
    private String nombre, descripcion;
    private int efectividad, rareza, gana, pierde, id, utilizado;
    private boolean unUsuo;
    /**
     * 
     * @param nombre
     * @param descripcion
     * @param efectividad
     * @param rareza
     * @param gana
     * @param pierde
     * @param unUso
     * @param id
     * @param utilizado 
     */
     public Item(String nombre, String descripcion, int efectividad,
            int rareza, int gana, int pierde, boolean unUso, int id, int utilizado){
        this.nombre= nombre;
        this.descripcion= descripcion;
        this.efectividad= efectividad;
        this.rareza= rareza;
        this.gana= gana;
        this.pierde= pierde;
        this.unUsuo= unUso;
        this.utilizado= utilizado;
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
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the efectividad
     */
    public int getEfectividad() {
        return efectividad;
    }

    /**
     * @param efectividad the efectividad to set
     */
    public void setEfectividad(int efectividad) {
        this.efectividad = efectividad;
    }

    /**
     * @return the rareza
     */
    public int getRareza() {
        return rareza;
    }

    /**
     * @param rareza the rareza to set
     */
    public void setRareza(int rareza) {
        this.rareza = rareza;
    }

    /**
     * @return the gana
     */
    public int getGana() {
        return gana;
    }

    /**
     * @param gana the gana to set
     */
    public void setGana(int gana) {
        this.gana = gana;
    }

    /**
     * @return the pierde
     */
    public int getPierde() {
        return pierde;
    }

    /**
     * @param pierde the pierde to set
     */
    public void setPierde(int pierde) {
        this.pierde = pierde;
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
     * @return the utilizado
     */
    public int getUtilizado() {
        return utilizado;
    }

    /**
     * @param utilizado the utilizado to set
     */
    public void setUtilizado(int utilizado) {
        this.utilizado = utilizado;
    }

    /**
     * @return the unUsuo
     */
    public boolean isUnUsuo() {
        return unUsuo;
    }

    /**
     * @param unUsuo the unUsuo to set
     */
    public void setUnUsuo(boolean unUsuo) {
        this.unUsuo = unUsuo;
    }
    
}
