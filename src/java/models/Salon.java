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
    
    private int id;
    private int numeroSalon;
    private int capacidad;
    private String departamento;
    
    public Salon(){}
    
    public Salon(int numeroSalon, int capacidad, String departamento) {
        this.numeroSalon = numeroSalon;
        this.capacidad = capacidad;
        this.departamento = departamento;
    }
    
    public Salon(Salon salon) {
        this.id = salon.getId();
        this.numeroSalon = salon.getNumeroSalon();
        this.capacidad = salon.getCapacidad();
        this.departamento = salon.getDepartamento();
    }
    
    public static ArrayList<Salon> getAll() {
        ArrayList<HashMap> result = DbConnection.select("SELECT * FROM salones;");
        ArrayList<Salon> salones = transformResults(result);
        
        return salones;
    }
    
    public static Salon get(int id) {
        ArrayList<HashMap> result = DbConnection.select(String.format("SELECT * FROM salones WHERE id=%d;", id));
        ArrayList<Salon> salones = transformResults(result);
        Salon salon = !salones.isEmpty() ? salones.get(0) : new Salon();

        return salon;
    }
    
    public static void main(String args[]){
        Salon rish = new Salon(1, 1, "Rishurd");
        //rish.save();
        ArrayList<Salon> salones = Salon.getAll();
        System.out.print(salones.get(0));
    }
    
    public void update() {
        DbConnection.query(String.format("UPDATE salones SET numero_salon=%d, capacidad=%d, departamento='%s' WHERE id=%d;", this.numeroSalon, this.capacidad, this.departamento, this.id));
    }
    
    public void remove() {
        DbConnection.query(String.format("DELETE FROM salones WHERE id=%d;", this.id));
    }
    
    public void save() {
        DbConnection.query(String.format("INSERT INTO salones (numero_salon, capacidad, departamento) VALUES (%d, %d, '%s');", this.numeroSalon, this.capacidad, this.departamento));
    }
    
    public static ArrayList<Salon> transformResults(ArrayList<HashMap> result) {
        ArrayList<Salon> newResult = new ArrayList<Salon>();
        
        for (HashMap hm : result) {
            newResult.add(hashToObject(hm));
        }
        
        return newResult;
    }
    
    public static Salon hashToObject(HashMap hm) {
        Salon newSalon = new Salon();
        
        newSalon.id = (int) hm.get("id");
        newSalon.numeroSalon = (int) hm.get("numero_salon");
        newSalon.capacidad = (int) hm.get("capacidad");
        newSalon.departamento = (String) hm.get("departamento");
        
        return newSalon;
    }
    
    public int getId() {
        return id;
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

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    public void setId(int id) {
        this.id = id;
    }
}
