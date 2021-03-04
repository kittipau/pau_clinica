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
public class Alergia {

    //Atributos
    private long id; // >0
    private String nombre; //Máximo 20 caracteres alfanuméricos
    private ArrayList<Historial> historiales = new ArrayList<Historial>();

    //getters
    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Historial> getHistoriales() {
        return historiales;
    }
    //setters

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHistoriales(ArrayList<Historial> historiales) {
        this.historiales = historiales;
    }

    //constructores
    public Alergia() {
    }

    public Alergia(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Alergia(Alergia a) {
        this.id = a.id;
        this.nombre = a.nombre;
    }

    @Override
    public String toString() {
        return "Id alergia: " + id + "\n nombre= " + nombre + " \n historiales= " + historiales;
    }

    
    //MÉTODOS
    
         /**
     * Función que se le pasa una lista ArrayList<code>Alergia</code> y un
     * array de identificadores, y devuelve una sublista con los Cirujanos cuyos
     * ids coinciden con los identificadores del array en la lista
     *
     * @param lista de alergias en las que buscar
     * @param ids array de ids de Alergias
     * @return ArrayList<code>Alergia</code>
     */
    public static ArrayList<Alergia> arrayde(ArrayList<Alergia> lista, int[] ids) {
        ArrayList<Alergia> ret = new ArrayList<Alergia>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Alergia) lista.get(j));
                    break;
                }
            }
        }
        return ret;
    }
    
    public static final ArrayList<Alergia> convertir(Alergia[] array) {
        ArrayList<Alergia> ret = new ArrayList<Alergia>();
        for (Alergia i : array) {
            ret.add((Alergia) i);
        }
        return ret;
    }
   
}