/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pau_clinica;

import entidades.*;
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
        
        ArrayList<Alergia> alergias = Alergia.convertir(Utilidades.ALERGIAS);
        ArrayList<Cirugia> cirujanos = Cirugia.convertir(Utilidades.CIRUJANOS);
        
        System.out.println(cirujanos);
        
        boolean ret = Validaciones.validarMetodoPago("Tarjeta");
        
        
        System.out.println(cirujanos);
        Scanner in = new Scanner(System.in, "ISO-8859-1");      
        String metodoPago = "";
        do {
            System.out.println("Introduce el método de pago: ");
            metodoPago = in.nextLine();
            if (!Validaciones.validarMetodoPago(metodoPago)) {
                System.out.println("Método de pago inválido");
            }
        } while (!Validaciones.validarMetodoPago(metodoPago));
       
        
        
//        boolean resultado = Validaciones.validarDNI("7210575jj");
//        System.out.println(resultado);


// TODO code application logic here
         
        
        
        
        
//
//        //MENÚ PRINCIPAL
//        int op0 = -1, op1 = -1;
//        Scanner in = new Scanner(System.in);
//
//        do {
//            mostrarMenuPrincipal();
//            in = new Scanner(System.in, "ISO-8859-1");
//            op0 = in.nextInt();
//            if (op0 < 0 || op0 > 3) {
//                System.out.println("\n Opcion incorrecta \n");
//                continue;
//            }
//
//            switch (op0) {
//
//                case 0:
//                    break;
//                case 1:
//                    do {
//                        menuPacientes();
//                        op1 = in.nextInt();
//                        if (op1 < 0 || op1 > 4) {
//                            System.out.println("\n Opcion incorrecta \n");
//                            continue;
//                        }
//                        switch (op1) {
//                            case 0:
//                                continue;
//                            case 1:
//                                break;
//                            case 2:
//                                break;
//                            case 3:
//                                break;
//                            case 4:
//                                break;
//                        }
//
//                        break;
//                    } while (op1 < 0 || op1 > 4);
//
//                case 2:
//                    do {
//                        menuEmpleados();
//                        op1 = in.nextInt();
//                        if (op1 < 0 || op1 > 3) {
//                            System.out.println("\n Opcion incorrecta \n");
//                            continue;
//                        }
//                        switch (op1) {
//                            case 0:
//                                continue;
//                            case 1:
//                                Empleado.verEmpleados();
//                                break;
//                            case 2:
//                                Empleado.nuevoEmpleado();
//                                break;
//                            case 3:
//                               // Empleado.buscarEmpleados(empleados);
//                                break;
//                        }
//
//                        break;
//                    } while (op1 < 0 || op1 > 3);
//
//                case 3:
//                      do {
//                        menuCitas();
//                        op1 = in.nextInt();
//                        if (op1 < 0 || op1 > 3) {
//                            System.out.println("\n Opcion incorrecta \n");
//                            continue;
//                        }
//                        switch (op1) {
//                            case 0:
//                                continue;
//                            case 1:
//                                break;
//                            case 2:
//                                break;
//                            case 3:
//                                break;
//                        }
//
//                        break;
//                    } while (op1 < 0 || op1 > 3);
//            }
//
//        } while (op1 < 0 || op1 > 3);
//
//    }
//
//    private static void mostrarMenuPrincipal() {
//        System.out.println("Pulsa 1 para la gestión de pacientes.");
//        System.out.println("Pulsa 2 para la gestión de empleados.");
//        System.out.println("Pulsa 3 para la gestión de citas.");
//        System.out.println("Pulsa 0 para salir del menú.");
//    }
//
//    private static void menuPacientes() {
//        System.out.println("Pulsa 1 para ver pacientes.");
//        System.out.println("Pulsa 2 para crear un nuevo paciente.");
//        System.out.println("Pulsa 3 para buscar un paciente.");
//        System.out.println("Pulsa 4 para ver el historial de un paciente.");
//        System.out.println("Pulsa 0 para ir al menú principal.");
//    }
//
//    private static void menuEmpleados() {
//        System.out.println("Pulsa 1 para ver empleados.");
//        System.out.println("Pulsa 2 para crear un nuevo empleado.");
//        System.out.println("Pulsa 3 para buscar un empleado.");
//        System.out.println("Pulsa 0 para ir al menú principal.");
//         
//        
//    }
//
//    private static void menuCitas() {
//        System.out.println("Pulsa 1 para ver las citas.");
//        System.out.println("Pulsa 2 para crear una nueva cita.");
//        System.out.println("Pulsa 3 para buscar una cita.");
//        System.out.println("Pulsa 0 para volver al menú principal.");
    }

}
