/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pau_clinica;

import ConexionBD.ConexionBD;
import entidades.*;
import dao.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author punib
 */
public class Pau_Clinica {

    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) {
        
          
            
        Connection c = ConexionBD.establecerConexion();
            
//        EmpleadoDAO edao = new EmpleadoDAO();    
//        ArrayList<Empleado> todosEmple = edao.verTodosEmpleados() ; 
//        Empleado e = Empleado.nuevoEmpleado();
    
        
        
        Scanner in = new Scanner(System.in, "ISO-8859-1");
        ArrayList<Alergia> alergias = Alergia.convertir(Utilidades.ALERGIAS);
        ArrayList<Cirugia> cirujanos = Cirugia.convertir(Utilidades.CIRUJANOS);
        ArrayList<Cita> citas = Cita.convertir(Utilidades.CITAS);
        ArrayList<Cobro> cobros = Cobro.convertir(Utilidades.COBROS);
        ArrayList<Empleado> empledos = Empleado.convertir(Utilidades.EMPLEADOS);
        ArrayList<Enfermeria> enfermeros = Enfermeria.convertir(Utilidades.ENFERMEROS);
        ArrayList<Especialidad> especialidades = Especialidad.convertir(Utilidades.ESPECIALIDADES);
        ArrayList<Historial> historiales = Historial.convertir(Utilidades.HISTORIALES);
        ArrayList<InformeGlobal> informes = InformeGlobal.convertir(Utilidades.INFORMES);
        ArrayList<Intervencion> intervenciones = Intervencion.convertir(Utilidades.INTERVENCIONES);
        ArrayList<Medicamento> medicamentos = Medicamento.convertir(Utilidades.MEDICAMENTOS);
        ArrayList<Paciente> pacientes = Paciente.convertir(Utilidades.PACIENTES);
        ArrayList<Pago> pagos = Pago.convertir(Utilidades.PAGOS);
        ArrayList<Revision> revisiones = Revision.convertir(Utilidades.REVISIONES);
        ArrayList<Secretariado> secretarios = Secretariado.convertir(Utilidades.SECRETARIOS);
        ArrayList<Tratamiento> tratamientos = Tratamiento.convertir(Utilidades.TRATAMIENTOS);

        
  
//        System.out.println(cirujanos);
//
//        boolean ret = Validaciones.validarMetodoPago("Tarjeta");
//
//        System.out.println(cirujanos);
//
//        String metodoPago = "";
//        do {
//            System.out.println("Introduce el método de pago: ");
//            metodoPago = in.nextLine();
//            if (!Validaciones.validarMetodoPago(metodoPago)) {
//                System.out.println("Método de pago inválido");
//            }
//        } while (!Validaciones.validarMetodoPago(metodoPago));
//        boolean resultado = Validaciones.validarDNI("7210575jj");
//        System.out.println(resultado);
// TODO code application logic here
        int op1 = -1;
        do {
            mostrarMenuPrincipal();
            op1 = in.nextInt();
            if (op1 < 0 || op1 > 3) {
                System.out.println("\n Opción incorrecta:");
                continue;
            }
            switch (op1) {

                case 0:
                    continue;
                case 1:
                    menuPacientes();
                    break;
                case 2:
                    menuEmpleados();
                    break;
                case 3:
                    menuCitas();
                    break;

            }

        } while (op1 < 0 || op1 > 3);

    }

    private static void mostrarMenuPrincipal() {
        System.out.println("Pulsa 1 para la gestión de pacientes.");
        System.out.println("Pulsa 2 para la gestión de empleados.");
        System.out.println("Pulsa 3 para la gestión de citas.");
        System.out.println("Pulsa 0 para salir del menú.");

    }

    private static void menuPacientes() {
        int op = -1;
        ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
        Scanner in = new Scanner(System.in, "ISO-8859-1");
        do {
            System.out.println("Pulsa 1 para ver pacientes.");
            System.out.println("Pulsa 2 para crear un nuevo paciente.");
            System.out.println("Pulsa 3 para buscar un paciente.");
            System.out.println("Pulsa 4 para ver el historial de un paciente.");
            System.out.println("Pulsa 0 salir: ");
            op = in.nextInt();
            if (op < 0 || op > 4) {
                System.out.println("\n Opción incorrecta:");
                continue;
            }

            switch (op) {
                case 0:
                    break;
                case 1:
                    Paciente.verPacientes();
                    break;
                case 2:
                    Paciente.nuevoPaciente();
                    break;
                case 3:
                    Paciente.buscarPacientes(pacientes);
                    break;
                case 4:
                    break;
            }
        } while (op < 0 || op > 4);
    }

    private static void menuEmpleados() {
        int op = -1;
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        Scanner in = new Scanner(System.in, "ISO-8859-1");
        do {
            System.out.println("Pulsa 1 para ver empleados.");
            System.out.println("Pulsa 2 para crear un nuevo empleado.");
            System.out.println("Pulsa 3 para buscar un empleado.");
            System.out.println("Pulsa 0 para ir al menú principal.");
            op = in.nextInt();
            if (op < 0 || op > 3) {
                System.out.println("\n Opción incorrecta:");
                continue;
            }

            switch (op) {
                case 0:
                    break;
                case 1:
                    Empleado.verEmpleados();
                    break;
                case 2:
                    Empleado.nuevoEmpleado();
                    break;
                case 3:
                    Empleado.buscarEmpleados(empleados);
                    break;

            }
        } while (op < 0 || op > 3);
    }

    private static void menuCitas() {
        int op = -1;
        ArrayList<Cita> citas = new ArrayList<Cita>();
        Scanner in = new Scanner(System.in, "ISO-8859-1");
        do {
            System.out.println("Pulsa 1 para ver las citas.");
            System.out.println("Pulsa 2 para crear una nueva cita.");
            System.out.println("Pulsa 3 para buscar una cita.");
            System.out.println("Pulsa 0 para volver al menú principal.");
            op = in.nextInt();
            if (op < 0 || op > 3) {
                System.out.println("\n Opción incorrecta:");
                continue;
            }
            switch (op) {
                case 0:
                    break;
                case 1:
                    Cita.verCitas();
                    break;
                case 2:
                    Cita.nuevaCita();
                    break;
                case 3:
                    Cita.buscarCita(citas);
                    break;

            }

        } while (op < 0 || op > 3);
    }
}
