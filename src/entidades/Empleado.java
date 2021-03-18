/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import static entidades.Alergia.nextIdAlergia;
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.Scanner;
import pau_clinica.Utilidades;

/**
 *
 * @author punib
 */
public class Empleado {

    protected long id; // <0 
    protected String nombre; // Máximo 20 caracteres alfanuméricos
    protected String apellido; // Máximo 20 caracteres alfanuméricos
    protected String tlfn; // Máximo 9 caracteres numéricos
    protected String NIF; // VAL: 8 caracteres numéricos y 1 letra INVAL:!= 8 caracteres numéricos y 1 letra
    protected String direccion; // Máximo 30 caracteres alfanuméricos

    public Empleado() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTlfn(String tlfn) {
        this.tlfn = tlfn;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTlfn() {
        return tlfn;
    }

    public String getNIF() {
        return NIF;
    }

    public String getDireccion() {
        return direccion;
    }

    public Empleado(long id, String nombre, String apellido, String tlfn, String NIF, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tlfn = tlfn;
        this.NIF = NIF;
        this.direccion = direccion;
    }

    public Empleado(Empleado e) {
        this.id = e.id;
        this.nombre = e.nombre;
        this.apellido = e.apellido;
        this.tlfn = e.tlfn;
        this.NIF = e.NIF;
        this.direccion = e.direccion;
    }

    @Override
    public String toString() {
        return   "ID: " + id + ". Nombre: " + nombre +" " + apellido + ", DNI: " + NIF+ ", dirección " + direccion+ ", Tlfn: " + tlfn ;
    }

    //MÉTODO
    /**
     * Función que se le pasa una lista ArrayList<code>Empleado</code> y un
     * array de identificadores, y devuelve una sublista con los Empleados cuyos
     * ids coinciden con los identificadores del array en la lista
     *
     * @param lista de Cirujanos en las que buscar
     * @param ids array de ids de Empleados
     * @return ArrayList<code>Empleados</code>
     */
    //METODO QUE DEVUELVE AUTOMATICAMENTE EL SIGUIENTE ID
    public static long nextIdEmpleado() {
        long ret = 0;
        for (int i = 0; i < Utilidades.EMPLEADOS.length; i++) {
            if (Utilidades.EMPLEADOS[i].id > ret);
            ret = Utilidades.EMPLEADOS[i].id;
        }
        return ret + 1;

    }

    public static Empleado nuevoEmpleado() {
        Empleado ret = new Empleado();
        Scanner in = new Scanner(System.in);
        long id = nextIdAlergia();
        System.out.println("Introduce el nombre: ");
        String nombre = in.nextLine();
        ret.setNombre(nombre);
        System.out.println("Introduce el apellido: ");
        String apellido = in.nextLine();
        ret.setNombre(apellido);
        System.out.println("Introduce el NIF: ");
        String NIF = in.nextLine();
        ret.setNIF(NIF);
        System.out.println("Introduce el teléfono: ");
        String telefono = in.nextLine();
        ret.setTlfn(telefono);
        System.out.println("Introduce la dirección: ");
        String direccion = in.nextLine();
        ret.setDireccion(direccion);

        return ret;

    }

    public static ArrayList<Empleado> arrayde(ArrayList<Empleado> lista, int[] ids) {
        ArrayList<Empleado> ret = new ArrayList<Empleado>();
        for (int i = 0; i < ids.length; i++) {
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getId() == ids[i]) {
                    ret.add((Empleado) lista.get(j));
                    break;
                }
            }
        }
        return ret;
    }

    public static final ArrayList<Empleado> convertir(Empleado[] array) {
        ArrayList<Empleado> ret = new ArrayList<Empleado>();
        for (Empleado i : array) {
            ret.add((Empleado) i);
        }
        return ret;
    }

    //Funcion para ver todos los Empleados//
    public static void verEmpleados() {
        System.out.println("Listado de empleados: ");
        for (int i = 0; i < Utilidades.numEmpleados; i++) {
            System.out.println(Utilidades.EMPLEADOS[i]);
        }
    }

    //funciones para BUSCAR empleados//
    public static void buscarEmpleados(ArrayList<Empleado> empleados) {
        Empleado buscado;
        ArrayList<Empleado> encontrados;
        Scanner in = new Scanner(System.in);
        in = new Scanner(System.in, "ISO-8859-1");
        int op = -1;
        do {
            buscado = null;
            encontrados = new ArrayList<Empleado>();

            System.out.println("Pula 1 para buscar por ID");
            System.out.println("Pulsa 2 para buscar por nombre");
            System.out.println("Pulsa 3 para buscar por NIF");
            System.out.println("Pulsa 0 para volver al menú principal");
            op = in.nextInt();
            if (op < 0 || op > 3) {
                System.out.println("\n Opcion incorrecta \n");
                continue;
            }
            switch (op) {
                case 0:
                    continue;
                case 1:
                    System.out.println("Introduce el id del empleado: ");
                    int idEmp = in.nextInt();
                    buscado = buscarEmpleadoPorId(idEmp, empleados);
                    if (buscado != null) {
                        System.out.println("Empleado: ");
                        System.out.println(buscado.getId() + ". " + buscado.getNIF() + ", " + buscado.getNombre() + ", " + buscado.getApellido() + ", " + buscado.getTlfn());

                    } else {
                        System.out.println("Empleado no encontrado.");
                    }
                    break;

                case 2:
                    System.out.println("Introduce el nombre del empleado: ");
                    String nombreEmp = in.nextLine();
                    encontrados = buscarEmpleadoPorNombre(nombreEmp, empleados);
                    if (encontrados.size() > 0) {
                        System.out.println("Empleados que coincuden: ");
                        for (Empleado e : encontrados) {
                            System.out.println(buscado.getNombre() + ", " + buscado.getId() + ". " + buscado.getApellido() + ", " + buscado.getTlfn());
                        }
                    }
                    break;
                case 3:
                    System.out.println("Introduce el NIF del empleado: ");
                    String nifemp = in.nextLine();
                    encontrados = buscarEmpleadoPorNIF(nifemp, empleados);
                    if (encontrados.size() > 0) {
                        System.out.println("Empleados que coinciden: ");
                        for (Empleado e : encontrados) {
                            System.out.println(buscado.getNIF() + ", " + +buscado.getId() + ". " + buscado.getNombre() + ", " + buscado.getApellido() + ", " + buscado.getTlfn());
                        }
                        break;

                    }
            }

        } while (op < 0 || op > 3);
    }

    public static Empleado buscarEmpleadoPorId(int id, ArrayList<Empleado> empleados) {
        Empleado ret = null;
        for (Empleado e : Empleado.convertir(Utilidades.EMPLEADOS)) {
            if (e.getId() == id) {
                ret = e;
                break;
            }
        }
        return ret;
    }

    public static ArrayList<Empleado> buscarEmpleadoPorNombre(String nombre, ArrayList<Empleado> empleados) {
        ArrayList<Empleado> ret = new ArrayList<Empleado>();
        for (Empleado e : Empleado.convertir(Utilidades.EMPLEADOS)) {
            if (Utilidades.removeDiacriticalMarks(e.getNombre().toLowerCase()).contains(Utilidades.removeDiacriticalMarks(nombre.toLowerCase()))) {
                ret.add(e);
            }
            if (e.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                if (!ret.contains(e)) {
                    ret.add(e);
                }
            }
        }
        return ret;
    }

    public static ArrayList<Empleado> buscarEmpleadoPorNIF(String nif, ArrayList<Empleado> empleados) {
        ArrayList<Empleado> ret = new ArrayList<Empleado>();
        for (Empleado e : Empleado.convertir(Utilidades.EMPLEADOS)) {
            if (Utilidades.removeDiacriticalMarks(e.getNIF().toLowerCase()).contains(Utilidades.removeDiacriticalMarks(nif.toLowerCase()))) {
                ret.add(e);
            }
            if (e.getNIF().toLowerCase().contains(nif.toLowerCase())) {
                if (!ret.contains(e)) {
                    ret.add(e);
                }
            }
        }
        return ret;

    }

}
