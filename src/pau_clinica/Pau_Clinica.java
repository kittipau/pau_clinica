/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pau_clinica;

import entidades.Empleado;
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
        // TODO code application logic here
        Empleado e1 = new Empleado();
        //Empleado(long id, String nombre, String apellido, String tlfn, String NIF, String direccion) {
        Scanner in;
        int id;
        boolean valido = false;
        do {
            in = new Scanner(System.in);
            id = 12; //in.nextInt();

            if (!Empleado.validarId(id)) {
                System.out.println("Id incorrecto!");
            } else {
                valido = true;
            }
        } while (!valido);
        Empleado e2 = new Empleado(id, "Laura", "suarez", "69982726", "72149276L", "Calle mayor, 3");
    }

}
