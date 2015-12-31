/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.business.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.database.DataBaseConnection;

/**
 *
 * @author Daniel
 */
public class Pregunta {
    private boolean resCorrecta;
    
    private String question,tiempo;
    private int curso, dificultad,id;
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
    
    public Pregunta(String question, String tiempo, int curso, int dificultad){
        resCorrecta=false;
        //Inicializando arraylist de respuestas
        
         respuestas= new ArrayList<Respuesta>();
         
        //calculando las horas totales, del tiempo de respuesta
        
       
        
        
        //asignaciones
        
        this.question= question;
        this.tiempo=  tiempo;
        this.curso= curso;
        this.dificultad= dificultad;
        
        
    }
    
    public Pregunta(String question, int curso, int dificultad){
        resCorrecta=false;
        //Inicializando arraylist de respuestas
        
         respuestas= new ArrayList<Respuesta>();
         
        //calculando las horas totales, del tiempo de respuesta
        
       
        
        
        //asignaciones
        
        this.question= question;
        this.tiempo=  "00:01:00";
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
        
        
        return true;
        
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
    
    
    /**
     * 
     * @param indicePregunta
     * @return
     * @throws SQLException 
     */
    public boolean insertQuestionsDB(int indicePregunta) throws SQLException{
        
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String insertTableSQL = "INSERT INTO RESPUESTA"
                + "(res,correcta, id_pregunta) VALUES"
                + "(?,?,?)";

        try {
            dbConnection = new DataBaseConnection().getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);
            
            for(Respuesta actual: respuestas)
            {
                 preparedStatement.setString(1, actual.getRes());
                 preparedStatement.setBoolean(2, actual.isCorrecta());
                 preparedStatement.setInt(3, indicePregunta);
                 preparedStatement.executeUpdate();
                 
                 
                
                
            }
            
           dbConnection.close();
          
            
          

            // execute insert SQL stetement
            
            
            
            

            return true;

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            return false;

        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }
        
    
        
    }
    public boolean insertDB() throws SQLException{
               Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String insertTableSQL = "INSERT INTO PREGUNTA"
                + "(texto,tiempo, id_curso, id_dificultad) VALUES"
                + "(?, '" + tiempo  + "',?,?) RETURNING id_pregunta";

        try {
            dbConnection = new DataBaseConnection().getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setString(1, question);
            
            preparedStatement.setInt(2, curso);
            preparedStatement.setInt(3, dificultad);
            
          
            ResultSet rs;
            rs= preparedStatement.executeQuery();
            int indicePregunta=0;
            while(rs.next()){
                indicePregunta= rs.getInt("id_pregunta");
                
            }
            
            
           
            // execute insert SQL stetement
           
            dbConnection.close();
            
             return insertQuestionsDB(indicePregunta);
            
            

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            return false;

        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }
    }
    
    
}
