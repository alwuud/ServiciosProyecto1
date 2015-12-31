/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.output.classes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class Tester {
    
    public static void main(String [] args){
        
       Usuario u=null;
        try {
            u= new Retornos().checkPassword("Usuario1", "noposmipasword");
        } catch (SQLException ex) {
            Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(u.getNombre());
    }
    
}
