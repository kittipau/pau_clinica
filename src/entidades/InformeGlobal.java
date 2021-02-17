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
public class InformeGlobal {

    private long id; //VAL: > 0 
    private String descripcion; // min 10 caracteres, máximo 500
    private ArrayList<Secretariado> secretarios = new ArrayList<Secretariado>();
    
    //getters

    public long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public ArrayList<Secretariado> getSecretarios() {
        return secretarios;
    }
    
    //Setters

    public void setId(long id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setSecretarios(ArrayList<Secretariado> secretarios) {
        this.secretarios = secretarios;
    }
    //constructores

    public InformeGlobal() {
    }

    public InformeGlobal(long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
    public InformeGlobal(InformeGlobal i) {
        this.id = i.id;
        this.descripcion = i.descripcion;
    }
    
}
