/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import DAO.EmpleadoDAO;
import static entidades.Alergia.nextIdAlergia;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.Scanner;
import pau_clinica.Utilidades;
import pau_clinica.Validaciones;

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
            if (Validaciones.validarNombre(nombre)) {
                this.nombre = nombre;
            } else {
                throw new Exception("Nombre inválido: " + nombre);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setApellido(String apellido) {
        try {
            if (Validaciones.validarNombre(apellido)) {
                this.apellido = apellido;
            } else {
                throw new Exception("Apellido inválido: " + apellido);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setTlfn(String tlfn) {
        try {
            if (Validaciones.validattlfn(tlfn)) {
                this.tlfn = tlfn;
            } else {
                throw new Exception("Teléfono inválido: " + tlfn);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setNIF(String NIF) {
        try {
            if (Validaciones.validarDNI(NIF)) {
                this.NIF = NIF;
            } else {
                throw new Exception("NIF inválido: " + NIF);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setDireccion(String direccion) {
        try {
            if (Validaciones.validarDireccion(direccion)) {
                this.direccion = direccion;
            } else {
                throw new Exception("Dirección inválida: " + direccion);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
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
        try {
            if (Validaciones.validarId(id)) {
                this.id = id;
            } else {
                throw new Exception("Id Inválido: " + id);
            }
            if (Validaciones.validarNombre(nombre)) {
                this.nombre = nombre;
            } else {
                throw new Exception("Nombre inválido: " + nombre);
            }

            if (Validaciones.validarNombre(apellido)) {
                this.apellido = apellido;
            } else {
                throw new Exception("Apellido inválido: " + apellido);
            }
            if (Validaciones.validattlfn(tlfn)) {
                this.tlfn = tlfn;
            } else {
                throw new Exception("Teléfono inválido: " + tlfn);
            }
            if (Validaciones.validarDNI(NIF)) {
                this.NIF = NIF;
            } else {
                throw new Exception("NIF inválido: " + NIF);
            }
            if (Validaciones.validarDireccion(direccion)) {
                this.direccion = direccion;
            } else {
                throw new Exception("Dirección inválida: " + direccion);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

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
        return "ID: " + id + ". Nombre: " + nombre + " " + apellido + ", DNI: " + NIF + ", dirección " + direccion + ", Tlfn: " + tlfn;
    }

    //MÉTODO
    /**
     * Función que marca el orden de importación/exportación de los campos
     *
     * @return id(PK)|nombre|apellido|tlfn|NIF|direccion
     */
    public String data() {
        String ret;
        ret = id + "|" + nombre + "|" + apellido + "|" + tlfn + "|" + NIF + "|" + direccion;
        return ret;
    }

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
        Scanner in = new Scanner(System.in, "ISO-8859-1");
        long id = nextIdEmpleado();
        ret.setId(id);
        String nombre = "";
        do {
            System.out.println("Introduce el nombre del empleado: ");
            nombre = in.nextLine();
            if (!Validaciones.validarNombre(nombre));
            System.out.println("El nombre introducido no es válido." + nombre);

        } while (!Validaciones.validarNombre(nombre));
        ret.setNombre(nombre);
        String apellido = "";
        do {
            System.out.println("Introduce el apellido del empleado: ");
            apellido = in.nextLine();
            if (!Validaciones.validarNombre(apellido));
            System.out.println("El apellido introducido no es válido." + apellido);

        } while (!Validaciones.validarNombre(apellido));
        ret.setApellido(apellido);
        String tlfn = "";
        do {
            System.out.println("Introduce el teléfono del empleado: ");
            tlfn = in.nextLine();
            if (!Validaciones.validarTlfn(tlfn));
            System.out.println("El telefono introducido no es válido." + tlfn);

        } while (!Validaciones.validarTlfn(tlfn));
        ret.setTlfn(tlfn);
        String NIF = "";
        do {
            System.out.println("Introduce el NIF del empleado: ");
            NIF = in.nextLine();
            if (!Validaciones.validarDNI(NIF));
            System.out.println("El NIF introducido no es válido." + NIF);

        } while (!Validaciones.validarDNI(NIF));
        ret.setNIF(NIF);

        String direccion = "";
        do {
            System.out.println("Introduce la direccion del empleado: ");
            direccion = in.nextLine();
            if (!Validaciones.validarDireccion(direccion));
            System.out.println("La dirección introducida no es válida." + direccion);

        } while (!Validaciones.validarDireccion(direccion));
        ret.setDireccion(direccion);
        System.out.println("Se ha creado el empleado: " + ret);

        EmpleadoDAO edao = new EmpleadoDAO();
        boolean exito = edao.insertarEmpleado(ret);
        if (exito) {
            return ret;
        } else {
            return null;
        }
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
    /**
     * Funcion que dado el id de un empleado devuelve un archivo.dat con sus datos.
     *
     * @param idemp identificador del empleado para buscar
     * 
     * @return void
     */
     public static void exportarEmpleadoBinario(long idemp) {
        String path = "Empleado.dat";
        try {
            FileOutputStream fichero = new FileOutputStream(path, true);
            ObjectOutputStream escritor = new ObjectOutputStream(fichero);
            for (Empleado e : Utilidades.EMPLEADOS) {
                if(idemp == e.getId())
                escritor.writeObject((Empleado) e);
                escritor.flush();
            }
            escritor.close();
        } catch (FileNotFoundException e) {
            System.out.println("Se ha producido una FileNotFoundException" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Se ha producido una IOException" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Se ha producido una Exception" + e.getMessage());
        }
    }


}
