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
public class DetalleGrupo {
    
    private int grupoId;
    private Maestro maestro;
    private Salon salon;
    private Horario horario;
    private boolean laboratorio;
    private double porcentaje;
    
    public DetalleGrupo() {
        
    }
    
    public DetalleGrupo(int grupoId, Maestro maestro, Salon salon, Horario horario, boolean laboratorio, double porcentaje) {
        this.grupoId = grupoId;
        this.maestro = maestro;
        this.salon = salon;
        this.horario = horario;
        this.laboratorio = laboratorio;
        this.porcentaje = porcentaje;
    }
    
    public static ArrayList<DetalleGrupo> getAllOfGroup(int grupoId) {
        ArrayList<HashMap> result = DbConnection.select(String.format("SELECT * FROM grupos_details gd"
                + " JOIN maestros m ON gd.maestro_id=m.nomina"
                + " JOIN horarios h ON gd.horario_id=h.id"
                + " JOIN salones s ON gd.salon_id=s.id"
                + " WHERE grupo_id=%d;", grupoId));
        ArrayList<DetalleGrupo> detalles = transformResults(result);
        
        return detalles;
    }
    
    public void update() {
        DbConnection.query(String.format("UPDATE grupos_details SET grupo_id=%d, maestro_id=%d, "
                + "salon_id=%d, horario_id=%d, laboratorio=%b, porcentaje=%f) WHERE grupo_id=%d;",
                this.grupoId, this.maestro.getNomina(), this.salon.getId(), this.horario.getId(), this.laboratorio, this.porcentaje));
    }
    
    public void save() {
        DbConnection.query(String.format("INSERT INTO grupos_details(grupo_id, maestro_id, "
                + "salon_id, horario_id, laboratorio, porcentaje) VALUES (%d, %d, %d, %d, %b, %f);", 
                this.grupoId, this.maestro.getNomina(), this.salon.getId(), this.horario.getId(), this.laboratorio, this.porcentaje));
    }
    
    public void remove() {
        DbConnection.query(String.format("DELETE FROM grupos_details WHERE grupo_id=%d;", this.grupoId));
    }
    
    public static ArrayList<DetalleGrupo> transformResults(ArrayList<HashMap> result) {
        ArrayList<DetalleGrupo> detalles = new ArrayList<>();
        
        for(HashMap hm : result) {
            detalles.add(hashToObject(hm));
        }
        
        return detalles;
    }
    
    public static DetalleGrupo hashToObject(HashMap hm) {
        DetalleGrupo newDetalle = new DetalleGrupo();
        
        newDetalle.grupoId = (int) hm.get("grupo_id");
        newDetalle.horario = Horario.get((int) hm.get("horario_id"));
        newDetalle.maestro = Maestro.get((int) hm.get("maestro_id"));
        newDetalle.salon = Salon.get((int) hm.get("salon_id"));
        newDetalle.laboratorio = (boolean) hm.get("laboratorio");
        newDetalle.porcentaje = (double) hm.get("porcentaje");
        
        return newDetalle;
    }
    
    public int getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(int grupoId) {
        this.grupoId = grupoId;
    }

    public Maestro getMaestro() {
        return maestro;
    }

    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public boolean isLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(boolean laboratorio) {
        this.laboratorio = laboratorio;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }
}
