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
public class Horario {
    
    private int id;
    private String dias;
    private String hora;
    private int duracion;
    
    public Horario(int id, String dias, String hora, int duracion) {
        this.id = id;
        this.dias = dias;
        this.hora = hora;
        this.duracion = duracion;
    }
    
    public Horario() {
        
    }
    
    public static ArrayList<Horario> getAll() {
        ArrayList<HashMap> result = DbConnection.select("SELECT * FROM horarios;");
        ArrayList<Horario> horarios = transformResults(result);
        
        return horarios;
    }
    
    public static Horario get(int id) {
        ArrayList<HashMap> result = DbConnection.select(String.format("SELECT * FROM horarios WHERE id=%d;", id));
        ArrayList<Horario> horarios = transformResults(result);
        Horario horario = !horarios.isEmpty() ? horarios.get(0) : new Horario();

        return horario;
    }

    public void update() {
        DbConnection.query(String.format("UPDATE horarios SET "
                + "dias='%s', hora='%s', duracion='%d' WHERE id=%d",
                this.dias, this.hora, this.duracion, this.id));
    }

    public void remove() {
        DbConnection.query(String.format("DELETE FROM horarios WHERE id=%d",
                this.id));
    }

    public void save() {
        DbConnection.query(String.format("INSERT INTO horarios VALUES (%s, %s, %d);", this.dias, this.hora, this.duracion));
    }

    public static ArrayList<Horario> transformResults(ArrayList<HashMap> result) {
        ArrayList<Horario> newResult = new ArrayList<>();

        for (HashMap hm : result) {

            newResult.add(hashToObject(hm));
        }

        return newResult;
    }

    public static Horario hashToObject(HashMap hm) {
        Horario newHorario = new Horario();

        newHorario.id = (int) hm.get("id");
        newHorario.dias = (String) hm.get("dias");
        newHorario.hora = (String) hm.get("hora");
        newHorario.duracion = (int) hm.get("duracion");

        return newHorario;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
