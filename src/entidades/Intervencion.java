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
    private long idCita;
    private long idEnf1;
    private long idEnf2;
    private long idCiru1;
    private long idCiru2;

    public long getIdCita() {
        return idCita;
    }

    public void setIdCita(long idCita) {
        try {
            if (Validaciones.validarId(idCita)) {
                this.idCita = idCita;
            } else {
                throw new Exception("Id Inválido: " + idCita);

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setIdEnf1(long idEnf1) {
        try {
            if (Validaciones.validarId(idEnf1)) {
                this.idEnf1 = idEnf1;
            } else {
                throw new Exception("Id Inválido: " + idEnf1);

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setIdEnf2(long idEnf2) {
        try {
            if (Validaciones.validarId(idEnf2)) {
                this.idEnf2 = idEnf2;
            } else {
                throw new Exception("Id Inválido: " + idEnf2);

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setIdCiru1(long idCiru1) {
        try {
            if (Validaciones.validarId(idCiru1)) {
                this.idCiru1 = idCiru1;
            } else {
                throw new Exception("Id Inválido: " + idCiru1);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setIdCiru2(long idCiru2) {
        try {
            if (Validaciones.validarId(idCiru2)) {
                this.idCiru2 = idCiru2;
            } else {
                throw new Exception("Id Inválido: " + idCiru2);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public long getIdEnf1() {
        return idEnf1;
    }

    public long getIdEnf2() {
        return idEnf2;
    }

    public long getIdCiru1() {
        return idCiru1;
    }

    public long getIdCiru2() {
        return idCiru2;
    }

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
        try {
            if (Validaciones.validarEntero(duracion)) {
                this.duracion = duracion;

            } else {
                throw new Exception("Duración inválida: " + duracion);

            }
            this.enfermeros = enfermeros;
            this.cirujanos = cirujanos;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        this.enfermeros = enfermeros;
        this.cirujanos = cirujanos;
    }

    public Intervencion(Cita c, int duracion, long idCita, long idEnf1, long IdEnf2, long IdCiru1, long IdCiru2) {
        super(c);
        try {
            if (Validaciones.validarEntero(duracion)) {
                this.duracion = duracion;

            } else {
                throw new Exception("Duración inválida: " + duracion);

            }
            if (Validaciones.validarId(idCita)) {
                this.idCita = idCita;
            } else {
                throw new Exception("Id Inválido: " + idCita);

            }
            if (Validaciones.validarId(idEnf1)) {
                this.idEnf1 = idEnf1;
            } else {
                throw new Exception("Id Inválido: " + idEnf1);

            }
            if (Validaciones.validarId(idEnf2)) {
                this.idEnf2 = idEnf2;
            } else {
                throw new Exception("Id Inválido: " + idEnf2);

            }
            if (Validaciones.validarId(idCiru1)) {
                this.idCiru1 = idCiru1;
            } else {
                throw new Exception("Id Inválido: " + idCiru1);
            }
            if (Validaciones.validarId(idCiru2)) {
                this.idCiru2 = idCiru2;
            } else {
                throw new Exception("Id Inválido: " + idCiru2);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Intervencion(Cita c, int duracion) {
        super(c);
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

    
     /**
     * Función que marca el orden de importación/exportación de los campos
     * @return id(PK)|fecha|rangoHorario|hora|idSecret|idTrat|idPaciente|duracion|idCita|idEnf1|idEnf2|idCiru1|idCiru2
     */
    public String data(){
        String ret;
        ret = super.id +"|"+ super.fecha +"|"+ super.rangoHorario +"|"+ super.hora +"|"+ super.idSecret +"|"+ super.idTrat +"|"+ super.idPaciente +"|"+ duracion  +"|"+ idCita +"|"+ idEnf1 +"|"+ idEnf2 +"|"+ idCiru1 +"|"+ idCiru2;
        return ret;
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

    public static final ArrayList<Intervencion> convertir(Intervencion[] array) {
        ArrayList<Intervencion> ret = new ArrayList<Intervencion>();
        for (Cita i : array) {
            ret.add((Intervencion) i);
        }
        return ret;
    }
}
