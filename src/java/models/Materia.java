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
public class Materia {

    // Atributos de clase
    public void setHorasLaboratorio(int horasLaboratorio) {
        this.horasLaboratorio = horasLaboratorio;
    }
    private String clave;
    private String nombre;
    private int horasLaboratorio;
    
    public Materia(String clave, String nombre, int horasLaboratorio) {
        this.clave = clave;
        this.nombre = nombre;
        this.horasLaboratorio = horasLaboratorio;
    }

    private Materia() {
    }

    public static void main(String[] args) {
        System.out.println(getAll());
    }

    public static ArrayList<Materia> getAll() {
        ArrayList<HashMap> result = DbConnection.select("SELECT * FROM materias;");
        ArrayList<Materia> maestros = transformResults(result);

        return maestros;
    }

    public static ArrayList<Materia> get(HashMap hm) {
        ArrayList<HashMap> result = DbConnection.select("SELECT * FROM Maestros WHERE nomina='%d';");
        ArrayList<Materia> maestros = transformResults(result);

        return maestros;
    }

    public void update() {
        DbConnection.query(String.format("UPDATE materias SET clave='%s', "
                + "nombre='%s', horasLaboratorio=%d WHERE nomina=%d",
                this.clave, this.nombre, this.horasLaboratorio));
    }

    public void remove() {
        DbConnection.query(String.format("DELETE FROM materias WHERE clave='%s'",
                this.clave));
    }

    public void save() {
        DbConnection.query(String.format("INSERT INTO materias VALUES(%s, %s, %d);", this.clave, this.nombre, this.horasLaboratorio));
    }

    public static ArrayList<Materia> transformResults(ArrayList<HashMap> result) {
        ArrayList<Materia> newResult = new ArrayList<>();

        for (HashMap hm : result) {
            newResult.add(hashToObject(hm));
        }

        return newResult;
    }

    public static Materia hashToObject(HashMap hm) {
        Materia newMateria = new Materia();

        newMateria.clave = (String) hm.get("nomina");
        newMateria.nombre = (String) hm.get("nombre");
        newMateria.horasLaboratorio = (int) hm.get("telefono");

        return newMateria;
    }
    
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorasLaboratorio() {
        return horasLaboratorio;
    }
}
