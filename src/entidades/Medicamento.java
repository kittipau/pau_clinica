/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import static entidades.InformeGlobal.nextIdInforme;
import java.util.ArrayList;
import java.util.Scanner;
import pau_clinica.Utilidades;
import pau_clinica.Validaciones;

/**
 *
 * @author punib
 */
public class Medicamento {

    private long id; // >0
    private String nombre; //Máximo 20 caracteres alfanuméricos
    private String principioActivo; //Máximo 20 caracteres alfanuméricos
    private int dosismax; // >0 en mg
    private ArrayList<Cita> citas = new ArrayList<Cita>();

    //Getters
    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrincipioActivo() {
        return principioActivo;
    }

    public int getDosismax() {
        return dosismax;
    }

    public ArrayList<Cita> getCitas() {
        return citas;
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

    public void setNombre(String nombre) {
        try {
            if (Validaciones.validarNombMedicamento(nombre)) {
                this.nombre = nombre;
            } else {
                throw new Exception("Nombre inválido: " + nombre);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setPrincipioActivo(String principioActivo) {
        try {
            if (Validaciones.validarNombMedicamento(principioActivo)) {
                this.principioActivo = principioActivo;
            } else {
                throw new Exception("Principio activo inválido: " + principioActivo);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setDosismax(int dosismax) {
        try {
            if (Validaciones.validarEntero(dosismax)) {
                this.dosismax = dosismax;
            } else {
                throw new Exception("Dósis inválida: " + dosismax);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void setCitas(ArrayList<Cita> citas) {
        this.citas = citas;
    }
    //constructores

    public Medicamento() {
    }

    public Medicamento(long id, String nombre, String principioActivo, int dosismax, ArrayList<Cita> citas) {
        try {
            if (Validaciones.validarId(id)) {
                this.id = id;
            } else {
                throw new Exception("Id Inválido: " + id);

            }
            if (Validaciones.validarNombMedicamento(nombre)) {
                this.nombre = nombre;
            } else {
                throw new Exception("Nombre inválido: " + nombre);
            }
            if (Validaciones.validarNombMedicamento(principioActivo)) {
                this.principioActivo = principioActivo;
            } else {
                throw new Exception("Principio activo inválido: " + principioActivo);
            }
            if (Validaciones.validarEntero(dosismax)) {
                this.dosismax = dosismax;
            } else {
                throw new Exception("Dósis inválida: " + dosismax);
            }
            this.citas = citas;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Medicamento(Medicamento m) {
        this.id = m.id;
        this.nombre = m.nombre;
        this.principioActivo = m.principioActivo;
        this.dosismax = m.dosismax;
        this.citas = m.citas;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", nombre: " + nombre + ", principio activo: " + principioActivo + ", dosis máxima=" + dosismax + "mg.";
    }

    public static long nextIdMedicamento() {
        long ret = 0;
        for (int i = 0; i < Utilidades.MEDICAMENTOS.length; i++) {
            if (Utilidades.MEDICAMENTOS[i].id > ret);
            ret = Utilidades.MEDICAMENTOS[i].id;
        }
        return ret + 1;
    }

    public static Medicamento nuevoMedicamento() {
        Medicamento ret = new Medicamento();
        Scanner in = new Scanner(System.in, "ISO-8859-1");
        long id = nextIdMedicamento();
        ret.setId(id);

        String nombre = "";
        do {
            System.out.println("Introduce el nombre del medicamento: ");
            nombre = in.nextLine();
            if (!Validaciones.validarNombMedicamento(nombre));
            System.out.println("El nombre introducido no es válido: " + nombre);
        } while (!Validaciones.validarNombre(nombre));
        ret.setNombre(nombre);
        String principio = "";
        do {
            System.out.println("Introduce el nombre del medicamento: ");
            principio = in.nextLine();
            if (!Validaciones.validarNombMedicamento(principio));
            System.out.println("El principio activo introducido no es válido: " + nombre);
        } while (!Validaciones.validarNombMedicamento(principio));
        ret.setPrincipioActivo(principio);
        int dosis = -1;
        do {
            System.out.println("Introduce la dósis máxima: ");
            dosis = in.nextInt();
            if (!Validaciones.validarEntero(dosis));
            System.out.println("La dósis no es válida: " + dosis);
        } while (!Validaciones.validarEntero(dosis));
        ret.setDosismax(dosis);

        return ret;
    }

//         private long id; // >0
//    private String nombre; //Máximo 20 caracteres alfanuméricos
//    private String principioActivo; //Máximo 20 caracteres alfanuméricos
//    private int dosismax; // >0 en mg
    /**
     * Función que se le pasa una lista ArrayList<code>Medicamento</code> y un
     * array de identificadores, y devuelve una sublista con los Medicamento
     * cuyos ids coinciden con los identificadores del array en la lista
     *
     * @param lista de Medicamento en las que buscar
     * @param ids array de ids de Medicamentos
     * @return ArrayList<code>Medicamento</code>
     */
    public static ArrayList<Medicamento> arrayde(ArrayList<Medicamento> lista, int[] ids) {
        ArrayList<Medicamento> ret = new ArrayList<Medicamento>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Medicamento) lista.get(j));
                    break;
                }
            }
        }
        return ret;

    }

    public static final ArrayList<Medicamento> convertir(Medicamento[] array) {
        ArrayList<Medicamento> ret = new ArrayList<Medicamento>();
        for (Medicamento i : array) {
            ret.add((Medicamento) i);
        }
        return ret;
    }
}
