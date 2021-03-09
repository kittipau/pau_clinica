/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author punib
 */
public class Cirugia extends Empleado {

    private ArrayList<Especialidad> especialidades = new ArrayList<Especialidad>();

    public ArrayList<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(ArrayList<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }

    public Cirugia() {
    }

    public Cirugia(Empleado e, ArrayList<Especialidad> especialidades) {
        super(e);
        this.especialidades = especialidades;        
    }

    public Cirugia(long id, String nombre, String apellido, String tlfn, String NIF, String direccion, ArrayList<Especialidad> especialidades) {
        super(id, nombre, apellido, tlfn, NIF, direccion);
        this.especialidades = especialidades;
        
     }
    
    public Cirugia(Cirugia c){
        this.id = c.id;
        this.nombre = c.nombre;
        this.apellido = c.apellido;
        this.NIF = c.NIF;        
        this.direccion = c.direccion;    
        this.tlfn = c.tlfn;
        this.especialidades = especialidades;
    }
    
    
    

}