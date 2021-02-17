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
public class Paciente {

    private long id; // >0 
    private String nombre; //<=15 caracteres alfanumericos
    private String apellido; //<=20 caracteres alfanumericos
    private String DNI; // VAL: 8 caracteres numéricos y 1 letra INVAL:!= 8 caracteres numéricos y 1 letra
    private String tlfn; // Máximo 9 caracteres numéricos
    private String direccion;// <=40 caracteres alfanumericos
    private ArrayList<Tratamiento> tratamientos = new ArrayList<Tratamiento>();
    private ArrayList<Cita> citas = new ArrayList<Cita>();
    private Historial historial;

    //getters
    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public String getTlfn() {
        return tlfn;
    }

    public String getDireccion() {
        return direccion;
    }

    public ArrayList<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public ArrayList<Cita> getCitas() {
        return citas;
    }

    public Historial getHistorial() {
        return historial;
    }
    //setters

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setTlfn(String tlfn) {
        this.tlfn = tlfn;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTratamientos(ArrayList<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }

    public void setCitas(ArrayList<Cita> citas) {
        this.citas = citas;
    }

    public void setHistorial(Historial historial) {
        this.historial = historial;
    }
    //constructores

    public Paciente() {
    }

    public Paciente(long id, String nombre, String apellido, String DNI, String tlfn, String direccion, ArrayList<Tratamiento> tratamientos, ArrayList<Cita> citas, Historial historial) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.tlfn = tlfn;
        this.direccion = direccion;
        this.historial = historial;
        this.citas = citas;
        this.tratamientos = tratamientos;
    }

    public Paciente(Paciente p) {
        this.id = p.id;
        this.nombre = p.nombre;
        this.apellido = p.apellido;
        this.DNI = p.DNI;
        this.tlfn = p.tlfn;
        this.direccion = p.direccion;
        this.historial = p.historial;
        this.citas = p.citas;
        this.tratamientos = p.tratamientos;
    }
}
