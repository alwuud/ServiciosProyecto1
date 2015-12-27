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
public class Item {
    private String nombre, descripcion;
    private int efectividad, rareza, gana, pierde, id;
    private boolean unUsuo;
    
    
    
    public Item(){
        System.out.println("hello");
        
    }
    /**
     * 
     * @param nombre
     * @param descripcion
     * @param efectividad
     * @param rareza
     * @param gana
     * @param pierde
     * @param unUso 
     */
    public Item(String nombre, String descripcion, int efectividad,
            int rareza, int gana, int pierde, boolean unUso){
        this.nombre= nombre;
        this.descripcion= descripcion;
        this.efectividad= efectividad;
        this.rareza= rareza;
        this.gana= gana;
        this.pierde= pierde;
        this.unUsuo= unUso;
        
               
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @return the efectividad
     */
    public int getEfectividad() {
        return efectividad;
    }

    /**
     * @return the rareza
     */
    public int getRareza() {
        return rareza;
    }

    /**
     * @return the gana
     */
    public int getGana() {
        return gana;
    }

    /**
     * @return the pierde
     */
    public int getPierde() {
        return pierde;
    }

    /**
     * @return the unUsuo
     */
    public boolean isUnUsuo() {
        return unUsuo;
    }
    
    /**
     * 
     * @param idUsuario
     * @param idItem
     * @return
     * @throws SQLException 
     */
    
    public boolean agregarItemUsuario(int idUsuario, int idItem) throws SQLException{
             Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String insertTableSQL = "INSERT INTO ITEM_USUARIO"
                + "( id_usuario, id_item ) VALUES"
                + "(?,?)";

        try {
            dbConnection = new DataBaseConnection().getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setInt(1, idUsuario);
            preparedStatement.setInt(2, idItem);
            
          
            

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
    
    public boolean insertDB() throws SQLException{
            Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String insertTableSQL = "INSERT INTO ITEM"
                + "( nombre, descripcion,efectividad, rareza,gana,pierde,unUso ) VALUES"
                + "(?,?,?,?,?,?,?)";

        try {
            dbConnection = new DataBaseConnection().getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, descripcion);
            preparedStatement.setInt(3, efectividad);
            preparedStatement.setInt(4, rareza);
            preparedStatement.setInt(5, gana);
            preparedStatement.setInt(6, pierde);
            preparedStatement.setBoolean(7, unUsuo);
            

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
