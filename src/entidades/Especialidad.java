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
public class Especialidad {

    private long id; // >0
    private String nombre; //Máximo 20 caracteres alfanuméricos
    private ArrayList<Cirugia> cirujanos = new ArrayList<Cirugia>();

    //getters
    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Cirugia> getCirujanos() {
        return cirujanos;
    }

    //setters
    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCirujanos(ArrayList<Cirugia> cirujanos) {
        this.cirujanos = cirujanos;
    }

    //constructores

    public Especialidad() {
    }

    public Especialidad(long id, String nombre, ArrayList<Cirugia> cirujanos) {
        this.id = id;
        this.nombre = nombre;
        this.cirujanos = cirujanos;
    }
    public Especialidad(Especialidad e) {
        this.id = e.id;
        this.nombre = e.nombre;
        this.cirujanos = e.cirujanos;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", nombre: " + nombre + ", lista de cirujanos=" + cirujanos;
    }
    
    //METODO    
      /**
     * Función que se le pasa una lista ArrayList<code>especialidad</code> y un
     * array de identificadores, y devuelve una sublista con los Cirujanos cuyos
     * ids coinciden con los identificadores del array en la lista
     *
     * @param lista de Cirujanos en las que buscar
     * @param ids array de ids de Cirujanos
     * @return ArrayList<code>Cirujano</code>
     */
    public static ArrayList<Especialidad> arrayde(ArrayList<Especialidad> lista, int[] ids) {
        ArrayList<Especialidad> ret = new ArrayList<Especialidad>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Especialidad) lista.get(j));
                    break;
                }
            }
        }
        return ret;
    }
    
    public static final ArrayList<Especialidad> convertir(Especialidad[] array) {
        ArrayList<Especialidad> ret = new ArrayList<Especialidad>();
        for (Especialidad i : array) {
            ret.add((Especialidad) i);
        }
        return ret;
    }
}
