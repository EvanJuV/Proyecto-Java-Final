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
public class Grupo {
   
    // Atributos de clase
    private int id;
    private String materiaId;
    private int grupo;
    private int idioma;
    private boolean honors;
    private Maestro maestro;
    private Materia materia;
    private Salon salon;
    private Horario horario;
  
    public Grupo(){}
    
    public Grupo(Grupo grupo){
        this.id = grupo.getId();
        this.materiaId = grupo.getMateriaId();
        this.grupo = grupo.getGrupo();
        this.idioma = grupo.getIdioma();
        this.honors = grupo.getHonors();
        this.materia = grupo.getMateria();
        this.salon = grupo.getSalon();
        this.horario = grupo.getHorario();
    }
    
    public Grupo(String materiaId, int grupo, int idioma, boolean honors, Maestro maestro, Materia materia, Salon salon, Horario horario) {
        this.materiaId = materiaId;
        this.grupo = grupo;
        this.idioma = idioma;
        this.honors = honors;
        this.maestro = maestro;
        this.materia = materia;
        this.salon = salon;
        this.horario = horario;
    }
    
    public static ArrayList<Grupo> getAll() {
        ArrayList<HashMap> result = DbConnection.select("SELECT * FROM grupos;");
        ArrayList<Grupo> grupos = transformResults(result);
        
        return grupos;
    }
    
    public static void main(String args[]){
        byte num = 0;
//        Grupo rish = new Grupo("TC-10029", 1, 1, true);
//        rish.save();
        ArrayList<Grupo> salones = Grupo.getAll();
        System.out.print(salones.get(0));
    }
    
    public void update() {
        DbConnection.query(String.format("UPDATE grupos SET materia_id=%d, grupo=%d idioma=%d, honors=%d WHERE id=%d;", this.materiaId, this.grupo, this.idioma, this.honors, this.materiaId, this.id));
    }
    
    public void remove() {
        DbConnection.query(String.format("DELETE FROM grupos WHERE id=%d;", this.id));
    }
    
    public void save() {
        DbConnection.query(String.format("INSERT INTO grupos (materia_id, grupo, idioma, honors) VALUES (%d, %d, %d, %d);", this.materiaId, this.grupo, this.idioma, this.honors));
    }
    
    public static ArrayList<Grupo> transformResults(ArrayList<HashMap> result) {
        ArrayList<Grupo> newResult = new ArrayList<Grupo>();
        
        for (HashMap hm : result) {
            newResult.add(hashToObject(hm));
        }
        
        return newResult;
    }
    
    public static Grupo hashToObject(HashMap hm) {
        Grupo newGrupo = new Grupo();
        
        newGrupo.id = (int) hm.get("id");
        newGrupo.materiaId = (String) hm.get("materia_id");
        newGrupo.grupo = (int) hm.get("grupo");
        newGrupo.idioma = (int) hm.get("idioma");
        newGrupo.honors = (boolean) hm.get("honors");
        
        return newGrupo;
    }
    
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(String materiaId) {
        this.materiaId = materiaId;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public int getIdioma() {
        return idioma;
    }

    public void setIdioma(int idioma) {
        this.idioma = idioma;
    }

    public boolean getHonors() {
        return honors;
    }

    public void setHonors(boolean honors) {
        this.honors = honors;
    }
    
    public Maestro getMaestro() {
        return maestro;
    }

    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    
    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    
    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }
}
