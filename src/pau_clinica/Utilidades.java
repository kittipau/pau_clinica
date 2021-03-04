/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pau_clinica;

import entidades.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.Normalizer;
import java.time.LocalTime;

/**
 *
 * @author punib
 */
public class Utilidades {

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss");

    public static final Cobro COBROS[] = {
        new Cobro(001, 110, Date.valueOf(LocalDate.parse("22/12/2020", dateFormatter))),
        new Cobro(002, 300, Date.valueOf(LocalDate.parse("04/01/2021", dateFormatter))),
        new Cobro(003, 250.50, Date.valueOf(LocalDate.parse("10/01/2021", dateFormatter))),
        new Cobro(005, 300, Date.valueOf(LocalDate.parse("10/01/2021", dateFormatter))),
        new Cobro(006, 250.50, Date.valueOf(LocalDate.parse("13/01/2021", dateFormatter))),
        new Cobro(007, 180.5, Date.valueOf(LocalDate.parse("15/01/2021", dateFormatter))),
        new Cobro(010, 70, Date.valueOf(LocalDate.parse("23/01/2021", dateFormatter)))
    };

    public static final int numCobros = COBROS.length;

    public static final Pago PAGOS[] = {
        new Pago(100, Date.valueOf(LocalDate.parse("23/12/2020", dateFormatter)), 160, "tarjeta", COBROS[0]),
        new Pago(101, Date.valueOf(LocalDate.parse("27/12/2020", dateFormatter)), 70, "metálico", COBROS[1]),
        new Pago(102, Date.valueOf(LocalDate.parse("31/12/2020", dateFormatter)), 55., "tarjeta", COBROS[2]),
        new Pago(103, Date.valueOf(LocalDate.parse("31/12/2020", dateFormatter)), 55, "tarjeta", COBROS[0]),
        new Pago(104, Date.valueOf(LocalDate.parse("31/12/2020", dateFormatter)), 66, "transferencia", COBROS[3])
    };

    public static final int numPagos = PAGOS.length;

    public static final Empleado EMPLEADOS[] = {
        new Empleado(01, "Manolo", "Garcia", "649678821", "72598327C", "C/Menendez Pelayo"),
        new Empleado(02, "Carlos", "Martinez", "649673821", "72598327N", "C/Venancio Bosco"),
        new Empleado(03, "David", "Lopez", "659678821", "73598327E", "C/Bajada el Chorrillo"),
        new Empleado(04, "Hector", "Setien", "67789451", "7465372J", "C/vargas, 13"),
        new Empleado(06, "Sofia", "Santisteban", "649673821", "78566327R", "Barrio Llatazos"),
        new Empleado(07, "Nerea", "Gonzalez", "666777888", "72598327N", "C/Ignacio estus"),
        new Empleado(10, "Sara", "Rodriguez", "999888333", "72598327E", "C/Venancio Bosco"),};
    public static final int numEmpleados = EMPLEADOS.length;

    public static final Enfermeria ENFERMEROS[] = {
        //Empleado e, ArrayList<Especialidad> especialidades
        new Enfermeria(EMPLEADOS[1], 'A'),
        new Enfermeria(EMPLEADOS[2], 'B'),
        new Enfermeria(EMPLEADOS[5], 'C'),
        new Enfermeria(EMPLEADOS[9], 'C')
    };
    public static final int numEnfermerias = ENFERMEROS.length;

    public static final Especialidad ESPECIALIDADES[] = {
        new Especialidad(1, "Odontopediatra", new ArrayList<Cirugia>()),
        new Especialidad(2, "Endodoncista", new ArrayList<Cirugia>()),
        new Especialidad(3, "Ortodoncistas", new ArrayList<Cirugia>()),
        new Especialidad(4, "Cirujano maxilofacial", new ArrayList<Cirugia>()),
        new Especialidad(5, "Periodoncista", new ArrayList<Cirugia>())
    };
    public static final int numEspecialidades = ESPECIALIDADES.length;

    public static final Cirugia CIRUJANOS[] = {
        //Empleado e, ArrayList<Especialidad> especialidades
        new Cirugia(EMPLEADOS[0], Especialidad.arrayde(Especialidad.convertir(ESPECIALIDADES), new int[]{2, 5})),
        new Cirugia(EMPLEADOS[7], Especialidad.arrayde(Especialidad.convertir(ESPECIALIDADES), new int[]{1, 3, 5})),
        new Cirugia(EMPLEADOS[8], Especialidad.arrayde(Especialidad.convertir(ESPECIALIDADES), new int[]{2, 4, 1}))
    };
    public static final int numCirujanos = CIRUJANOS.length;

    public static final Secretariado[] SECRETARIOS = {
        //int experiencia, Empleado e, ArrayList<InformeGlobal> informes        
        new Secretariado(2, EMPLEADOS[3], new ArrayList<InformeGlobal>()),
        new Secretariado(3, EMPLEADOS[4], new ArrayList<InformeGlobal>()),
        new Secretariado(6, EMPLEADOS[6], new ArrayList<InformeGlobal>())
    };
    public static final int numSecretarios = SECRETARIOS.length;

    public static final InformeGlobal INFORMES[] = {
        //long id, String descripcion, ArrayList<Secretariado> Secretarios

        new InformeGlobal(1, "Extracción muela 37", Secretariado.arrayde(Secretariado.convertir(SECRETARIOS), new int[]{2})),
        new InformeGlobal(7, "Revisión rutania + limpieza buscal", Secretariado.arrayde(Secretariado.convertir(SECRETARIOS), new int[]{2, 3})),
        new InformeGlobal(13, "Cirugía de elevación de seno maxilar ", Secretariado.arrayde(Secretariado.convertir(SECRETARIOS), new int[]{1, 2})),
        new InformeGlobal(21, "Revisión y ajuste ortodoncia", Secretariado.arrayde(Secretariado.convertir(SECRETARIOS), new int[]{3})),
        new InformeGlobal(23, "Extracciones muelas juicio ", Secretariado.arrayde(Secretariado.convertir(SECRETARIOS), new int[]{1, 3})),};
    public static final int numInformeGlobal = INFORMES.length;

    public static final Cita CITAS[] = {
        //long id, Date fecha, char rangoHorario, Time hora, Secretariado secretario
        new Cita(001, Date.valueOf(LocalDate.parse("22/12/2020", dateFormatter)), 'M', Time.valueOf(LocalTime.parse("08:35:00", timeFormatter)), SECRETARIOS[1]),
        new Cita(002, Date.valueOf(LocalDate.parse("22/12/2020", dateFormatter)), 'T', Time.valueOf(LocalTime.parse("16:15:00", timeFormatter)), SECRETARIOS[1]),
        new Cita(003, Date.valueOf(LocalDate.parse("25/12/2020", dateFormatter)), 'M', Time.valueOf(LocalTime.parse("09:30:00", timeFormatter)), SECRETARIOS[1]),
        new Cita(004, Date.valueOf(LocalDate.parse("27/12/2020", dateFormatter)), 'M', Time.valueOf(LocalTime.parse("09:30:00", timeFormatter)), SECRETARIOS[1]),
        new Cita(005, Date.valueOf(LocalDate.parse("29/12/2020", dateFormatter)), 'M', Time.valueOf(LocalTime.parse("11:30:00", timeFormatter)), SECRETARIOS[1]),
        new Cita(006, Date.valueOf(LocalDate.parse("30/12/2020", dateFormatter)), 'T', Time.valueOf(LocalTime.parse("18:45:00", timeFormatter)), SECRETARIOS[1]),};
    
    public static final int numCitas = CITAS.length;

    public static final Tratamiento TRATAMIENTOS[] = { //long id, String nombre, Date fechaInicio, boolean consentimiento, Cobro cobro, InformeGlobal informeGlobal, ArrayList<Cita> citas
    //new Tratamiento (3, "dolor de muela", Date.valueOf(LocalDate.parse("22/12/2020", dateFormatter)), 'Y', COBROS [0], INFORMES [0], Arraylist cita)
    //          new Tratamiento (8, "empaste", Date.valueOf(LocalDate.parse("22/12/2020", dateFormatter)), Y, COBROS [0], INFORMES [0], Arraylist cita)
    //          new Tratamiento (1, "extraccion", Date.valueOf(LocalDate.parse("22/12/2020", dateFormatter)), N, COBROS [0], INFORMES [0], Arraylist cita)
    };
    public static final int numTratmamiento = TRATAMIENTOS.length;

    //fecha
    public static class Fecha {

        private int anio;
        private int mes;
        private int dia;

        public Fecha() {
            Date hoy = Date.valueOf(LocalDate.now());
        }

        public Fecha(int y, int m, int d) {
            this.anio = y;
            this.mes = m;
            this.dia = d;
        }

        public Date conversorFecha() {
            java.sql.Date ret = new Date(this.anio, this.mes, this.dia);
            return ret;
        }

        public static Fecha nuevaFecha() {
            Fecha ret = new Fecha();
            Scanner in = new Scanner(System.in);
            int d = 0;
            do {
                System.out.println("Día: ");
                d = in.nextInt();
            } while (d <= 0 || d > 31);
            int m = 0;
            do {
                System.out.println("Mes: ");
                d = in.nextInt();
            } while (m <= 0 || m > 12);

            int y = 0;
            do {
                System.out.println("Año: ");
                d = in.nextInt();
            } while (d <= 2000);

            return ret;

        }

        //hora
        public static class hora {

            private int hora;
            private int minuto;
            private int segundo;

            public hora() {
                Time hoy = Time.valueOf(LocalTime.now());
            }

            public hora(int a, int b, int c) {
                this.hora = a;
                this.minuto = b;
                this.segundo = c;
            }

            public Time conversorFecha() {
                java.sql.Time ret = new Time(this.hora, this.minuto, this.segundo);
                return ret;
            }

            /*hora =calendario.get(Calendar.HOUR_OF_DAY);
           minutos = calendario.get(Calendar.MINUTE);
           segundos = calendario.get(Calendar.SECOND);
    }*/
        }

        //metodos para hacer validaciones
        public static boolean contieneDigitos(String nombre) {
            boolean ret = true;

            return ret;
        }

        public static boolean contieneCaracteresEspeciales(String nombre) {
            boolean ret = true;

            return ret;
        }

    }
