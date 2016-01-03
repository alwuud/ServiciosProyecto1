/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Daniel
 */
    public class DataBaseConnection {
            private static final String DB_DRIVER = "org.postgresql.Driver";
        //‐‐ DATOS DE STRING CONN ‐‐
                private static final String cHOST = "localhost";
            private static final String cPORT = "5432"; //Postgresql PORT
            private static final String cDATABASE = "Carajos";
        // ‐‐ DATOS DE USUARIO DE BD ‐‐ //
            private static final String cUSER = "postgres";
            private static final String cPASSWORD = "zcubeRules_2005";
            private static final String DB_CONNECTION = "jdbc:postgresql://" + cHOST + ":" + cPORT + "/" + cDATABASE;
        //jdbc:postgresql://HOST:PORT/basedeDatos


    /**
    * Metodo para conectar a la base de datos.
    * @return Conexion
    */
    public Connection getDBConnection() {
        Connection dbConnection = null;
        try {
             Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, cUSER, cPASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

}
