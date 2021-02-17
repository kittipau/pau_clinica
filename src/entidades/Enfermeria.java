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
public class Enfermeria extends Empleado {

    private char categoria; //válidos "A", "B", "C"

    //getters
    public char getCategoria() {
        return categoria;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTlfn() {
        return tlfn;
    }

    public String getNIF() {
        return NIF;
    }

    public String getDireccion() {
        return direccion;
    }

    //setters
    public void setCategoria(char categoria) {
        this.categoria = categoria;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTlfn(String tlfn) {
        this.tlfn = tlfn;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    //constructores
    public Enfermeria() {
        super();
    }

    public Enfermeria(char categoria, long id, String nombre, String apellido, String tlfn, String NIF, String direccion) {
        super(id, nombre, apellido, tlfn, NIF, direccion);
        this.categoria = categoria;
    }

    public Enfermeria(Enfermeria e) {
        this.categoria = e.categoria;
        this.id = e.id;
        this.nombre = e.nombre;
        this.apellido = e.apellido;
        this.tlfn = e.tlfn;
        this.NIF = e.NIF;
        this.direccion = e.direccion;
    }

    public Enfermeria(Empleado e, ArrayList<Especialidad> especialidades) {
        super(e);
        this.categoria = categoria;
    }

}
