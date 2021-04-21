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
public class Revision extends Cita {

    private String anotacion; //<=40 caracteres alfanumericos
    private Cirugia cirugia;
    private long idCita;
    private long idCirujano;
    
    

    //getters
    public String getAnotacion() {
        return anotacion;
    }

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

    public long getIdCirujano() {
        return idCirujano;
    }

    public void setIdCirujano(long idCirujano) {
        try {
            if (Validaciones.validarId(idCirujano)) {
                this.idCirujano = idCirujano;
            } else {
                throw new Exception("Id Inválido: " + idCirujano);

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Cirugia getCirugia() {
        return cirugia;
    }
    //setters

    public void setAnotacion(String anotacion) {
        try {
            if (Validaciones.validarTexto(anotacion)) {
                this.anotacion = anotacion;
            } else {
                throw new Exception("Anotación inválida:  " + anotacion);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setCirugia(Cirugia cirugia) {
        this.cirugia = cirugia;
    }
    //constructores

    public Revision() {
        super();
    }

    public Revision(String anotacion, Cirugia cirugia, long id, Date fecha, char rangoHorario, Time hora, Secretariado secretario, ArrayList<Medicamento> medicamentos) {
        super(id, fecha, rangoHorario, hora, secretario, medicamentos);
        try {
            if (Validaciones.validarTexto(anotacion)) {
                this.anotacion = anotacion;
            } else {
                throw new Exception("Anotación inválida:  " + anotacion);
            }
            this.cirugia = cirugia;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public Revision(String anotacion, Cirugia cirugia, long id, Date fecha, char rangoHorario, Time hora, Secretariado secretario, ArrayList<Medicamento> medicamentos, long idCita, long IdCirujano) {
        super(id, fecha, rangoHorario, hora, secretario, medicamentos);
        try {
            if (Validaciones.validarTexto(anotacion)) {
                this.anotacion = anotacion;
            } else {
                throw new Exception("Anotación inválida:  " + anotacion);
            }
            this.cirugia = cirugia;
            if (Validaciones.validarId(idCita)) {
                this.idCita = idCita;
            } else {
                throw new Exception("Id Inválido: " + idCita);
            }
            if (Validaciones.validarId(idCirujano)) {
                this.idCirujano = idCirujano;
            } else {
                throw new Exception("Id Inválido: " + idCirujano);

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public Revision(String anotacion, Cirugia cirugia, Cita c, long idCita, long idCirugia) {
        super(c);
        try {
            if (Validaciones.validarTexto(anotacion)) {
                this.anotacion = anotacion;
            } else {
                throw new Exception("Anotación inválida:  " + anotacion);
            }
            this.cirugia = cirugia;
            if (Validaciones.validarId(idCita)) {
                this.idCita = idCita;
            } else {
                throw new Exception("Id Inválido: " + idCita);
            }
            if (Validaciones.validarId(idCirujano)) {
                this.idCirujano = idCirujano;
            } else {
                throw new Exception("Id Inválido: " + idCirujano);

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Revision(String anotacion, Cirugia cirugia, Cita c) {
        super(c);
        try {
            if (Validaciones.validarTexto(anotacion)) {
                this.anotacion = anotacion;
            } else {
                throw new Exception("Anotación inválida:  " + anotacion);

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Revision(Revision r) {
        try {
            if (Validaciones.validarTexto(anotacion)) {
                this.anotacion = anotacion;
            } else {
                throw new Exception("Anotación inválida:  " + anotacion);
            }
            this.cirugia = cirugia;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public String toString() {
        return "Medicamentos recetados: " + medicamentos + ", anotaciones: " + anotacion + "Cirujano encargado de la revisión: " + cirugia + "/n ID: " + id + ". fecha: " + fecha + ", rangoHorario: " + rangoHorario + ", hora: " + hora + ", secretario: " + secretario + ", medicamentos recetados: " + medicamentos;
    }

    public static Revision nuevaRevision() {
        Revision ret = new Revision();
        Scanner in = new Scanner(System.in, "UTF-8859-1");
        String anotacion = "";
        do {
            System.out.println("Introduce la anotación: ");
            anotacion = in.nextLine();
            if (!Validaciones.validarNombreDesc(anotacion)) {
                System.out.println("Anotación inválida: " + anotacion);
            }
        } while (!Validaciones.validarNombreDesc(anotacion));
        ret.setAnotacion(anotacion);

        return ret;

    }
    
     /**
     * Función que marca el orden de importación/exportación de los campos
     * @return id(PK)|fecha|rangoHorario|hora|idSecret|idTrat|idPaciente|duracion|idCita|idEnf1|idEnf2|idCiru1|idCiru2
     */
    public String data(){
        String ret;
        ret = super.id +"|"+ super.fecha +"|"+ super.rangoHorario +"|"+ super.hora +"|"+ super.idSecret +"|"+ super.idTrat +"|"+ super.idPaciente +"|"+ anotacion  +"|"+ idCita +"|"+ idCirujano;
        return ret;
    }

    public static final ArrayList<Revision> convertir(Revision[] array) {
        ArrayList<Revision> ret = new ArrayList<Revision>();
        for (Cita i : array) {
            ret.add((Revision) i);
        }
        return ret;
    }
}
