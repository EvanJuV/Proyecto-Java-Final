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
    private ArrayList<Pair> maestros;
    private Materia materia;
    private ArrayList<Salon> salones;
    private ArrayList<Pair> horarios;
  
    public Grupo(){}
    
    public Grupo(Grupo grupo){
        this.id = grupo.getId();
        this.materiaId = grupo.getMateriaId();
        this.grupo = grupo.getGrupo();
        this.idioma = grupo.getIdioma();
        this.honors = grupo.getHonors();
        this.materia = grupo.getMateria();
        this.salones = grupo.getSalones();
        this.horarios = grupo.getHorarios();
        this.maestros = grupo.getMaestros();
    }
    
    public Grupo(String materiaId, int grupo, int idioma, boolean honors, ArrayList<Pair> maestro, Materia materia, ArrayList<Salon> salon, ArrayList<Pair> horario) {
        this.materiaId = materiaId;
        this.grupo = grupo;
        this.idioma = idioma;
        this.honors = honors;
        this.maestros = maestro;
        this.materia = materia;
        this.salones = salon;
        this.horarios = horario;
    }
    
    public static void main(String[] args) {
        
        Pair maestros = new Pair(Maestro.get(15151515), (float) 0.5);
        ArrayList<Pair> m = new ArrayList<>();
        m.add(maestros);
        
        ArrayList<Salon> s = Salon.getAll();
        
        
        Pair horarios = new Pair(Horario.get(1), 0);
        ArrayList<Pair> h = new ArrayList();
        h.add(horarios);
        
        Grupo grp = new Grupo("1532", 1, 1, true, m, Materia.get("1532"), s, h);
        
//        grp.save();

        ArrayList<Grupo> gr = getAll();
    }
    
    public static ArrayList<Grupo> getAll() {
        ArrayList<HashMap> result = DbConnection.select("SELECT * FROM grupos g "
                + "JOIN maestros_grupos mg ON mg.grupo_id=g.id "
                + "JOIN maestros m ON m.nomina=mg.maestro_id "
                + "JOIN materias mat ON mat.clave=g.materia_id "
                + "JOIN salones_grupos sg ON sg.grupo_id=g.id "
                + "JOIN salones s ON s.id=sg.salon_id "
                + "JOIN horarios_grupos hg ON hg.grupo_id=g.id "
                + "JOIN horarios h ON h.id=hg.horario_id");
        ArrayList<Grupo> grupos = transformResults(result);
        
        return grupos;
    }
    
    public static Grupo get(int id) {
        ArrayList<HashMap> result = DbConnection.select(String.format("SELECT * FROM grupos g "
                + "JOIN maestros_grupos mg ON mg.grupo_id=g.id "
                + "JOIN maestros m ON m.nomina=mg.maestro_id "
                + "JOIN materias mat ON mat.clave=g.materia_id "
                + "JOIN salones_grupos sg ON sg.grupo_id=g.id "
                + "JOIN salones s ON s.id=sg.salon_id "
                + "JOIN horarios_grupos hg ON hg.grupo_id=g.id "
                + "JOIN horarios h ON h.id=hg.horario_id WHERE g.id=%d", id));
        ArrayList<Grupo> grupos = transformResults(result);
        
        Grupo grupo = !grupos.isEmpty() ? grupos.get(0) : new Grupo();
        
        return grupo;
    }
    
    public void update() {
        DbConnection.query(String.format("UPDATE grupos SET materia_id=%d, grupo=%d idioma=%d, honors=%d WHERE id=%d;", this.materiaId, this.grupo, this.idioma, this.honors, this.materiaId, this.id));
    }
    
    public void remove() {
        DbConnection.query(String.format("DELETE FROM grupos WHERE id=%d;", this.id));
    }
    
    public void save() {
        int id = DbConnection.query(String.format("INSERT INTO grupos (materia_id, grupo, idioma, honors) VALUES ('%s', %d, %d, %b);", this.materiaId, this.grupo, this.idioma, this.honors));
        System.out.println(id);
        for(Pair m : this.maestros) {
            DbConnection.query(String.format("INSERT INTO maestros_grupos (maestro_id, grupo_id, porcentaje) VALUES (%d, %d, %f);", ((Maestro) m.getObj()).getNomina(), id, 0.5));
        }
        
        for(Pair h : this.horarios) {
            DbConnection.query(String.format("INSERT INTO horarios_grupos (horario_id, grupo_id) VALUES (%d, %d)", ((Horario) h.getObj()).getId(), id));
        }
        
        for(Salon s : this.salones) {
            DbConnection.query(String.format("INSERT INTO salones_grupos (salon_id, grupo_id) VALUES (%d, %d)", s.getId(), id));
        }
    }
    
    public static ArrayList<Grupo> transformResults(ArrayList<HashMap> result) {
        ArrayList<Grupo> newResult = new ArrayList<Grupo>();
        
        for (HashMap hm : result) {
            newResult.add(hashToObject(hm, result));
        }
        
        return newResult;
    }
    
    public static Grupo hashToObject(HashMap hm, ArrayList<HashMap> result) {
        Grupo newGrupo = new Grupo();
        
        newGrupo.id = (int) hm.get("id");
        newGrupo.materiaId = (String) hm.get("materia_id");
        newGrupo.grupo = (int) hm.get("grupo");
        newGrupo.idioma = (int) hm.get("idioma");
        System.out.println(hm.get("honors"));
        newGrupo.honors = (boolean) hm.get("honors");
        newGrupo.horarios = getHorarios(result, newGrupo.getId());
        newGrupo.materia = Materia.hashToObject(hm);
        newGrupo.salones = getSalones(result, newGrupo.getId());
        newGrupo.maestros = getMaestros(result, newGrupo.getId());
        
        return newGrupo;
    }
    
    public static ArrayList<Pair> getHorarios(ArrayList<HashMap> results, int id) {
        ArrayList<Pair> horarios = new ArrayList<>();
        
        for(HashMap hm : results) {
            if(id == (int) hm.get("id")) {
                Pair p = new Pair(Horario.hashToObject(hm), (int) hm.get("laboratorio"));
                horarios.add(p);
            }
        }
        
        return horarios;
    }
    
    public static ArrayList<Pair> getMaestros(ArrayList<HashMap> results, int id) {
        ArrayList<Pair> maestros = new ArrayList<>();

        results.stream().filter((hm) -> (id == (int) hm.get("id"))).map((hm) -> new Pair(Maestro.hashToObject(hm), (float) hm.get("porcentaje"))).forEach((p) -> {
            maestros.add(p);
        });

        return maestros;
    }
    
    public static ArrayList<Salon> getSalones(ArrayList<HashMap> results, int id) {
        ArrayList< Salon> salones = new ArrayList<>();

        results.stream().filter((hm) -> ((int) hm.get("id") == id)).map((hm) -> Salon.hashToObject(hm)).forEach((m) -> {
            salones.add(m);
        });

        return salones;
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
    
    public ArrayList<Pair> getMaestros() {
        return maestros;
    }

    public void setMaestros(ArrayList<Pair> maestro) {
        this.maestros = maestro;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    
    public ArrayList<Pair> getHorarios() {
        return horarios;
    }

    public void setHorarios(ArrayList<Pair> horario) {
        this.horarios = horario;
    }
    
    public ArrayList<Salon> getSalones() {
        return salones;
    }

    public void setSalones(ArrayList<Salon> salon) {
        this.salones = salon;
    }
}
