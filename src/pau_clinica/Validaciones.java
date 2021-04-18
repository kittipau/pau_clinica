/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pau_clinica;

import Entidades.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author punib
 */
public class Validaciones {

    public static boolean validarId(long id) {
        return (id > 0);
    }

    public static boolean validarEntero(int id) {
        return (id > 0);
    }
    public static boolean validarImporte(double id) {
        return (id > 0);
    }

    public static boolean validarNombre(String nombre) {
        boolean ret = true;
        if (nombre.isEmpty()) {
            ret = false;
        }
        if (nombre.length() < 1 || nombre.length() > 20) {
            ret = false;
        }
        for (char c : nombre.toCharArray()) {
            if (Character.isDigit(c) || (!Character.isLetter(c) && c != ' ')) {
                ret = false;
                break;
            }
        }
        return ret;
    }

    public static boolean validarNombreDesc(String nombre) {
        boolean ret = true;
        if (nombre.isEmpty()) {
            ret = false;
        }
        if (nombre.length() < 1 || nombre.length() > 40) {
            ret = false;
        }
        return ret;
    }

    public static boolean validarNombMedicamento(String nombre) {
        boolean ret = true;
        if (nombre.isEmpty()) {
            ret = false;
        }
        if (nombre.length() < 1 || nombre.length() > 20) {
            ret = false;
        }
        for (char c : nombre.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ' && !Character.isDigit(c)) {
                ret = false;
                break;
            }
        }
        return ret;
    }

    public static boolean validarDireccion(String direccion) {
        boolean ret = true;
        if (direccion.isEmpty()) {
            ret = false;
        }
        if (direccion.length() < 1 || direccion.length() > 60) {
            ret = false;
        }
        for (char c : direccion.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ' && c != '/' && c != ',' && !Character.isDigit(c)) {
                ret = false;
                break;
            }
        }
        return ret;
    }

    public static boolean validarTexto(String texto) {
        boolean ret = true;
        if (texto.isEmpty()) {
            ret = false;
        }
        if (texto.length() < 5 || texto.length() > 150) {
            ret = false;
        }
        return ret;
    }

    public static boolean validattlfn(String tlfn) {
        boolean ret = true;
        if (tlfn.isEmpty()) {
            ret = false;
        }
        if (tlfn.length() != 9) {
            ret = false;
        }
        if (!tlfn.matches("[0-9]+")) {
            ret = false;
        }
        return ret;
    }

    public static boolean validarMetodoPago(String metodo) {
        boolean ret = true;
        if (metodo.isEmpty()) {
            ret = false;
        }

        if (!(metodo.contentEquals("Tarjeta") || metodo.contentEquals("Metálico") || metodo.contentEquals("Transferencia"))) {
            ret = false;
        }
        return ret;
    }

    public static boolean validarTlfn(String tlfn) {
        boolean ret = true;
        if (tlfn.isEmpty()) {
            ret = false;
        }
        if (tlfn.length() != 9) {
            ret = false;
        }
        for (char c : tlfn.toCharArray()) {
            if (!Character.isDigit(c)) {
                ret = false;
            }
        }

        return ret;
    }

    public static boolean validarDNI(String dni) {
        boolean ret = true;
        if (dni.isEmpty()) {
            ret = false;
        }

        if (dni.length() != 9) {
            ret = false;
        }

        if (!dni.matches("[0-9]{8}[A-Z]{1}")) {
            ret = false;
        }

        return ret;
    }

    public static boolean validarCategoria(char categoria) {
        boolean ret = true;

        if (categoria != 'A' && categoria != 'B' && categoria != 'C') {
            ret = false;
        }
        return ret;
    }

    public static boolean validarrangoHorario(char rango) {
        boolean ret = true;

        if (rango != 'M' && rango != 'm' && rango != 'T' && rango != 't') {
            ret = false;
        }
        return ret;
    }

    /**
     * Función que pide al usuario que introduzca un valor decimal por la
     * entrada estándar. Si el formato introducido no es correcto, avisa al
     * usuario y le vuelve a pedir que lo introduzca de nuevo.
     *
     * @return el valor double introducido por el usuario
     */
//    public static boolean validarDouble(double importe) {
//        importe = 0.0;
//        boolean correcto = false;
//        Scanner in;
//        do {
//            System.out.println("Introduzca un valor decimal (xx.xx)");
//            in = new Scanner(System.in, "ISO-8859-1");
//            try {
//                if (importe <= 0) {
//                    correcto = false;
//                }
//                importe = in.nextDouble();
//                correcto = true;
//            } catch (InputMismatchException ime) {
//                System.out.println("Formato introducido incorrecto.");
//                correcto = false;
//            }
//        } while (!correcto);
//        return correcto;
//    }

}
