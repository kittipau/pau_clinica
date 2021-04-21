/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;
import java.util.Scanner;
import pau_clinica.Utilidades;
import pau_clinica.Validaciones;

/**
 *
 * @author punib
 */
public class InformeGlobal {

    private long id; //VAL: > 0 
    private String descripcion; // min 10 caracteres, máximo 500
    private ArrayList<Secretariado> secretarios = new ArrayList<Secretariado>();

    //getters
    public long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public ArrayList<Secretariado> getSecretarios() {
        return secretarios;
    }

    //Setters
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

    public void setDescripcion(String descripcion) {
        try {
            if (Validaciones.validarTexto(descripcion)) {
                this.descripcion = descripcion;
            } else {
                throw new Exception("Descripción inválida: " + descripcion);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setSecretarios(ArrayList<Secretariado> secretarios) {
        this.secretarios = secretarios;
    }
    //constructores

    public InformeGlobal() {
    }

    public InformeGlobal(long id, String descripcion, ArrayList<Secretariado> Secretarios) {
        try {
            if (Validaciones.validarId(id)) {
                this.id = id;
            } else {
                throw new Exception("Id Inválido: " + id);
            }
            if (Validaciones.validarTexto(descripcion)) {
                this.descripcion = descripcion;
            } else {
                throw new Exception("Descripción inválida: " + descripcion);
            }
            this.secretarios = secretarios;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public InformeGlobal(InformeGlobal i) {
        this.id = i.id;
        this.descripcion = i.descripcion;
        this.secretarios = i.secretarios;
    }

    @Override
    public String toString() {
        return "ID: " + id + ". Descripcion: " + descripcion + ", Listado de secretarios=" + secretarios;
    }
    //METODOS

    public static long nextIdInforme() {
        long ret = 0;
        for (int i = 0; i < Utilidades.INFORMES.length; i++) {
            if (Utilidades.INFORMES[i].id > ret);
            ret = Utilidades.INFORMES[i].id;
        }
        return ret + 1;
    }

    public static InformeGlobal nuevoInforme() {
        InformeGlobal ret = new InformeGlobal();
        Scanner in = new Scanner(System.in, "ISO-8859-1");
        long id = nextIdInforme();
        ret.setId(id);
        String descripcion = "";
        do {
            System.out.println("Introduce la descripción: ");
            descripcion = in.nextLine();
            if (!Validaciones.validarTexto(descripcion)) {
                System.out.println("Valores incorrectos: " + descripcion);
            }
        } while (!Validaciones.validarTexto(descripcion));
        ret.setDescripcion(descripcion);

        return ret;

    }
 /**
     * Función que marca el orden de importación/exportación de los campos
     * @return id(PK)|descripción
     */
    public String data(){
        String ret;
        ret = id +"|"+ descripcion;
        return ret;
    }
    
    /**
     * Función que se le pasa una lista ArrayList<code>InformeGlobal</code> y un
     * array de identificadores, y devuelve una sublista con los InformeGlobal
     * cuyos ids coinciden con los identificadores del array en la lista
     *
     * @param lista de Cirujanos en las que buscar
     * @param ids array de ids de Cirujanos
     * @return ArrayList<code>InformeGlobal</code>
     */
    public static ArrayList<InformeGlobal> arrayde(ArrayList<InformeGlobal> lista, int[] ids) {
        ArrayList<InformeGlobal> ret = new ArrayList<InformeGlobal>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((InformeGlobal) lista.get(j));
                    break;
                }
            }
        }
        return ret;
    }

    public static final ArrayList<InformeGlobal> convertir(InformeGlobal[] array) {
        ArrayList<InformeGlobal> ret = new ArrayList<InformeGlobal>();
        for (InformeGlobal i : array) {
            ret.add((InformeGlobal) i);
        }
        return ret;
    }
}
