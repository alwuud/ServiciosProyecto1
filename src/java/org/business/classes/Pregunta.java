/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.business.classes;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Pregunta {
    private boolean resCorrecta;
    
    private String question,tiempo;
    private int curso, dificultad;
    private ArrayList<Respuesta> respuestas;
    
    /**
     * 
     * @param question
     * @param dias
     * @param horas
     * @param minutos
     * @param curso
     * @param dificultad 
     */
    public Pregunta(String question, int dias, int horas, int minutos, int curso, int dificultad){
        resCorrecta=false;
        //Inicializando arraylist de respuestas
        
         respuestas= new ArrayList<Respuesta>();
         
        //calculando las horas totales, del tiempo de respuesta
        int hora= horas + dias*24;
       
        
        
        //asignaciones
        
        this.question= question;
        this.tiempo=  hora + ":" + minutos + ":00" ;
        this.curso= curso;
        this.dificultad= dificultad;
        
        
    }
    
    public boolean addRespuesta(String res, boolean correcta){
        // resCorrecta indica si ya se ingreso la respuesta correcta
        // si resCorrecta es falsa quiere decir que aun no, en caso contrario
        // se procede  a verficiar si la nueva respuesta no es correcta
        // en caso contrario no se puede agregar la nueva respuesta
        
        if( !resCorrecta || (resCorrecta && !correcta) ){
            respuestas.add(new Respuesta(res, correcta));
            if(correcta)
                resCorrecta= correcta;
            
            
        }
        
        
        return false;
        
    }

    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @return the tiempo
     */
    public String getTiempo() {
        return tiempo;
    }

    /**
     * @return the curso
     */
    public int getCurso() {
        return curso;
    }

    /**
     * @return the dificultad
     */
    public int getDificultad() {
        return dificultad;
    }

    /**
     * @return the respuestas
     */
    public ArrayList<Respuesta> getRespuestas() {
        return respuestas;
    }
    
    
    
}
