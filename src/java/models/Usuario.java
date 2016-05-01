/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import database.DbConnection;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Evan
 */
public class Usuario {
    
    // Atributos de clase
    private int id;
    private String username;
    private String password;
    
    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public Usuario() {    
    }
    
    public static boolean validate(String username, String password) {
        DbConnection db = new DbConnection();
        
        ArrayList<HashMap> result = db.executeQuery(String.format("SELECT * FROM usuarios WHERE username='%s' AND password='%s';", username, password));
        
        return !result.isEmpty();
    }
}
