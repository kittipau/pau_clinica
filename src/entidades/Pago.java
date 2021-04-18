/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import pau_clinica.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author punib
 */
public class Pago {

    private long id; // > 0 
    private Date fechaPago = Date.valueOf(LocalDate.now()); //// VALIDOS: Del 01/01/2000 hasta el 31/12/2100

    private double importe; // > 0 
    private String metodoPago = "tarjeta"; //VAL: “tarjeta”, “metálico”, “transferencia”
    private Cobro cobro;

    //getters
    public long getId() {
        return id;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public double getImporte() {
        return importe;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public Cobro getCobro() {
        return cobro;
    }
    //setters

    public void setId(long id) {
        try {
            if (Validaciones.validarId(id)) {
                this.id = id;
            } else {
                throw new Exception("Id Inválido: " + id);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public void setImporte(double importe) {
        try {
            if (Validaciones.validarImporte(importe)) {
                this.importe = importe;
            } else {
                throw new Exception("Importe inválido: " + importe);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setMetodoPago(String metodopago) {
        try {
            if (Validaciones.validarMetodoPago(metodopago)) {
                this.metodoPago = metodopago;
            } else {
                throw new Exception("Método de pago inválido: " + metodopago);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setCobro(Cobro cobro) {
        this.cobro = cobro;
    }
    //constructores

    public Pago() {
    }

    public Pago(long id, Date fechaPago, double importe, String metodoPago, Cobro cobro) {
        try {
            if (Validaciones.validarId(id)) {
                this.id = id;
            } else {
                throw new Exception("Id Inválido: " + id);
            }

            this.fechaPago = fechaPago;
            if (Validaciones.validarImporte(importe)) {
                this.importe = importe;
            } else {
                throw new Exception("Importe inválido: " + importe);
            }
            this.cobro = cobro;
            this.metodoPago = metodoPago;
            if (Validaciones.validarMetodoPago(metodoPago)) {
                this.metodoPago = metodoPago;
            } else {
                throw new Exception("Método de pago inválido: " + metodoPago);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


public Pago(Pago p) {
        this.id = p.id;
        this.fechaPago = p.fechaPago;
        this.importe = p.importe;
        this.cobro = p.cobro;
        this.metodoPago = p.metodoPago;
    }

    @Override
        public String toString() {
        return "ID: " + id + " Importe: " + importe + "€" + " Fecha del pago: " + fechaPago + " Método de pago " + metodoPago + ". Corresponde al cobro " + cobro;
    }

    public static long nextIdPago() {
        long ret = 0;
        for (int i = 0; i < Utilidades.PAGOS.length; i++) {
            if (Utilidades.PAGOS[i].id > ret);
            ret = Utilidades.PAGOS[i].id;
        }
        return ret + 1;
    }

    // método para introducir nuevo pago.
    public static Pago nuevoPago() {
        Pago ret = new Pago();
        Scanner in = new Scanner(System.in);

        long id = nextIdPago();
        ret.setId(id);
        Date fecha = Date.valueOf(LocalDate.now());
        ret.setFechaPago(fecha);

        double importe = -1;
        do {
            System.out.println("Introduce el importe: ");
            importe = in.nextDouble();
            if (!Validaciones.validarImporte(importe)) {
                System.out.println("Importe introducido inválido: ");
            }
        } while (!Validaciones.validarImporte(importe));
        ret.setImporte(importe);

        String metodoPago = "";
        do {
            System.out.println("Introduce el método de pago: ");
            metodoPago = in.nextLine();
            if (!Validaciones.validarMetodoPago(metodoPago)) {
                System.out.println("Método de pago inválido");
            }
        } while (!Validaciones.validarMetodoPago(metodoPago));
        ret.setMetodoPago(metodoPago);

//        long idCobro = -1;
//        Cobro.verCobros();
//        System.out.println("Introduce el id del cobro: ");
//        idCobro = in.nextLong();
//        Cobro cobro = Cobro.buscarCobroporId(idCobro, Cobro.convertir(Utilidades.COBROS));
//        ret.setCobro(cobro);
        return ret;
    }
    /**
     * Función que se le pasa una lista ArrayList<code>Pago</code> y un array de
     * identificadores, y devuelve una sublista con los Pagos cuyos ids
     * coinciden con los identificadores del array en la lista
     *
     * @param lista de Pago en las que buscar
     * @param ids array de ids de Pago
     * @return ArrayList<code>Pago</code>
     */
    public static ArrayList<Pago> arrayde(ArrayList<Pago> lista, int[] ids) {
        ArrayList<Pago> ret = new ArrayList<Pago>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Pago) lista.get(j));
                    break;
                }
            }
        }
        return ret;
    }

    /**
     * *
     * Función que convierte un array de objetos Pago en un ArrayList de objetos
     * Pago con los mismos elementos que el array.
     *
     * @param array de Pago
     * @return ArrayList de Pago
     */
    public static final ArrayList<Pago> convertir(Pago[] array) {
        ArrayList<Pago> ret = new ArrayList<Pago>();
        for (Pago i : array) {
            ret.add((Pago) i);
        }
        return ret;
    }

}
