/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import static entidades.Empleado.nextIdEmpleado;
import java.util.ArrayList;
import java.util.Scanner;
import pau_clinica.Utilidades;
import pau_clinica.Validaciones;

/**
 *
 * @author punib
 */
public class Paciente {

    private long id; // >0 
    private String nombre; //<=15 caracteres alfanumericos
    private String apellido; //<=20 caracteres alfanumericos
    private String DNI; // VAL: 8 caracteres numéricos y 1 letra INVAL:!= 8 caracteres numéricos y 1 letra
    private String tlfn; // Máximo 9 caracteres numéricos
    private String direccion;// <=40 caracteres alfanumericos
    private ArrayList<Tratamiento> tratamientos = new ArrayList<Tratamiento>();
    private ArrayList<Cita> citas = new ArrayList<Cita>();
    private Historial historial;

    //getters
    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public String getTlfn() {
        return tlfn;
    }

    public String getDireccion() {
        return direccion;
    }

    public ArrayList<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public ArrayList<Cita> getCitas() {
        return citas;
    }

    public Historial getHistorial() {
        return historial;
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

    public void setDNI(String DNI) {
        try {
            if (Validaciones.validarDNI(DNI)) {
                this.DNI = DNI;
            } else {
                throw new Exception("DNI inválido: " + DNI);
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

    public void setDireccion(String direccion) {
        try {
            if (Validaciones.validarDireccion(direccion)) {
                this.direccion = direccion;
            } else {
                throw new Exception("Dirección inválida: " + tlfn);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setTratamientos(ArrayList<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }

    public void setCitas(ArrayList<Cita> citas) {
        this.citas = citas;
    }

    public void setHistorial(Historial historial) {
        this.historial = historial;
    }
    //constructores

    public Paciente() {
    }

    public Paciente(long id, String nombre, String apellido, String DNI, String tlfn, String direccion, ArrayList<Tratamiento> tratamientos, ArrayList<Cita> citas, Historial historial) {
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
            if (Validaciones.validarDNI(DNI)) {
                this.DNI = DNI;
            } else {
                throw new Exception("DNI inválido: " + DNI);
            }
            if (Validaciones.validattlfn(tlfn)) {
                this.tlfn = tlfn;
            } else {
                throw new Exception("Teléfono inválido: " + tlfn);
            }
            if (Validaciones.validarDireccion(direccion)) {
                this.direccion = direccion;
            } else {
                throw new Exception("Dirección inválida: " + tlfn);
            }

            this.historial = historial;
            this.citas = citas;
            this.tratamientos = tratamientos;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Paciente(Paciente p) {
        this.id = p.id;
        this.nombre = p.nombre;
        this.apellido = p.apellido;
        this.DNI = p.DNI;
        this.tlfn = p.tlfn;
        this.direccion = p.direccion;
        this.historial = p.historial;
        this.citas = p.citas;
        this.tratamientos = p.tratamientos;
    }

    @Override
    public String toString() {
        return "ID: " + id + ". Nombre: " + nombre + apellido + ", DNI: " + DNI + ", tlfn: " + tlfn + ", direccion: " + direccion + ". Listado de tratamientos: " + tratamientos + ", listado de citas: " + citas + ", historial: " + historial;
    }

    public static long nextIdPaciente() {
        long ret = 0;
        for (int i = 0; i < Utilidades.PACIENTES.length; i++) {
            if (Utilidades.PACIENTES[i].id > ret);
            ret = Utilidades.PACIENTES[i].id;
        }
        return ret + 1;
    }

    public static Paciente nuevoPaciente() {
        Paciente ret = new Paciente();
        Scanner in = new Scanner(System.in, "ISO-8859-1");
        long id = nextIdPaciente();
        ret.setId(id);
        String nombre = "";
        do {
            System.out.println("Introduce el nombre del paciente: ");
            nombre = in.nextLine();
            if (!Validaciones.validarNombre(nombre));
            System.out.println("El nombre introducido no es válido: " + nombre);

        } while (!Validaciones.validarNombre(nombre));
        ret.setNombre(nombre);
        String apellido = "";
        do {
            System.out.println("Introduce el apellido del paciente: ");
            apellido = in.nextLine();
            if (!Validaciones.validarNombre(apellido));
            System.out.println("El apellido introducido no es válido: " + apellido);

        } while (!Validaciones.validarNombre(apellido));
        ret.setApellido(apellido);

        String NIF = "";
        do {
            System.out.println("Introduce el NIF del paciente: ");
            NIF = in.nextLine();
            if (!Validaciones.validarDNI(NIF));
            System.out.println("El NIF introducido no es válido." + NIF);

        } while (!Validaciones.validarDNI(NIF));
        ret.setDNI(NIF);
        String tlfn = "";
        do {
            System.out.println("Introduce el teléfono del paciente: ");
            tlfn = in.nextLine();
            if (!Validaciones.validarTlfn(tlfn));
            System.out.println("El telefono introducido no es válido." + tlfn);

        } while (!Validaciones.validarTlfn(tlfn));
        ret.setTlfn(tlfn);

        String direccion = "";
        do {
            System.out.println("Introduce la direccion del paciente: ");
            direccion = in.nextLine();
            if (!Validaciones.validarDireccion(direccion));
            System.out.println("La dirección introducida no es válida." + direccion);

        } while (!Validaciones.validarDireccion(direccion));
        ret.setDireccion(direccion);

        return ret;
    }

//    private long id; // >0 
//    private String nombre; //<=15 caracteres alfanumericos
//    private String apellido; //<=20 caracteres alfanumericos
//    private String DNI; // VAL: 8 caracteres numéricos y 1 letra INVAL:!= 8 caracteres numéricos y 1 letra
//    private String tlfn; // Máximo 9 caracteres numéricos
//    private String direccion;// <=40 caracteres alfanumericos
    //Funcion para ver todos los pacientes//
    public static void verPacientes() {
        System.out.println("Listado de pacientes: ");
        for (int i = 0; i < Utilidades.numPacientes; i++) {
            System.out.println(Utilidades.PACIENTES[i]);
        }
    }

     public static void buscarPacientes(ArrayList<Paciente> pacientes) {
        Paciente buscado;
        ArrayList<Paciente> encontrados;
        Scanner in = new Scanner(System.in);
        in = new Scanner(System.in, "ISO-8859-1");
        int op = -1;
        do {
            buscado = null;
            encontrados = new ArrayList<Paciente>();

            System.out.println("Pula 1 para buscar por ID");
            System.out.println("Pulsa 2 para buscar por nombre");
            System.out.println("Pulsa 3 para buscar por NIF");
            System.out.println("Pulsa 0 para salir");
            op = in.nextInt();
            if (op < 0 || op > 3) {
                System.out.println("\n Opcion incorrecta \n");
                continue;
            }
            switch (op) {
                case 0:
                    break;
                case 1:
                    System.out.println("Introduce el id del paciente: ");
                    int idPac = in.nextInt();
                    buscado = buscarPacientePorId(idPac, pacientes);
                    if (buscado != null) {
                        System.out.println("Paciente: ");
                        System.out.println(buscado.getId() + ". " + buscado.getDNI() + ", " + buscado.getNombre() + ", " + buscado.getApellido() + ", " + buscado.getTlfn());

                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                    break;

                case 2:
                    System.out.println("Introduce el nombre del paciente: ");
                    String nombrePac = in.nextLine();
                    encontrados = buscarPacientePorNombre(nombrePac, pacientes);
                    if (encontrados.size() > 0) {
                        System.out.println("Pacientes que coincuden: ");
                        for (Paciente e : encontrados) {
                            System.out.println(buscado.getNombre() + ", " + buscado.getId() + ". " + buscado.getApellido() + ", " + buscado.getTlfn());
                        }
                    }
                    break;
                case 3:
                    System.out.println("Introduce el NIF del empleado: ");
                    String nifPac = in.nextLine();
                    encontrados = buscarPacienteporNIF(nifPac, pacientes);
                    if (encontrados.size() > 0) {
                        System.out.println("Empleados que coinciden: ");
                        for (Paciente e : pacientes) {
                            System.out.println(buscado.getDNI() + ", " + +buscado.getId() + ". " + buscado.getNombre() + ", " + buscado.getApellido() + ", " + buscado.getTlfn());
                        }
                        break;

                    }
            }

        } while (op < 0 || op > 3);
    }

    public static Paciente buscarPacientePorId(int id, ArrayList<Paciente> pacientes) {
        Paciente ret = null;
        for (Paciente e : Paciente.convertir(Utilidades.PACIENTES)) {
            if (e.getId() == id) {
                ret = e;
                break;
            }
        }
        return ret;
    }

    public static ArrayList<Paciente> buscarPacientePorNombre(String nombre, ArrayList<Paciente> pacientes) {
        ArrayList<Paciente> ret = new ArrayList<Paciente>();
        for (Paciente e : Paciente.convertir(Utilidades.PACIENTES)) {
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

    public static ArrayList<Paciente> buscarPacienteporNIF(String nif, ArrayList<Paciente> pacientes) {
        ArrayList<Paciente> ret = new ArrayList<Paciente>();
        for (Paciente e : Paciente.convertir(Utilidades.PACIENTES)) {
            if (Utilidades.removeDiacriticalMarks(e.getDNI().toLowerCase()).contains(Utilidades.removeDiacriticalMarks(nif.toLowerCase()))) {
                ret.add(e);
            }
            if (e.getDNI().toLowerCase().contains(nif.toLowerCase())) {
                if (!ret.contains(e)) {
                    ret.add(e);
                }
            }
        }
        return ret;

    }

    public static final ArrayList<Paciente> convertir(Paciente[] array) {
        ArrayList<Paciente> ret = new ArrayList<Paciente>();
        for (Paciente i : array) {
            ret.add((Paciente) i);
        }
        return ret;
    }
}
