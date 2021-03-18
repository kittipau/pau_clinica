/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;
import pau_clinica.Utilidades;
import pau_clinica.Validaciones;

/**
 *
 * @author punib
 */
public class Cobro {

    private long id; // > 0 
    private double importe; // > 0 
    private Date FechaFin;
    //VAL: Todos los valores comprendidos entre el 01/01/2000 hasta el 31/12/2100
    //INVAL: Letras y caracteres especiales excepto “/"

    //getters
    public long getId() {
        return id;
    }

    public double getImporte() {
        return importe;
    }

    public Date getFechaFin() {
        return FechaFin;
    }

//setters
    public void setId(long id) {
        this.id = id;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public void setFechaFin(Date FechaFin) {
        this.FechaFin = FechaFin;
    }

    //Constructores
    public Cobro() {
    }

    public Cobro(long id, double importe, Date FechaFin) {
        this.id = id;
        this.importe = importe;
        this.FechaFin = FechaFin;
    }

    public Cobro(Cobro c) {

        this.id = c.id;
        this.importe = c.importe;
        this.FechaFin = c.FechaFin;
    }

    @Override
    public String toString() {
        return "Cobro{" + "id=" + id + ", importe=" + importe + ", FechaFin=" + FechaFin + '}';
    }

    //METODO
    public static Cobro nuevoCobro() {
        Cobro ret = new Cobro();
        Scanner in = new Scanner(System.in);
        long id = nextIdCobro();
        ret.setId(id);
        System.out.println("Introduce la fecha fin del cobro: ");
        Date fecha = Utilidades.Fecha.nuevaFecha().conversorFecha();
        ret.setFechaFin(fecha);
        double importe = -1;
        do {
            System.out.println("Introduce el importe del cobro: ");
            importe = in.nextDouble();
            if (!Validaciones.validarDouble(importe)) {
                System.out.println("Importe introducido inválido.");
            }
        } while (!Validaciones.validarDouble(importe));
        ret.setImporte(importe);

        return ret;
    }

    public static long nextIdCobro() {
        long ret = 0;
        for (int i = 0; i < Utilidades.COBROS.length; i++) {
            if (Utilidades.COBROS[i].id > ret);
            ret = Utilidades.COBROS[i].id;
        }
        return ret + 1;
    }

    /**
     * Función que se le pasa una lista ArrayList<code>Cobro</code> y un array
     * de identificadores, y devuelve una sublista con los Cirujanos cuyos ids
     * coinciden con los identificadores del array en la lista
     *
     * @param lista de Cobros en las que buscar
     * @param ids array de ids de Cobros
     * @return ArrayList<code>Cobro</code>
     */
    public static ArrayList<Cobro> arrayde(ArrayList<Cobro> lista, int[] ids) {
        ArrayList<Cobro> ret = new ArrayList<Cobro>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Cobro) lista.get(j));
                    break;
                }
            }
        }
        return ret;
    }

    public static final ArrayList<Cobro> convertir(Cobro[] array) {
        ArrayList<Cobro> ret = new ArrayList<Cobro>();
        for (Cobro i : array) {
            ret.add((Cobro) i);
        }
        return ret;
    }

    //Funcion para ver todos los cobros//
    public static void verCobros() {
        System.out.println("Listado de cobros: ");
        for (int i = 0; i < Utilidades.numCobros; i++) {
            System.out.println(Utilidades.COBROS[i]);
        }

    }
}
