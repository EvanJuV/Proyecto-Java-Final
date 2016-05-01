/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

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
    
    
}
