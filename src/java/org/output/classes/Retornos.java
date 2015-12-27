/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.output.classes;

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
public class Retornos {
    
    public ArrayList<Carrera> getCarreras() throws SQLException{
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Carrera> c= new ArrayList<Carrera>();
        
        String insertTableSQL = "SELECT codigo, nombre FROM CARRERA";

        try {
            dbConnection = new DataBaseConnection().getDBConnection();
            
            
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            

            // execute insert SQL stetement
            ResultSet rs;
            rs= preparedStatement.executeQuery();
            while(rs.next()){
                c.add(new Carrera(rs.getInt("codigo"), rs.getString("nombre")));
                
            }
            
            dbConnection.close();
            return c;
            

           

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
    
}
