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
import org.database.DataBaseConnection;

/**
 *
 * @author Daniel
 */
public class Dificultad {
    private String nombre;
    private int experiencia,id;
    
    public Dificultad(){}
    public Dificultad(String nombre, int experiencia){
        this.nombre= nombre;
        this.experiencia= experiencia;
        
    }
    
    
    public int getIdDificultad(String nombreDif) throws SQLException{
            Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String insertTableSQL = "SELECT id_dificultad FROM DIFICULTAD "
                + "WHERE nombre = ?";
               

        try {
            dbConnection = new DataBaseConnection().getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

           
            preparedStatement.setString(1, nombreDif);

            // execute insert SQL stetement
            ResultSet rs;
            rs=preparedStatement.executeQuery();
            int retorno=0;
            while(rs.next()){
                retorno= rs.getInt("id_dificultad");
            }
            
            dbConnection.close();
            return retorno;

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            return 0;

        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }
    }
    public int insertDBint() throws SQLException{
            Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String insertTableSQL = "INSERT INTO DIFICULTAD"
                + "( nombre, experiencia) VALUES"
                + "(?,?) returning id_dificultad";

        try {
            dbConnection = new DataBaseConnection().getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setInt(2,experiencia);
            preparedStatement.setString(1, getNombre());

            // execute insert SQL stetement
            ResultSet rs;
            rs=preparedStatement.executeQuery();
            int retorno=0;
            while(rs.next()){
                retorno= rs.getInt("id_dificultad");
            }
            
            dbConnection.close();
            return retorno;

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            return 0;

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

        String insertTableSQL = "INSERT INTO DIFICULTAD"
                + "( nombre, experiencia) VALUES"
                + "(?,?)";

        try {
            dbConnection = new DataBaseConnection().getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setInt(2,experiencia);
            preparedStatement.setString(1, getNombre());

            // execute insert SQL stetement
            preparedStatement.executeUpdate();
            dbConnection.close();

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

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the experiencia
     */
    public int getExperiencia() {
        return experiencia;
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
