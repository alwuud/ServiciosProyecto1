/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.business.classes;

import java.sql.*;
import org.database.DataBaseConnection;

/**
 *
 * @author Daniel
 */
public class Carrera {
    
    private int codigoCarrera;
    private String nombre;
    
    Carrera(){
        codigoCarrera=0;
        nombre= "Reposteria";
    }
    
    public Carrera(int codigo, String nombre){
        codigoCarrera= codigo;
        this.nombre = nombre;
        
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

            preparedStatement.setInt(1, codigoCarrera);
            preparedStatement.setString(2, nombre);

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
    
}
