/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pau_clinica;

import entidades.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.Normalizer;

/**
 *
 * @author punib
 */
public class Utilidades {

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    
     
    
    public static final Cobro COBROS[] = {
        new Cobro(001, 110, Date.valueOf(LocalDate.parse("22/12/2020", dateFormatter))),
        new Cobro(002, 300, Date.valueOf(LocalDate.parse("04/01/2021", dateFormatter))),
        new Cobro(003, 250.50, Date.valueOf(LocalDate.parse("10/01/2021", dateFormatter))),
        new Cobro(005, 300, Date.valueOf(LocalDate.parse("10/01/2021", dateFormatter))),
        new Cobro(006, 250.50, Date.valueOf(LocalDate.parse("13/01/2021", dateFormatter))),
        new Cobro(007, 180.5, Date.valueOf(LocalDate.parse("15/01/2021", dateFormatter))),
        new Cobro(010, 70, Date.valueOf(LocalDate.parse("23/01/2021", dateFormatter)))};

    public static final int numCobros = COBROS.length;
    
    public static final Pago PAGOS[] = {
        new Pago(100, Date.valueOf(LocalDate.parse("23/12/2020", dateFormatter)), 160, "tarjeta", COBROS[0]),
        new Pago(101, Date.valueOf(LocalDate.parse("27/12/2020", dateFormatter)), 70, "metálico", COBROS[1]),
        new Pago(102, Date.valueOf(LocalDate.parse("31/12/2020", dateFormatter)), 55, "tarjeta", COBROS[2]),
        new Pago(103, Date.valueOf(LocalDate.parse("31/12/2020", dateFormatter)), 55, "tarjeta", COBROS[0]),
        new Pago(104, Date.valueOf(LocalDate.parse("31/12/2020", dateFormatter)), 66, "transferencia", COBROS[3])};

    public static final int numPagos = PAGOS.length;
   

}
