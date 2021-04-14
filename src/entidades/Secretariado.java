/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;
import java.util.Scanner;
import pau_clinica.Validaciones;

/**
 *
 * @author punib
 */
public class Secretariado extends Empleado {

    private int experiencia; // >= 0
    private ArrayList<InformeGlobal> informes = new ArrayList<InformeGlobal>();

    //getters
    public int getExperiencia() {
        return experiencia;
    }

    public ArrayList<InformeGlobal> getInformes() {
        return informes;
    }

    public long getId() {
        return id;
    }

    //setters
    public void setExperiencia(int experiencia) {
        try {
            if (Validaciones.validarEntero(experiencia)) {
                this.experiencia = experiencia;

            } else {
                throw new Exception("Experiencia inválida: " + experiencia);

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setInformes(ArrayList<InformeGlobal> informes) {
        this.informes = informes;
    }
    //constructores

    public Secretariado() {
        super();
    }

    public Secretariado(int experiencia) {
        this.experiencia = experiencia;
    }

    public Secretariado(int experiencia, long id, String nombre, String apellido, String tlfn, String NIF, String direccion, ArrayList<InformeGlobal> informes) {
        super(id, nombre, apellido, tlfn, NIF, direccion);
        this.experiencia = experiencia;
        this.informes = informes;
    }

    public Secretariado(int experiencia, Empleado e, ArrayList<InformeGlobal> informes) {
        super(e);
        this.experiencia = experiencia;
        this.informes = informes;
    }

    public Secretariado(Secretariado s) {
        this.NIF = s.NIF;
        this.apellido = s.apellido;
        this.direccion = s.direccion;
        this.experiencia = s.experiencia;
        this.id = s.id;
        this.informes = s.informes;
        this.nombre = s.nombre;
        this.tlfn = s.tlfn;
    }

    public Secretariado(Empleado e, int experiencia, ArrayList<InformeGlobal> informes) {
        super(e);
        this.experiencia = experiencia;
        this.informes = informes;
    }

    public Secretariado(Empleado e, int experiencia) {
        super(e);
        this.experiencia = experiencia;

    }

    @Override
    public String toString() {
        return "ID: " + id + ". Nombre: " + nombre + " " + apellido + ", DNI: " + NIF + ", dirección " + direccion + ", Tlfn: " + tlfn + "años de experiencia: " + experiencia + "Listado de informes: " + informes;
    }

    public static Secretariado nuevoSecretario() {
        int experiencia = -1;
        Scanner in = new Scanner(System.in, "UTF-8859-1");
        do {
            System.out.println("Introduce la experiencia: ");
            experiencia = in.nextInt();
            if (!Validaciones.validarEntero(experiencia)) {
                System.out.println("Experiencia inválida: ");
            }

        } while (!Validaciones.validarEntero(experiencia));

        Empleado empleado = Empleado.nuevoEmpleado();
        Secretariado ret = new Secretariado(empleado, experiencia);
        return ret;
    }

    /**
     * Función que se le pasa una lista ArrayList<code>Cirujano</code> y un
     * array de identificadores, y devuelve una sublista con los Cirujanos cuyos
     * ids coinciden con los identificadores del array en la lista
     *
     * @param lista de Cirujanos en las que buscar
     * @param ids array de ids de Cirujanos
     * @return ArrayList<code>Cirujano</code>
     */
    public static ArrayList<Secretariado> arraydeSecretarios(ArrayList<Secretariado> lista, int[] ids) {
        ArrayList<Secretariado> ret = new ArrayList<Secretariado>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Secretariado) lista.get(j));
                    break;
                }
            }
        }
        return ret;
    }

    public static final ArrayList<Secretariado> convertir(Secretariado[] array) {
        ArrayList<Secretariado> ret = new ArrayList<Secretariado>();
        for (Secretariado i : array) {
            ret.add((Secretariado) i);
        }
        return ret;
    }

}
