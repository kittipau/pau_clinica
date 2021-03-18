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

    public InformeGlobal(long id, String descripcion, ArrayList<Secretariado> Secretarios) {
        this.id = id;
        this.descripcion = descripcion;
        this.secretarios = secretarios;
    }
    public InformeGlobal(InformeGlobal i) {
        this.id = i.id;
        this.descripcion = i.descripcion;
        this.secretarios = i.secretarios;
    }

    @Override
    public String toString() {
        return "ID: " + id + ". Descripcion: " + descripcion + ", Listado de secretarios=" + secretarios;
    }
    
    
     /**
     * Función que se le pasa una lista ArrayList<code>InformeGlobal</code> y un
     * array de identificadores, y devuelve una sublista con los InformeGlobal cuyos
     * ids coinciden con los identificadores del array en la lista
     *
     * @param lista de Cirujanos en las que buscar
     * @param ids array de ids de Cirujanos
     * @return ArrayList<code>InformeGlobal</code>
     */
    public static ArrayList<InformeGlobal> arrayde(ArrayList<InformeGlobal> lista, int[] ids) {
        ArrayList<InformeGlobal> ret = new ArrayList<InformeGlobal>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((InformeGlobal) lista.get(j));
                    break;
                }
            }
        }
        return ret;
    }
    
    public static final ArrayList<InformeGlobal> convertir(InformeGlobal[] array) {
        ArrayList<InformeGlobal> ret = new ArrayList<InformeGlobal>();
        for (InformeGlobal i : array) {
            ret.add((InformeGlobal) i);
        }
        return ret;
    }
}
