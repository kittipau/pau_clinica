/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author punib
 */
public class Tratamiento {

    private long id; // >0
    private String nombre; //<=40 caracteres alfanumericos
    private Date fechaInicio; //VAL: Del 01/01/2000 hasta el 31/12/2100
    private boolean consentimiento; //caracteres S, s, N, s
    private Cobro cobro; 
    private InformeGlobal informeGlobal; 
    private ArrayList<Cita> citas = new ArrayList<Cita>();
    
    //getters

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public boolean isConsentimiento() {
        return consentimiento;
    }

    public Cobro getCobro() {
        return cobro;
    }

    public InformeGlobal getInformeGlobal() {
        return informeGlobal;
    }

    public ArrayList<Cita> getCitas() {
        return citas;
    }
    //setters

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setConsentimiento(boolean consentimiento) {
        this.consentimiento = consentimiento;
    }

    public void setCobro(Cobro cobro) {
        this.cobro = cobro;
    }

    public void setInformeGlobal(InformeGlobal informeGlobal) {
        this.informeGlobal = informeGlobal;
    }

    public void setCitas(ArrayList<Cita> citas) {
        this.citas = citas;
    }
    
    //consturctores

    public Tratamiento() {
    }

    public Tratamiento(long id, String nombre, Date fechaInicio, boolean consentimiento, Cobro cobro, InformeGlobal informeGlobal, ArrayList<Cita> citas) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.consentimiento = consentimiento;
        this.cobro = cobro;
        this.informeGlobal = informeGlobal;
        this.citas = citas;
    }
    public Tratamiento(Tratamiento t) {
        this.id = t.id;
        this.nombre = t.nombre;
        this.fechaInicio = t.fechaInicio;
        this.consentimiento = t.consentimiento;
        this.cobro = t.cobro;
        this.informeGlobal = t.informeGlobal;
        this.citas = t.citas;
    }
    
}