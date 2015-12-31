/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.business.classes;

import java.sql.SQLException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author Daniel
 */
public class JsonUsuarios {
    
     
    
    
    public JsonUsuarios(){
        
    }
    
    public void lecturaArchivo(String s) throws SQLException{
        JSONObject lista= (JSONObject)JSONValue.parse(s);
        System.out.println(lista);
        JSONArray array= (JSONArray)lista.get("jugadores");
        
        
        for(int j=0; j< array.size(); j++){
            JSONObject usuario= (JSONObject)array.get(j);
            
            String rol= String.valueOf(usuario.get("rol")).toLowerCase().trim();
            String user= String.valueOf(usuario.get("usuario"));
            String email= String.valueOf(usuario.get("email"));
            String pass= String.valueOf(usuario.get("password"));
            int id=0;
            int ro=0;
            
            if(rol.equals("administrador")){
                ro=1;
            }else if(rol.equals("jugador")){
                ro=3;
            }else{
                ro=2;
            }
            System.out.println(user);
            
            Usuario u= new Usuario(user, user, pass,email,ro);
            id= u.insertDBint();
            //carreras.add(new Carrera(codigo,nombre));
            
            
           System.out.println(usuario + " avatar");
            try{
                JSONArray cs= (JSONArray) usuario.get("avatares");
                for(int k=0; k<cs.size(); k++){
                    JSONObject avatarActual= (JSONObject) cs.get(k);
                    int e1=0, e2=0;


                    try{
                        e1= Integer.parseInt(String.valueOf(avatarActual.get("equipo1")));
                    }catch(Exception e){
                        e1=0;
                    }


                    try{
                        e2= Integer.parseInt(String.valueOf(avatarActual.get("equipo2")));
                    }catch(Exception e){
                        e2=0;
                    }
                    int idAvatar=0;

                    String nombre= String.valueOf(avatarActual.get("nombre"));
                    Avatar a= new Avatar(nombre, id);
                    idAvatar= a.insertDBint();

                    if(e1!=0)
                        new Item().agregarItemUsuario(id, e1);
                        a.equiparItem(idAvatar, id, e1);

                    if(e2!=0)
                        new Item().agregarItemUsuario(id, e2);
                        a.equiparItem(idAvatar, id, e2);
                    a=null;


                    //cursos.add(new Curso(c,codigo,a,n,""));


                }
            }catch(Exception e){
                JSONObject avatarActual= (JSONObject) usuario.get("avatares");
                if(avatarActual!=null){
                    
                
                    int e1=0, e2=0;


                        try{
                            e1= Integer.parseInt(String.valueOf(avatarActual.get("equipo1")));
                        }catch(Exception m){
                            e1=0;
                        }


                        try{
                            e2= Integer.parseInt(String.valueOf(avatarActual.get("equipo2")));
                        }catch(Exception n){
                            e2=0;
                        }
                        int idAvatar=0;

                        String nombre= String.valueOf(avatarActual.get("nombre"));
                        Avatar a= new Avatar(nombre, id);
                        idAvatar= a.insertDBint();

                        if(e1!=0)
                            new Item().agregarItemUsuario(id, e1);
                            a.equiparItem(idAvatar, id, e1);

                        if(e2!=0)
                            new Item().agregarItemUsuario(id, e2);
                            a.equiparItem(idAvatar, id, e2);
                        a=null;
                }
            }
            u=null;
                    
            
        }
        
      
        
        
        
    }
    
    
}
