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
public class Usuario {
    
    private String nombre, user, password, email;
    private int rol, id;
    
    public Usuario() {};

    public Usuario(String nombre, String user, String password, String email, int rol){
        this.nombre= nombre;
        this.user= user;
        this.password= password;
        this.email= email;
        this.rol= rol;
    }    
    
    
    public int insertDBint() throws SQLException{
         
                 Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String insertTableSQL = "INSERT INTO USUARIO"
                + "( nombre, loginUser, pass, email,id_rol) VALUES"
                + "(?,?,?,?,?) returning id_usuario";

        try {
            dbConnection = new DataBaseConnection().getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

           
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, user);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, email);
            preparedStatement.setInt(5, rol);
            // execute insert SQL stetement
            ResultSet rs;
            rs=preparedStatement.executeQuery();
            int retorno=0;
            while(rs.next()){
                retorno= rs.getInt("id_usuario");
            }
            
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
        return 0;
        
    }
    public boolean insertDB() throws SQLException{
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String insertTableSQL = "INSERT INTO USUARIO"
                + "( nombre, loginUser, pass, email,id_rol) VALUES"
                + "(?,?,?,?,?)";

        try {
            dbConnection = new DataBaseConnection().getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

           
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, user);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, email);
            preparedStatement.setInt(5, rol);
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
    
    public boolean changePassword(int idUser, String nuevo) throws SQLException{
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String insertTableSQL = "UPDATE USUARIO "
                + "SET pass= ? "
                + " WHERE id_usuario= ?";

        try {
            dbConnection = new DataBaseConnection().getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

           
            preparedStatement.setString(1, nuevo);
           
            preparedStatement.setInt(2, idUser);
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
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the rol
     */
    public int getRol() {
        return rol;
    }
    
    
    
}
