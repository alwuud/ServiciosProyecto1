/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.business.classes;

import java.sql.*;
import java.util.ArrayList;
import org.database.DataBaseConnection;

/**
 *
 * @author Daniel
 */
public class Carrera {
    
    private int codigoCarrera;
    private String nombre;
    
    
    public Carrera(){
        codigoCarrera=0;
        nombre= "Reposteria";
    }
    
    public Carrera(int codigo, String nombre){
        codigoCarrera= codigo;
        this.nombre = nombre;
        
    }
    
    
    public String getCarreraName(int code) throws SQLException{
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String insertTableSQL = "select nombre FROM CARRERA "+
               " WHERE codigo=?";
                

        try {
            dbConnection = new DataBaseConnection().getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setInt(1, code);
            
            ResultSet rs;
            rs=  preparedStatement.executeQuery();
            String retorno="";
            
            while(rs.next()){
                
                retorno= rs.getString("nombre");
                
                
            }

            // execute insert SQL stetement
           
            dbConnection.close();
            
            return retorno;
            

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }
            
            
        }
        return null;
    }
    public boolean insertDB() throws SQLException{
       Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String insertTableSQL = "INSERT INTO CARRERA"
                + "(codigo, nombre) VALUES"
                + "(?,?)";

        try {
            dbConnection = new DataBaseConnection().getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setInt(1, getCodigoCarrera());
            preparedStatement.setString(2, getNombre());

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
     * @return the codigoCarrera
     */
    public int getCodigoCarrera() {
        return codigoCarrera;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }
    
}
