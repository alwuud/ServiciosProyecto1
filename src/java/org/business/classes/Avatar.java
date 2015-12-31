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
public class Avatar {
    
    private String nombre;
    private int usuario, id;
    
    
    
    public Avatar(){
        System.out.print("joder");
        
    }
    
    public Avatar(String nombre, int usuario){
        this.nombre= nombre;
        this.usuario= usuario;
        
    }
    
    public int insertDBint() throws SQLException{
            Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String insertTableSQL = "INSERT INTO AVATAR"
                + "(nombre, id_usuario) VALUES"
                + "(?,?) returning id_avatar";

        try {
            dbConnection = new DataBaseConnection().getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setInt(2, usuario);
            preparedStatement.setString(1, nombre);

            // execute insert SQL stetement
            ResultSet rs;
            rs=preparedStatement.executeQuery();
            int retorno=0;
            while(rs.next()){
                retorno= rs.getInt("id_avatar");
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
   
    public boolean equiparItem(int avat, int usuario, int item) throws SQLException{
       // return true;\
           Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String insertTableSQL = "UPDATE ITEM_USUARIO "
                + "SET id_avatar=? " + "WHERE id_usuario= ? and id_item= ?  and "
                + "(select count(*) from item_usuario where id_avatar= ? ) <2";

        try {
            dbConnection = new DataBaseConnection().getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setInt(1, avat);
            preparedStatement.setInt(2, usuario);
            preparedStatement.setInt(3, item);
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
