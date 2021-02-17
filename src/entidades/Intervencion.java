/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author punib
 */
public class Intervencion extends Cita {

    protected int duracion;
    private ArrayList<Enfermeria> enfermeros = new ArrayList<Enfermeria>();
    private ArrayList<Cirugia> cirujanos = new ArrayList<Cirugia>();

    //getter
    public int getDuracion() {
        return duracion;
    }

    public ArrayList<Enfermeria> getEnfermeros() {
        return enfermeros;
    }

    public ArrayList<Cirugia> getCirujanos() {
        return cirujanos;
    }

    //setters
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setEnfermeros(ArrayList<Enfermeria> enfermeros) {
        this.enfermeros = enfermeros;
    }

    public void setCirujanos(ArrayList<Cirugia> cirujanos) {
        this.cirujanos = cirujanos;
    }

    //constructores
    public Intervencion() {
        super();
    }

    public Intervencion(Cita c, int duracion, ArrayList<Enfermeria> enfermeros, ArrayList<Cirugia> cirujanos) {
        super(c);
        this.duracion = duracion;
        this.enfermeros = enfermeros;
        this.cirujanos = cirujanos;
    }

    public Intervencion(int duracion, long id, Date fecha, char rangoHorario, Time hora, Secretariado secretario) {
        super(id, fecha, rangoHorario, hora, secretario);
        this.duracion = duracion;
        this.cirujanos = cirujanos;
        this.enfermeros = enfermeros;
    }

    public Intervencion(Intervencion i) {
        this.duracion = i.duracion;
        this.id = i.id;
        this.fecha = i.fecha;
        this.rangoHorario = i.rangoHorario;
        this.hora = i.hora;
        this.secretario = i.secretario;
        this.cirujanos = i.cirujanos;
        this.enfermeros = i.enfermeros;
    }

}
