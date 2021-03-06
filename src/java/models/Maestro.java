/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import database.DbConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
    
    private Maestro(Maestro maestro) {
        this.nomina = maestro.getNomina();
        this.nombre = maestro.getNombre();
        this.telefono = maestro.getTelefono();
        this.email = maestro.getEmail();
    }

    public Maestro() {
    }
    
    public static void main(String[] args) {
            
    }
    
    public static ArrayList<Maestro> getAll() {
        ArrayList<HashMap> result = DbConnection.select("SELECT * FROM maestros;");
        ArrayList<Maestro> maestros = transformResults(result);
        
        return maestros;
    }
    
    public static Maestro get(int nomina) {
        ArrayList<HashMap> result = DbConnection.select(String.format("SELECT * FROM Maestros WHERE nomina=%d;", nomina));
        ArrayList<Maestro> maestros = transformResults(result);
        Maestro maestro = !maestros.isEmpty() ? maestros.get(0) : new Maestro();
        
        return maestro;
    }
    
    public static ArrayList<Grupo> getGrupos(int nomina) {
        ArrayList<HashMap> result = DbConnection.select(String.format("SELECT * FROM grupos_details gd JOIN grupos g ON gd.grupo_id=g.id JOIN materias m ON m.clave=g.materia_id WHERE maestro_id=%d;", nomina));
        ArrayList<Grupo> grupos = Grupo.transformResults(result);
        
        return grupos;
    }
    
    public void update() {
        DbConnection.query(String.format("UPDATE maestros SET nomina=%d, "
                + "nombre='%s', telefono='%s', email='%s' WHERE nomina=%d", 
                this.nomina, this.nombre, this.telefono, this.email, this.nomina));
    }
    
    public void remove() {
        DbConnection.query(String.format("DELETE FROM maestros WHERE nomina=%d",
                this.nomina));
    }
    
    public void save() {
        DbConnection.query(String.format("INSERT INTO maestros VALUES(%d, '%s', '%s', '%s');", this.nomina, this.nombre, this.telefono, this.email));
    }
        
    public static ArrayList<Maestro> transformResults(ArrayList<HashMap> result) {
        ArrayList<Maestro> newResult = new ArrayList<>();
        
        for (HashMap hm : result) {
            
            newResult.add(hashToObject(hm));
        }
        
        return newResult;
    }
    
    public static Maestro hashToObject(HashMap hm) {
        Maestro newMaestro = new Maestro();
        
        newMaestro.nomina = (int) hm.get("nomina");
        newMaestro.nombre = (String) hm.get("nombre");
        newMaestro.telefono = (String) hm.get("telefono");
        newMaestro.email = (String) hm.get("email");

        return newMaestro;
    }
    
    public int getNomina() {
        return nomina;
    }

    public void setNomina(int nomina) {
        this.nomina = nomina;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
