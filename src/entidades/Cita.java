/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import pau_clinica.Utilidades;

/**
 *
 * @author punib
 */
public class Cita {

    protected long id; // >0
    protected Date fecha; //VAL: Del 01/01/2000 hasta el 31/12/2100
    protected char rangoHorario; //caracteres M, m, T, t
    protected Time hora; // 
    protected Secretariado secretario;
    protected ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();

    //getters
    public long getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public char getRangoHorario() {
        return rangoHorario;
    }

    public Time getHora() {
        return hora;
    }

    public Secretariado getSecretario() {
        return secretario;
    }

    public ArrayList<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    //setters
    public void setId(long id) {
        this.id = id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setRangoHorario(char rangoHorario) {
        this.rangoHorario = rangoHorario;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public void setSecretario(Secretariado secretario) {
        this.secretario = secretario;
    }

    public void setMedicamentos(ArrayList<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    //constructores
    public Cita() {

    }

    public Cita(long id, Date fecha, char rangoHorario, Time hora, Secretariado secretario, ArrayList<Medicamento> medicamentos) {
        this.id = id;
        this.fecha = fecha;
        this.rangoHorario = rangoHorario;
        this.hora = hora;
        this.secretario = secretario;
        this.medicamentos = medicamentos;
    }

    public Cita(Cita c) {
        this.id = c.id;
        this.fecha = c.fecha;
        this.rangoHorario = c.rangoHorario;
        this.hora = c.hora;
        this.secretario = c.secretario;
    }

    @Override
    public String toString() {
        return "ID: " + id + ". fecha: " + fecha + ", rangoHorario: " + rangoHorario + ", hora: " + hora + ", secretario: " + secretario + ", medicamentos recetados: " + medicamentos;
    }
    
    
//METODOS
    
    
    
    
        //Funcion para ver todas las citas//
    public static void verCitas() {
        System.out.println("Listado de citas: ");
        for (int i = 0; i < Utilidades.numCitas; i++) {
            System.out.println(Utilidades.CITAS[i]);
        }

    }
    
         /**
     * Función que se le pasa una lista ArrayList<code>Citas</code> y un
     * array de identificadores, y devuelve una sublista con los Cirujanos cuyos
     * ids coinciden con los identificadores del array en la lista
     *
     * @param lista de Citas en las que buscar
     * @param ids array de ids de Citas
     * @return ArrayList<code>Citas</code>
     */
    public static ArrayList<Cita> arrayde(ArrayList<Cita> lista, int[] ids) {
        ArrayList<Cita> ret = new ArrayList<Cita>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Cita) lista.get(j));
                    break;
                }
            }
        }
        return ret;
    }
    
    public static final ArrayList<Cita> convertir(Cita[] array) {
        ArrayList<Cita> ret = new ArrayList<Cita>();
        for (Cita i : array) {
            ret.add((Cita) i);
        }
        return ret;
    }
    
}
