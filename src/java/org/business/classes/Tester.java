/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.business.classes;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class Tester {
    
    
    
    public static void main(String [] args){
        JsonUsuarios nuevo = new JsonUsuarios();
        InputText texto= new InputText();
        try {
            nuevo.lecturaArchivo(texto.getPlainText("usuarios.json"));
        } catch (SQLException ex) {
            Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
