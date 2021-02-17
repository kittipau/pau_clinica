/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;

/**
 *
 * @author punib
 */
public class Medicamento {
    private long id; // >0
    private String nombre; //Máximo 20 caracteres alfanuméricos
    private String principioActivo; //Máximo 20 caracteres alfanuméricos
    private int dosismax; // >0
    private ArrayList<Cita> citas = new ArrayList<Cita>();
    
    //Getters

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrincipioActivo() {
        return principioActivo;
    }

    public int getDosismax() {
        return dosismax;
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

    public void setPrincipioActivo(String principioActivo) {
        this.principioActivo = principioActivo;
    }

    public void setDosismax(int dosismax) {
        this.dosismax = dosismax;
    }

    public void setCitas(ArrayList<Cita> citas) {
        this.citas = citas;
    }
    //constructores

    public Medicamento() {
    }

    public Medicamento(long id, String nombre, String principioActivo, int dosismax, ArrayList<Cita> citas) {
        this.id = id;
        this.nombre = nombre;
        this.principioActivo = principioActivo;
        this.dosismax = dosismax;
        this.citas = citas;
    }
    public Medicamento(Medicamento m) {
        this.id = m.id;
        this.nombre = m.nombre;
        this.principioActivo = m.principioActivo;
        this.dosismax = m.dosismax;
        this.citas = m.citas;
    }
    
}
