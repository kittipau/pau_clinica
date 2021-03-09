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
public class Historial {

    private long historial; // >0
    private String descripcion; // Máximo 40 caracteres alfanuméricos
    private ArrayList<Alergia> alergias = new ArrayList<Alergia>();

    public long getHistoria() {
        return historial;
    }

    public void setHistoria(long historia) {
        this.historial = historia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Alergia> getAlergias() {
        return alergias;
    }

    public void setAlergias(ArrayList<Alergia> alergias) {
        this.alergias = alergias;
    }

    //CONSTRUCTORES
    public Historial() {
    }

    public Historial(long historia, String descripcion, ArrayList<Alergia> alergias) {
        this.historial = historia;
        this.descripcion = descripcion;
        this.alergias = alergias;
    }

    public Historial(Historial h) {
        this.alergias = h.alergias;
        this.descripcion = h.descripcion;
        this.historial = h.historial;
    }

    @Override
    public String toString() {
        return "Historial{" + "historia=" + historial + ", descripcion=" + descripcion + ", alergias=" + alergias + '}';
    }
    //METODOS
       /**
     * Función que se le pasa una lista ArrayList<code>historial</code> y un
     * array de identificadores, y devuelve una sublista con los Historial cuyos
     * ids coinciden con los identificadores del array en la lista
     *
     * @param lista de Historial en las que buscar
     * @param ids array de ids de Historial
     * @return ArrayList<code>Historial</code>
     */
    public static ArrayList<Historial> arrayde(ArrayList<Historial> lista, int[] ids) {
        ArrayList<Historial> ret = new ArrayList<Historial>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getHistoria() == ids[i]) {
                    ret.add((Historial) lista.get(j));
                    break;
                }
            }
        }
        return ret;
    }
    
    public static final ArrayList<Historial> convertir(Historial[] array) {
        ArrayList<Historial> ret = new ArrayList<Historial>();
        for (Historial i : array) {
            ret.add((Historial) i);
        }
        return ret;
    }
}
