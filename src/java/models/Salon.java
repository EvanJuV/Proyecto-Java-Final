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
    
    private int numeroSalon;
    private int capacidad;
    private String departamento;
    
    public Salon(){}
    
    public Salon(int numeroSalon, int capacidad, String departamento) {
        this.numeroSalon = numeroSalon;
        this.capacidad = capacidad;
        this.departamento = departamento;
    }
    
    public static ArrayList<Salon> getAll() {
        ArrayList<HashMap> result = DbConnection.executeQuery("SELECT * FROM salones;");
        ArrayList<Salon> salones = transformResults(result);
        
        return salones;
    }
    
    public void update() {
        DbConnection.executeQuery(String.format("UPDATE salones SET numeroSalon=%d, capacidad=%d, departamento=%s WHERE numeroSalon=%d, departamento=%s;", this.numeroSalon, this.capacidad, this.departamento, this.numeroSalon, this.departamento));
    }
    
    public void remove() {
        DbConnection.executeQuery(String.format("UPDATE salones SET numeroSalon=%d, capacidad=%d, departamento=%s;", this.numeroSalon, this.capacidad, this.departamento));
    }
    
    public void save() {
        DbConnection.executeQuery(String.format("INSERT INTO salones (numeroSalon, capacidad, departamento) VALUES(%d, %d, %s);", this.numeroSalon, this.capacidad, this.departamento));
    }
    
    public static ArrayList<Salon> transformResults(ArrayList<HashMap> result) {
        ArrayList<Salon> newResult = null;
        
        for (HashMap hm : result) {
            newResult.add(hashToObject(hm));
        }
        
        return newResult;
    }
    
    public static Salon hashToObject(HashMap hm) {
        Salon newSalon = new Salon();
        
        newSalon.numeroSalon = (int) hm.get("numeroSalon");
        newSalon.capacidad = (int) hm.get("capacidad");
        newSalon.departamento = (String) hm.get("departamento");
        
        return newSalon;
    }
    
    public int getNumeroSalon() {
        return numeroSalon;
    }

    public void setNumeroSalon(int numeroSalon) {
        this.numeroSalon = numeroSalon;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getDepartamento() {
        return departamento;
    }

    // Atributos de clase
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
