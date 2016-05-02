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
    
    public static Horario get(int id) {
        ArrayList<HashMap> result = DbConnection.select(String.format("SELECT * FROM horarios WHERE id=%d;", id));
        ArrayList<Horario> horarios = transformResults(result);
        Horario horario = !horarios.isEmpty() ? horarios.get(0) : new Horario();

        return horario;
    }

//    public static ArrayList<Materia> getMaterias(int id) {
//        ArrayList<HashMap> result = DbConnection.select(String.format("SELECT * FROM materias m JOIN grupos g ON m.clave=g.materia_id JOIN horarios_grupos mtg ON g.id=mtg.grupo_id WHERE mtg.maestro_id=%d", id));
//        ArrayList<Materia> materias = Materia.transformResults(result);
//
//        return materias;
//    }

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
}
