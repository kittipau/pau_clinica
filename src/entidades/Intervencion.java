/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;
import pau_clinica.Validaciones;

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
        try {
            if (Validaciones.validarEntero(duracion)) {
                this.duracion = duracion;

            } else {
                throw new Exception("Duración inválida: " + duracion);

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

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

    public Intervencion(Cita c, int duracion) {
        super(c);
        this.duracion = duracion;
    }

    public Intervencion(int duracion, long id, Date fecha, char rangoHorario, Time hora, Secretariado secretario, ArrayList<Medicamento> medicamentos) {
        super(id, fecha, rangoHorario, hora, secretario, medicamentos);
        this.duracion = duracion;
        this.cirujanos = cirujanos;
        this.enfermeros = enfermeros;
        this.medicamentos = medicamentos;
    }

    public Intervencion(Intervencion i) {
        super(i);
        this.duracion = i.duracion;
        this.cirujanos = i.cirujanos;
        this.enfermeros = i.enfermeros;
    }

    @Override
    public String toString() {
        return "Duración de la intervención: " + duracion + "minutos,  enfermeros: " + enfermeros + ", cirujanos: " + cirujanos + "/n ID: " + id + ". fecha: " + fecha + ", rangoHorario: " + rangoHorario + ", hora: " + hora + ", secretario: " + secretario + ", medicamentos recetados: " + medicamentos;
    }

    public static Intervencion nuevaIntervencion() {
        Cita cita = Cita.nuevaCita();
        Scanner in = new Scanner(System.in, "ISO-8859-1");
        int duracion = -1;
        do {
            System.out.println("Introduce la duración de la intervención: ");
            duracion = in.nextInt();
            if (!Validaciones.validarEntero(duracion)) {
                System.out.println("Valor incorrecto: " + duracion);
            }
        } while (!Validaciones.validarEntero(duracion));
        Intervencion ret = new Intervencion(cita, duracion);
        return ret;

    }
}
