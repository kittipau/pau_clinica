/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author punib
 */
public class Empleado {

    protected long id; // <0 
    protected String nombre; // Máximo 20 caracteres alfanuméricos
    protected String apellido; // Máximo 20 caracteres alfanuméricos
    protected String tlfn; // Máximo 9 caracteres numéricos
    protected String NIF; // VAL: 8 caracteres numéricos y 1 letra INVAL:!= 8 caracteres numéricos y 1 letra
    protected String direccion; // Máximo 30 caracteres alfanuméricos

    public Empleado() {
    }

    public Empleado(long id, String nombre, String apellido, String tlfn, String NIF, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tlfn = tlfn;
        this.NIF = NIF;
        this.direccion = direccion;
    }

    public Empleado(Empleado e) {
        this.id = e.id;
        this.nombre = e.nombre;
        this.apellido = e.apellido;
        this.tlfn = e.tlfn;
        this.NIF = e.NIF;
        this.direccion = e.direccion;
    }
}
