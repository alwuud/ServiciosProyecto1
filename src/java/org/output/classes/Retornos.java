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
     public int numAvatares(int user) throws SQLException{
          Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        int retorno=0;
        
        String insertTableSQL = "SELECT count(*) as avatares FROM AVATAR " +
                " WHERE id_usuario= ?";

        try {
            dbConnection = new DataBaseConnection().getDBConnection();
            
            
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setInt(1,user );

            // execute insert SQL stetement
            ResultSet rs;
            rs= preparedStatement.executeQuery();
            while(rs.next()){
                retorno= rs.getInt("avatares");
                
                
                   
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
    public int Exeriencia(int user) throws SQLException{
          Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        int retorno=0;
        
        String insertTableSQL = "SELECT experiencia FROM USUARIO " +
                " WHERE id_usuario= ?";

        try {
            dbConnection = new DataBaseConnection().getDBConnection();
            
            
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setInt(1,user );

            // execute insert SQL stetement
            ResultSet rs;
            rs= preparedStatement.executeQuery();
            while(rs.next()){
                retorno= rs.getInt("experiencia");
                
                
                   
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
    public Usuario checkPassword(String user, String password) throws SQLException{
          Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        Usuario usuario=null;
        
        String insertTableSQL = "SELECT * FROM USUARIO " +
                " WHERE loginUser= ? and pass=?";

        try {
            dbConnection = new DataBaseConnection().getDBConnection();
            
            
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setString(1, user);
            preparedStatement.setString(2, password);

            // execute insert SQL stetement
            ResultSet rs;
            rs= preparedStatement.executeQuery();
            while(rs.next()){
                String nombre= rs.getString("nombre");
                String u= rs.getString("loginUser");
                String p= rs.getString("pass");
                String e= rs.getString("email");
                int r= rs.getInt("id_rol");
                int i= rs.getInt("id_usuario");
                
                usuario= new Usuario(nombre, u, p, e, r, i);
                
                   
            }
            
            dbConnection.close();
            
            return usuario;

           

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
    
    
    public ArrayList<Curso> getCurso(int carrera) throws SQLException{
        
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Curso> c= new ArrayList<Curso>();
        
        String insertTableSQL = "SELECT * FROM CURSO " +
                " WHERE codigo_carrera=? and activo=true";

        try {
            dbConnection = new DataBaseConnection().getDBConnection();
            
            
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setInt(1, carrera);

            // execute insert SQL stetement
            ResultSet rs;
            rs= preparedStatement.executeQuery();
            while(rs.next()){
                c.add(new Curso(rs.getInt("codigo"), rs.getInt("codigo_carrera"),
                rs.getString("nombre"), rs.getBoolean("activo"),"chilero"));
                   
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
    
    public ArrayList<Dificultad> getDificultades() throws SQLException{
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Dificultad> c= new ArrayList<Dificultad>();
        
        String insertTableSQL = "SELECT * FROM DIFICULTAD ";
           

        try {
            dbConnection = new DataBaseConnection().getDBConnection();
            
            
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            

            // execute insert SQL stetement
            ResultSet rs;
            rs= preparedStatement.executeQuery();
            while(rs.next()){
                c.add( new Dificultad(rs.getString("nombre"), rs.getInt("experiencia"), rs.getInt("id_dificultad")));
                
                
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
