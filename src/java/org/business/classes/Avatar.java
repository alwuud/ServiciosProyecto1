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
public class Avatar {
    
    private String nombre;
    private int usuario;
    
    
    
    public Avatar(){
        System.out.print("joder");
        
    }
    
    public Avatar(String nombre, int usuario){
        this.nombre= nombre;
        this.usuario= usuario;
        
    }
    
    
    public boolean insertDB() throws SQLException{
            Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String insertTableSQL = "INSERT INTO AVATAR"
                + "(nombre, id_usuario) VALUES"
                + "(?,?)";

        try {
            dbConnection = new DataBaseConnection().getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setInt(2, usuario);
            preparedStatement.setString(1, nombre);

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
     * @return the usuario
     */
    public int getUsuario() {
        return usuario;
    }
   
    public boolean equiparItem(int avat, int usuario, int itemUsuario) throws SQLException{
       // return true;\
           Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String insertTableSQL = "UPDATE ITEM_USUARIO "
                + "SET id_avatar=? " + "WHERE id_usuario= ? and id= ?  and "
                + "(select count(*) from item_usuario where id_avatar= ? ) <2";

        try {
            dbConnection = new DataBaseConnection().getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setInt(1, avat);
            preparedStatement.setInt(2, usuario);
            preparedStatement.setInt(3, itemUsuario);
            preparedStatement.setInt(4, avat);
            

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
