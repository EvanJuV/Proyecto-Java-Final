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
public class Maestro {
    // Atributos de clase
    private int nomina;
    private String nombre;
    private String telefono;
    private String email;
    
    public Maestro(int nomina, String nombre, String telefono, String email) {
        this.nomina = nomina;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    private Maestro() {
    }
    
    public ArrayList<Maestro> getAll() {
        ArrayList<HashMap> result = DbConnection.executeQuery("SELECT * FROM maestros;");
        ArrayList<Maestro> maestros = transformResults(result);
        
        return maestros;
    }
    
//    public ArrayList<Maestro> get() {
//        
//    }
    
    public void edit() {
        
    }
    
    public void remove() {
        
    }
    
    public void save() {
        DbConnection.executeQuery(String.format("INSERT INTO maestros VALUES(%d, %s, %s, %s);", this.nomina, this.nombre, this.telefono, this.email));
    }
        
    public ArrayList<Maestro> transformResults(ArrayList<HashMap> result) {
        ArrayList<Maestro> newResult = null;
        
        for (HashMap hm : result) {
            newResult.add(hashToObject(hm));
        }
        
        return newResult;
    }
    
    public Maestro hashToObject(HashMap hm) {
        Maestro newMaestro = new Maestro();
        
        newMaestro.nomina = (int) hm.get("nomina");
        newMaestro.nombre = (String) hm.get("nombre");
        newMaestro.telefono = (String) hm.get("telefono");
        newMaestro.email = (String) hm.get("email");
        
        return newMaestro;
    }
}
