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
    private int grupo;
    private int idioma;
    private boolean honors;
    private ArrayList<DetalleGrupo> detalle;
    private Materia materia;
  
    public Grupo(){}
    
    public Grupo(Grupo grupo){
        this.id = grupo.getId();
        this.grupo = grupo.getGrupo();
        this.idioma = grupo.getIdioma();
        this.honors = grupo.getHonors();
        this.materia = grupo.getMateria();
        this.detalle = grupo.getDetalle();
    }
    
    public Grupo(int grupo, int idioma, boolean honors, Materia materia, ArrayList<DetalleGrupo> detalle) {
        this.grupo = grupo;
        this.idioma = idioma;
        this.honors = honors;
        this.materia = materia;
        this.detalle = detalle;
    }
    
    public static void main(String[] args) {
//        DetalleGrupo dg = new DetalleGrupo
    }
    
    public static ArrayList<Grupo> getAll() {
        ArrayList<HashMap> result = DbConnection.select("SELECT * FROM grupos g JOIN grupos_details gd ON g.id=gd.grupo_id JOIN materias m ON m.clave=g.materia_id;");
        ArrayList<Grupo> grupos = transformResults(result);
        
        return grupos;
    }
    
    public static Grupo get(int id) {
        ArrayList<HashMap> result = DbConnection.select(String.format("SELECT * FROM grupos g JOIN grupos_details gd ON g.id=gd.grupo_id JOIN materias m ON m.clave=g.materia_id WHERE g.id=%d;", id));
        ArrayList<Grupo> grupos = transformResults(result);
        
        Grupo grupo = !grupos.isEmpty() ? grupos.get(0) : new Grupo();
        
        return grupo;
    }
    
    public void update() {
        DbConnection.query(String.format("UPDATE grupos SET materia_id='%s', grupo=%d idioma=%d, idioma=%d, honors=%b WHERE id=%d;", this.materia.getClave(), this.grupo, this.idioma, this.honors, this.id));
        
        for (DetalleGrupo d : this.detalle) {
            d.save();
        }
    }
    
    public void remove() {
        DbConnection.query(String.format("DELETE FROM grupos WHERE id=%d;", this.id));
        
        for (DetalleGrupo d : this.detalle) {
            d.remove();
        }
    }
    
    public void save() {
        int id = DbConnection.query(String.format("INSERT INTO grupos (materia_id, grupo, idioma, honors) VALUES ('%s', %d, %d, %b);", this.materia.getClave(), this.grupo, this.idioma, this.honors));

        for(DetalleGrupo d : this.detalle) {
            d.setGrupoId(id);
            d.save();
        }
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
        newGrupo.grupo = (int) hm.get("grupo");
        newGrupo.idioma = (int) hm.get("idioma");
        newGrupo.honors = (boolean) hm.get("honors");
        newGrupo.materia = Materia.hashToObject(hm);
        newGrupo.detalle = DetalleGrupo.getAllOfGroup(newGrupo.getId());
        
        return newGrupo;
    }
        
    public int getId() {
        return id;
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

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    
    public ArrayList<DetalleGrupo> getDetalle() {
        return detalle;
    }
    
    public void setDetalle(ArrayList<DetalleGrupo> detalle) {
        this.detalle = detalle;
    }
}
