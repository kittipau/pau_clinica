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
    private int dosismax; // >0 en mg
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
    
          /**
     * Función que se le pasa una lista ArrayList<code>Medicamento</code> y un
     * array de identificadores, y devuelve una sublista con los Medicamento cuyos
     * ids coinciden con los identificadores del array en la lista
     *
     * @param lista de Medicamento en las que buscar
     * @param ids array de ids de Medicamentos
     * @return ArrayList<code>Medicamento</code>
     */
    
    public static ArrayList<Medicamento> arrayde(ArrayList<Medicamento> lista, int[] ids) {
        ArrayList<Medicamento> ret = new ArrayList<Medicamento>();
         for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Medicamento) lista.get(j));
                    break;
                }
            }
        }
        return ret;
        
        }
    
    public static final ArrayList<Medicamento> convertir(Medicamento[] array) {
        ArrayList<Medicamento> ret = new ArrayList<Medicamento>();
        for (Medicamento i : array) {
            ret.add((Medicamento) i);
        }
        return ret;
    }
}
