/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.output.classes;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Pregunta {
        private String question,tiempo;
    private int curso, dificultad,id;
    private ArrayList<Respuesta> respuestas;
    private int dias,horas, minutos;
    

    
    
     public Pregunta(String question, int dias, int horas, int minutos, int curso, int dificultad){
     
        this.dias=dias;
        this.horas=horas;
        this.minutos= minutos;
         respuestas= new ArrayList<Respuesta>();
         
        //calculando las horas totales, del tiempo de respuesta
        int hora= horas + dias*24;
       
        
        
        //asignaciones
        
        this.question= question;
        this.tiempo=  hora + ":" + minutos + ":00" ;
        this.curso= curso;
        this.dificultad= dificultad;
        
        
    }
    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }
    
    
    public boolean addRespuesta(String res, boolean correcta){
         respuestas.add(new Respuesta(res, correcta));
         return true;
    }
    /**
     * @param question the question to set
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * @return the tiempo
     */
    public String getTiempo() {
        return tiempo;
    }

    /**
     * @param tiempo the tiempo to set
     */
    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    /**
     * @return the curso
     */
    public int getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(int curso) {
        this.curso = curso;
    }

    /**
     * @return the dificultad
     */
    public int getDificultad() {
        return dificultad;
    }

    /**
     * @param dificultad the dificultad to set
     */
    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
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
     * @return the respuestas
     */
    public ArrayList<Respuesta> getRespuestas() {
        return respuestas;
    }

    /**
     * @param respuestas the respuestas to set
     */
    public void setRespuestas(ArrayList<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }
}
