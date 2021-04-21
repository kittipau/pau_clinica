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
public class Enfermeria extends Empleado {

    private char categoria; //válidos "A", "B", "C"
    private long idEmp;

    //getters
    public char getCategoria() {
        return categoria;
    }

    //setters
    public void setCategoria(char categoria) {

        try {
            if (Validaciones.validarCategoria(categoria)) {
                this.categoria = categoria;
            } else {
                throw new Exception("Categoría inválida: " + categoria);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
 public long getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(long idEmp) {
        try {
            if (Validaciones.validarId(idEmp)) {
                this.idEmp = idEmp;
            } else {
                throw new Exception("Id Inválido: " + idEmp);

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    //constructores
    public Enfermeria() {
        super();
    }

    public Enfermeria(char categoria, long id, String nombre, String apellido, String tlfn, String NIF, String direccion) {
        super(id, nombre, apellido, tlfn, NIF, direccion);
        try {
            if (Validaciones.validarCategoria(categoria)) {
                this.categoria = categoria;
            } else {
                throw new Exception("Categoría inválida: " + categoria);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public Enfermeria(Enfermeria e) {
        super(e);
        try {
            if (Validaciones.validarCategoria(categoria)) {
                this.categoria = categoria;
            } else {
                throw new Exception("Categoría inválida: " + categoria);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Enfermeria(Empleado e, char categoria) {
        super(e);
        try {
            if (Validaciones.validarCategoria(categoria)) {
                this.categoria = categoria;
            } else {
                throw new Exception("Categoría inválida: " + categoria);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public String toString() {
        return "ID: " + id + ". Nombre: " + nombre + " " + apellido + ", DNI: " + NIF + ", dirección " + direccion + ", Tlfn: " + tlfn + " , categoria: " + categoria;
    }

    public static Enfermeria nuevoEnfermero() {
        Empleado empleado = Empleado.nuevoEmpleado();
        Scanner in = new Scanner(System.in, "ISO-8859-1");
        char categoria = 't';
        do {
            System.out.println("Introduce la categoría 'A', 'B', 'C': ");
            categoria = in.nextLine().charAt(0);
            if (!Validaciones.validarCategoria(categoria)) {
                System.out.println("Valor incorrecto: " + categoria);
            }
        } while (!Validaciones.validarCategoria(categoria));
        Enfermeria ret = new Enfermeria(empleado, categoria);
        return ret;

    }
    
     /**
     * Función que marca el orden de importación/exportación de los campos
     * @return id(PK)|nombre|apellido|tlfn|NIF|direccion|categoria
     */
    public String data(){
        String ret;
        ret = super.id + "|" + super.nombre + "|" + super.apellido + "|" + super.tlfn + "|" + super.NIF + "|" + super.direccion + "|" + categoria+"|"+idEmp;
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
    public static ArrayList<Enfermeria> arraydeEnfermeria(ArrayList<Enfermeria> lista, int[] ids) {
        ArrayList<Enfermeria> ret = new ArrayList<Enfermeria>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Enfermeria) lista.get(j));
                    break;
                }
            }
        }
        return ret;
    }

    public static final ArrayList<Enfermeria> convertir(Enfermeria[] array) {
        ArrayList<Enfermeria> ret = new ArrayList<Enfermeria>();
        for (Enfermeria i : array) {
            ret.add((Enfermeria) i);
        }
        return ret;
    }

}
