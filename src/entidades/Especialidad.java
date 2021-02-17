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
}
