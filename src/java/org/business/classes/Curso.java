/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.business.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.database.DataBaseConnection;

/**
 *
 * @author Daniel
 */
public class Curso {
    
    private int codigo, carrera;
    private boolean activo;
    private String nombre, descripcion = null;
    /**
     * 
     * @param codigo
     * @param carrera
     * @param activo
     * @param nombre
     * @param descripcion 
     */
    public Curso(int codigo, int carrera, boolean activo, String nombre, String descripcion){
        this.codigo= codigo;
        this.carrera= carrera;
        this.activo= activo;
        this.nombre= nombre;
        this.descripcion= descripcion;
    }
    /**
     * 
     * @param codigo
     * @param carrera
     * @param nombre
     * @param descripcion 
     */
    
    
    public Curso(int codigo, int carrera,  String nombre, String descripcion){
        this.codigo= codigo;
        this.carrera= carrera;
        this.activo= true;
        this.nombre= nombre;
        this.descripcion= descripcion;
    }
    
    public boolean  insertDB() throws SQLException{
       Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String insertTableSQL = "INSERT INTO CURSO"
                + "(codigo, nombre,activo,descripcion, codigo_carrera) VALUES"
                + "(?,?,?,?,?)";

        try {
            dbConnection = new DataBaseConnection().getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setInt(1, codigo);
            preparedStatement.setInt(5, carrera);
            preparedStatement.setBoolean(3, activo);
            preparedStatement.setString(4, descripcion);
            
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
