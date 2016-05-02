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
public class Salon {
    // Atributos de clase
    private int numeroSalon;
    private int capacidad;
    private String departamento;
    
    public Salon(){}
    
    public Salon(int numeroSalon, int capacidad, String departamento) {
        this.numeroSalon = numeroSalon;
        this.capacidad = capacidad;
        this.departamento = departamento;
    }
    
    public ArrayList<Salon> getAll() {
        ArrayList<HashMap> result = DbConnection.executeQuery("SELECT * FROM salones;");
        ArrayList<Salon> salones = transformResults(result);
        
        return salones;
    }
    
    public ArrayList<Salon> transformResults(ArrayList<HashMap> result) {
        ArrayList<Salon> newResult = null;
        
        for (HashMap hm : result) {
            newResult.add(hashToObject(hm));
        }
        
        return newResult;
    }
    
    public Salon hashToObject(HashMap hm) {
        Salon newSalon = new Salon();
        
        newSalon.numeroSalon = (int) hm.get("numeroSalon");
        newSalon.capacidad = (int) hm.get("capacidad");
        newSalon.departamento = (String) hm.get("departamento");
        
        return newSalon;
    }
}
