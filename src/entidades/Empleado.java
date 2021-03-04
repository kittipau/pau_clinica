/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;
import pau_clinica.Utilidades;

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

    
    
    
    
    public Empleado(long id, String nombre, String apellido, String tlfn, String NIF, String direccion) {
        if (Empleado.validarId(id)) {
            this.id = id;
        } else {
            
        }
        if (Empleado.validarNombre(nombre)) {
            this.nombre = nombre;
        }
        else {

        }
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

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", tlfn=" + tlfn + ", NIF=" + NIF + ", direccion=" + direccion + '}';
    }
    
    
          //MÉTODO
    
       /**
     * Función que se le pasa una lista ArrayList<code>Empleado</code> y un
     * array de identificadores, y devuelve una sublista con los Empleados cuyos
     * ids coinciden con los identificadores del array en la lista
     *
     * @param lista de Cirujanos en las que buscar
     * @param ids array de ids de Empleados
     * @return ArrayList<code>Empleados</code>
     */
    public static ArrayList<Empleado> arrayde(ArrayList<Empleado> lista, int[] ids) {
        ArrayList<Empleado> ret = new ArrayList<Empleado>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Empleado) lista.get(j));
                    break;
                }
            }
        }
        return ret;
    }
    
    public static final ArrayList<Empleado> convertir(Empleado[] array) {
        ArrayList<Empleado> ret = new ArrayList<Empleado>();
        for (Empleado i : array) {
            ret.add((Empleado) i);
        }
        return ret;
    }
    
    
    

    public static boolean validarId(long id) {
//        boolean ret = false;
//        if(id > 0)
//            ret=true;
//        
//        return ret;

        return (id > 0);

    }

    public static boolean validarNombre(String nombre) {
        boolean ret = true;
        if (nombre.length() < 3) {
            return false;
        }
        if (nombre.length() > 150) {
            return false;
        }
        if (Utilidades.contieneDigitos(nombre)) {
            return false;
        }
        if (Utilidades.contieneCaracteresEspeciales(nombre)) {
            return false;
        }

        return ret;

    }
}
