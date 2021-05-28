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
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static final EmpleadoEnt EMPLEADOS[] = {
        new EmpleadoEnt(1, "Sara", "Garcia", "649678821", "72598327C", "C/Menendez Pelayo"),
        new EmpleadoEnt(2, "Carlos", "Martinez", "649673821", "72598327N", "C/Venancio Bosco"),
        new EmpleadoEnt(3, "David", "Lopez", "659678821", "73598327E", "C/Bajada el Chorrillo"),
        new EmpleadoEnt(4, "Hector", "Setien", "677894451", "74653724J", "C/vargas"),
        new EmpleadoEnt(5, "Sofia", "Santisteban", "649673821", "78566327R", "Barrio Llatazos"),
        new EmpleadoEnt(6, "Nerea", "Gonzalez", "666777888", "72598327N", "C/Ignacio estus"),
        new EmpleadoEnt(7, "Jose", "Rodriguez", "607598547", "72256715E", "C/Venancio Bosco"),
        new EmpleadoEnt(8, "Bella", "Rodriguez", "607598453", "72958632T", "C/belen"),
        new EmpleadoEnt(9, "Mónica", "Perez", "690783036", "85632014F", "C/San ignacio"),
        new EmpleadoEnt(10, "Pedro", "Setien", "664589674", "01257895G", "C/Javier Echevarría"),};
    public static final int numEmpleados = EMPLEADOS.length;

    public static final Enfermeria ENFERMEROS[] = {
        new Enfermeria(EMPLEADOS[1], 'A'),
        new Enfermeria(EMPLEADOS[2], 'B'),
        new Enfermeria(EMPLEADOS[5], 'C'),
        new Enfermeria(EMPLEADOS[9], 'C')
    };
    public static final int numEnfermerias = ENFERMEROS.length;

    public static final Secretariado[] SECRETARIOS = {
        //int experiencia, EmpleadoEnt e, ArrayList<InformeGlobal> informes        
        new Secretariado(2, EMPLEADOS[3], new ArrayList<InformeGlobal>()),
        new Secretariado(3, EMPLEADOS[4], new ArrayList<InformeGlobal>()),
        new Secretariado(6, EMPLEADOS[6], new ArrayList<InformeGlobal>())
    };
    public static final int numSecretarios = SECRETARIOS.length;

    public static final Especialidad ESPECIALIDADES[] = {
        new Especialidad(1, "Odontopediatra", new ArrayList<Cirugia>()),
        new Especialidad(2, "Endodoncista", new ArrayList<Cirugia>()),
        new Especialidad(3, "Ortodoncistas", new ArrayList<Cirugia>()),
        new Especialidad(4, "Cirujano", new ArrayList<Cirugia>()),
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

    public static final Cobro COBROS[] = {
        new Cobro(1, 110, Date.valueOf(LocalDate.parse("22/12/2020", dateFormatter))),
        new Cobro(2, 300, Date.valueOf(LocalDate.parse("04/01/2021", dateFormatter))),
        new Cobro(3, 250.50, Date.valueOf(LocalDate.parse("10/01/2021", dateFormatter))),
        new Cobro(4, 300, Date.valueOf(LocalDate.parse("10/01/2021", dateFormatter))),
        new Cobro(5, 250.50, Date.valueOf(LocalDate.parse("13/01/2021", dateFormatter))),
        new Cobro(6, 180.5, Date.valueOf(LocalDate.parse("15/01/2021", dateFormatter))),
        new Cobro(7, 70, Date.valueOf(LocalDate.parse("23/01/2021", dateFormatter))),
        new Cobro(8, 60, Date.valueOf(LocalDate.parse("22/12/2020", dateFormatter))),
        new Cobro(9, 50, Date.valueOf(LocalDate.parse("22/12/2020", dateFormatter)))
    };

    public static final int numCobros = COBROS.length;

    public static final Pago PAGOS[] = {
        new Pago(100, Date.valueOf(LocalDate.parse("23/12/2020", dateFormatter)), 160, "Tarjeta", COBROS[0]),
        new Pago(101, Date.valueOf(LocalDate.parse("27/12/2020", dateFormatter)), 70, "Metálico", COBROS[1]),
        new Pago(102, Date.valueOf(LocalDate.parse("31/12/2020", dateFormatter)), 55, "Tarjeta", COBROS[2]),
        new Pago(103, Date.valueOf(LocalDate.parse("31/12/2020", dateFormatter)), 55, "Tarjeta", COBROS[0]),
        new Pago(104, Date.valueOf(LocalDate.parse("31/12/2020", dateFormatter)), 66, "Transferencia", COBROS[3])
    };

    public static final int numPagos = PAGOS.length;

    public static final InformeGlobal INFORMES[] = {
        //long id, String descripcion, ArrayList<Secretariado> Secretarios

        new InformeGlobal(1, "Extracción muela 37", Secretariado.arraydeSecretarios(Secretariado.convertir(SECRETARIOS), new int[]{2})),
        new InformeGlobal(7, "Revisión rutania + limpieza buscal", Secretariado.arraydeSecretarios(Secretariado.convertir(SECRETARIOS), new int[]{2, 3})),
        new InformeGlobal(13, "Cirugía de elevación de seno maxilar ", Secretariado.arraydeSecretarios(Secretariado.convertir(SECRETARIOS), new int[]{1, 2})),
        new InformeGlobal(21, "Revisión y ajuste ortodoncia", Secretariado.arraydeSecretarios(Secretariado.convertir(SECRETARIOS), new int[]{3})),
        new InformeGlobal(23, "Extracciones muelas juicio ", Secretariado.arraydeSecretarios(Secretariado.convertir(SECRETARIOS), new int[]{1, 3})),};
    public static final int numInformeGlobal = INFORMES.length;

   

    public static Medicamento MEDICAMENTOS[] = {
        //  long id, String nombre, String principioActivo, int dosismax, ArrayList<Cita> citas
        new Medicamento(1, "Paracetamol", "Paracetamol", 1000, new ArrayList<Cita>()),
        new Medicamento(2, "Spidifen", "Ibuprofeno", 1000, new ArrayList<Cita>()),
        new Medicamento(3, "Paracetamol", "Paracetamol", 1000, new ArrayList<Cita>()),
        new Medicamento(4, "Paracetamol", "Paracetamol", 1000, new ArrayList<Cita>()),
        new Medicamento(5, "Paracetamol", "Paracetamol", 1000, new ArrayList<Cita>())};
    public static final int numMedicamentos = MEDICAMENTOS.length;

     public static final Alergia ALERGIAS[] = {
        //long id, String nombre, ArrayList<Historial> historiales, medicamentos
        new Alergia(1, "amoxicilina", new ArrayList<Historial>(), MEDICAMENTOS[1]),
        new Alergia(2, "latex", new ArrayList<Historial>(), MEDICAMENTOS[2]),
        new Alergia(3, "metronidazol", new ArrayList<Historial>(), MEDICAMENTOS[0]),
        new Alergia(4, "espiramicina", new ArrayList<Historial>(), MEDICAMENTOS[3]),
        new Alergia(5, "ibuprofeno", new ArrayList<Historial>(), MEDICAMENTOS[1])};

    public static final int numAlergias = ALERGIAS.length;

    public static final Historial HISTORIALES[] = {
        //long historial, String descripcion, ArrayList<Alergia> alergias
        new Historial(1, " ", Alergia.arrayde(Alergia.convertir(ALERGIAS), new int[]{0})),
        new Historial(2, " ", Alergia.arrayde(Alergia.convertir(ALERGIAS), new int[]{1})),
        new Historial(3, " ", Alergia.arrayde(Alergia.convertir(ALERGIAS), new int[]{0})),
        new Historial(5, " ", Alergia.arrayde(Alergia.convertir(ALERGIAS), new int[]{0})),
        new Historial(6, " ", Alergia.arrayde(Alergia.convertir(ALERGIAS), new int[]{0})),
        new Historial(7, " ", Alergia.arrayde(Alergia.convertir(ALERGIAS), new int[]{2, 4})),
        new Historial(8, " ", Alergia.arrayde(Alergia.convertir(ALERGIAS), new int[]{3})),
        new Historial(9, " ", Alergia.arrayde(Alergia.convertir(ALERGIAS), new int[]{5}))};

    public static final int numHistoriales = HISTORIALES.length;
    public static final Cita CITAS[] = {
        //long id, Date fecha, char rangoHorario, Time hora, Secretariado secretario
        new Cita(1, Date.valueOf(LocalDate.parse("22/09/2020", dateFormatter)), 'M', Time.valueOf(LocalTime.parse("08:35:00", timeFormatter)), SECRETARIOS[0], Medicamento.arrayde(Medicamento.convertir(MEDICAMENTOS), new int[]{1})),
        new Cita(2, Date.valueOf(LocalDate.parse("29/09/2020", dateFormatter)), 'T', Time.valueOf(LocalTime.parse("16:15:00", timeFormatter)), SECRETARIOS[0], Medicamento.arrayde(Medicamento.convertir(MEDICAMENTOS), new int[]{3})),
        new Cita(3, Date.valueOf(LocalDate.parse("14/10/2020", dateFormatter)), 'T', Time.valueOf(LocalTime.parse("16:15:00", timeFormatter)), SECRETARIOS[1], Medicamento.arrayde(Medicamento.convertir(MEDICAMENTOS), new int[]{4})),
        new Cita(4, Date.valueOf(LocalDate.parse("01/10/2020", dateFormatter)), 'M', Time.valueOf(LocalTime.parse("09:30:00", timeFormatter)), SECRETARIOS[0], Medicamento.arrayde(Medicamento.convertir(MEDICAMENTOS), new int[]{1,3})),
        new Cita(5, Date.valueOf(LocalDate.parse("13/10/2020", dateFormatter)), 'M', Time.valueOf(LocalTime.parse("11:30:00", timeFormatter)), SECRETARIOS[1], Medicamento.arrayde(Medicamento.convertir(MEDICAMENTOS), new int[]{1})),
        new Cita(6, Date.valueOf(LocalDate.parse("20/10/2020", dateFormatter)), 'T', Time.valueOf(LocalTime.parse("18:45:00", timeFormatter)), SECRETARIOS[2], Medicamento.arrayde(Medicamento.convertir(MEDICAMENTOS), new int[]{3})),
        new Cita(7, Date.valueOf(LocalDate.parse("30/10/2020", dateFormatter)), 'T', Time.valueOf(LocalTime.parse("18:45:00", timeFormatter)), SECRETARIOS[2], Medicamento.arrayde(Medicamento.convertir(MEDICAMENTOS), new int[]{1})),
        new Cita(8, Date.valueOf(LocalDate.parse("25/11/2020", dateFormatter)), 'T', Time.valueOf(LocalTime.parse("18:45:00", timeFormatter)), SECRETARIOS[1], Medicamento.arrayde(Medicamento.convertir(MEDICAMENTOS), new int[]{2})),
        new Cita(9, Date.valueOf(LocalDate.parse("01/12/2020", dateFormatter)), 'T', Time.valueOf(LocalTime.parse("18:45:00", timeFormatter)), SECRETARIOS[2], Medicamento.arrayde(Medicamento.convertir(MEDICAMENTOS), new int[]{2})),
        new Cita(10, Date.valueOf(LocalDate.parse("06/12/2020", dateFormatter)), 'T', Time.valueOf(LocalTime.parse("18:45:00", timeFormatter)), SECRETARIOS[0], Medicamento.arrayde(Medicamento.convertir(MEDICAMENTOS), new int[]{1})),
        new Cita(11, Date.valueOf(LocalDate.parse("30/11/2020", dateFormatter)), 'T', Time.valueOf(LocalTime.parse("18:45:00", timeFormatter)), SECRETARIOS[2], Medicamento.arrayde(Medicamento.convertir(MEDICAMENTOS), new int[]{3})),
        new Cita(12, Date.valueOf(LocalDate.parse("30/12/2020", dateFormatter)), 'T', Time.valueOf(LocalTime.parse("18:45:00", timeFormatter)), SECRETARIOS[0], Medicamento.arrayde(Medicamento.convertir(MEDICAMENTOS), new int[]{2})),
        new Cita(13, Date.valueOf(LocalDate.parse("30/12/2020", dateFormatter)), 'T', Time.valueOf(LocalTime.parse("18:45:00", timeFormatter)), SECRETARIOS[2], Medicamento.arrayde(Medicamento.convertir(MEDICAMENTOS), new int[]{1})),};

    public static final int numCitas = CITAS.length;

    public static final Tratamiento TRATAMIENTOS[] = {
        new Tratamiento(1, "Revisión + empaste", Date.valueOf(LocalDate.parse("22/09/2020", dateFormatter)), true, COBROS[1], INFORMES[1], Cita.arrayde(Cita.convertir(CITAS), new int[]{1})),
        new Tratamiento(2, "Limpieza + blanqueamiento", Date.valueOf(LocalDate.parse("29/09/2020", dateFormatter)), true, COBROS[1], INFORMES[1], Cita.arrayde(Cita.convertir(CITAS), new int[]{2, 3})),
        new Tratamiento(3, "Limpieza + empaste", Date.valueOf(LocalDate.parse("01/10/2020", dateFormatter)), true, COBROS[1], INFORMES[1], Cita.arrayde(Cita.convertir(CITAS), new int[]{4})),
        new Tratamiento(4, "Endodoncia", Date.valueOf(LocalDate.parse("13/10/2020", dateFormatter)), true, COBROS[1], INFORMES[1], Cita.arrayde(Cita.convertir(CITAS), new int[]{5})),
        new Tratamiento(5, "Extracción", Date.valueOf(LocalDate.parse("20/10/2020", dateFormatter)), true, COBROS[1], INFORMES[1], Cita.arrayde(Cita.convertir(CITAS), new int[]{6})),
        new Tratamiento(6, "Revision periódica", Date.valueOf(LocalDate.parse("30/10/2020", dateFormatter)), true, COBROS[1], INFORMES[1], Cita.arrayde(Cita.convertir(CITAS), new int[]{7})),
        new Tratamiento(7, "Implante", Date.valueOf(LocalDate.parse("25/11/2020", dateFormatter)), true, COBROS[1], INFORMES[1], Cita.arrayde(Cita.convertir(CITAS), new int[]{8, 9, 10})),
        new Tratamiento(8, "Ortodoncia", Date.valueOf(LocalDate.parse("30/11/2020", dateFormatter)), true, COBROS[1], INFORMES[1], Cita.arrayde(Cita.convertir(CITAS), new int[]{11, 12})),
        new Tratamiento(9, "Ortodoncia", Date.valueOf(LocalDate.parse("12/12/2020", dateFormatter)), true, COBROS[1], INFORMES[1], Cita.arrayde(Cita.convertir(CITAS), new int[]{13}))};

    public static final int numTratmamiento = TRATAMIENTOS.length;

    public static final Intervencion INTERVENCIONES[] = {
        //Cita c, int duracion, ArrayList<Enfermeria> enfermeros, ArrayList<Cirugia> cirujanos

        new Intervencion(CITAS[0], 35, Enfermeria.arraydeEnfermeria(Enfermeria.convertir(ENFERMEROS), new int[]{0,1}), Cirugia.arraydeCirugia(Cirugia.convertir(CIRUJANOS), new int[]{0})),
        new Intervencion(CITAS[1], 35, Enfermeria.arraydeEnfermeria(Enfermeria.convertir(ENFERMEROS), new int[]{0,2}), Cirugia.arraydeCirugia(Cirugia.convertir(CIRUJANOS), new int[]{1})),
        new Intervencion(CITAS[2], 35, Enfermeria.arraydeEnfermeria(Enfermeria.convertir(ENFERMEROS), new int[]{1,2}), Cirugia.arraydeCirugia(Cirugia.convertir(CIRUJANOS), new int[]{1})),
        new Intervencion(CITAS[5], 35, Enfermeria.arraydeEnfermeria(Enfermeria.convertir(ENFERMEROS), new int[]{0,2}), Cirugia.arraydeCirugia(Cirugia.convertir(CIRUJANOS), new int[]{1})),
        new Intervencion(CITAS[7], 35, Enfermeria.arraydeEnfermeria(Enfermeria.convertir(ENFERMEROS), new int[]{1,2}), Cirugia.arraydeCirugia(Cirugia.convertir(CIRUJANOS), new int[]{0})),
        new Intervencion(CITAS[8], 35, Enfermeria.arraydeEnfermeria(Enfermeria.convertir(ENFERMEROS), new int[]{0,2}), Cirugia.arraydeCirugia(Cirugia.convertir(CIRUJANOS), new int[]{2})),
        new Intervencion(CITAS[11], 35, Enfermeria.arraydeEnfermeria(Enfermeria.convertir(ENFERMEROS), new int[]{0,1}), Cirugia.arraydeCirugia(Cirugia.convertir(CIRUJANOS), new int[]{2})),
         };
    public static final int numIntervencion = INTERVENCIONES.length;

    public static final Revision REVISIONES[] = {
        //String anotacion, Cirugia cirugia, Cita c
        new Revision("Nada a resaltar", CIRUJANOS[0], CITAS[3]),
        new Revision("Nada a resaltar", CIRUJANOS[1], CITAS[4]),
        new Revision("Nada a resaltar", CIRUJANOS[0], CITAS[6]),
        new Revision("Nada a resaltar", CIRUJANOS[2], CITAS[9]),
        new Revision("Nada a resaltar", CIRUJANOS[1], CITAS[10]),
        new Revision("Nada a resaltar", CIRUJANOS[2], CITAS[12]),};

    public static final Paciente PACIENTES[] = {
        //long id, String nombre, String apellido, String DNI, String tlfn, String direccion, ArrayList<Tratamiento> tratamientos, ArrayList<Cita> citas, Historial historial
        new Paciente(1, "Susana", "Menendez", "22740599S", "942678544", "Barrio Llatazos, 13", Tratamiento.arrayde(Tratamiento.convertir(TRATAMIENTOS), new int[]{1}), Cita.arrayde(Cita.convertir(CITAS), new int[]{1, 3}), HISTORIALES[1]),
        new Paciente(2, "Jorge", "Lorenzo", "57896354T", "635498745", "B/ Lavapies, 79", Tratamiento.arrayde(Tratamiento.convertir(TRATAMIENTOS), new int[]{2}), Cita.arrayde(Cita.convertir(CITAS), new int[]{1, 3}), HISTORIALES[1]),
        new Paciente(3, "Elsa", "Oslé", "22475599F", "942689657", "C/ Julio Urquijo,33", Tratamiento.arrayde(Tratamiento.convertir(TRATAMIENTOS), new int[]{3}), Cita.arrayde(Cita.convertir(CITAS), new int[]{1, 3}), HISTORIALES[1]),
        new Paciente(4, "Eder", "Aurrere", "72698534S", "944653298", "C/ Dr Areilza, 3", Tratamiento.arrayde(Tratamiento.convertir(TRATAMIENTOS), new int[]{4}), Cita.arrayde(Cita.convertir(CITAS), new int[]{1, 3}), HISTORIALES[1]),
        new Paciente(5, "Miguel", "Sainz", "75698532T", "607659842", "Avda/ Sabino Arana, 9", Tratamiento.arrayde(Tratamiento.convertir(TRATAMIENTOS), new int[]{5}), Cita.arrayde(Cita.convertir(CITAS), new int[]{1, 3}), HISTORIALES[1]),
        new Paciente(6, "Pablo", "Diez", "12365479E", "699536874", "C/ julio mendoza, 66", Tratamiento.arrayde(Tratamiento.convertir(TRATAMIENTOS), new int[]{6}), Cita.arrayde(Cita.convertir(CITAS), new int[]{1, 3}), HISTORIALES[1]),
        new Paciente(7, "Ana", "Vazquez", "63259874S", "657945365", "C/ Santander, 1", Tratamiento.arrayde(Tratamiento.convertir(TRATAMIENTOS), new int[]{7}), Cita.arrayde(Cita.convertir(CITAS), new int[]{1, 3}), HISTORIALES[1]),
        new Paciente(8, "Hugo", "De Miguel", "42369741F", "698745385", "C/ republica de perú, 12", Tratamiento.arrayde(Tratamiento.convertir(TRATAMIENTOS), new int[]{8}), Cita.arrayde(Cita.convertir(CITAS), new int[]{1, 3}), HISTORIALES[1]),
        new Paciente(9, "Daniel", "Garcia", "36598756I", "663987541", "C/ Diego Lopez de Haro, 12", Tratamiento.arrayde(Tratamiento.convertir(TRATAMIENTOS), new int[]{9}), Cita.arrayde(Cita.convertir(CITAS), new int[]{1, 3}), HISTORIALES[1]),};
    public static final int numPacientes = PACIENTES.length;

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

        public int getAnio() {
            return anio;
        }

        public void setAnio(int anio) {
            this.anio = anio;
        }

        public int getMes() {
            return mes;
        }

        public void setMes(int mes) {
            this.mes = mes;
        }

        public int getDia() {
            return dia;
        }

        public void setDia(int dia) {
            this.dia = dia;
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
            ret.setDia(d);
            int m = 0;
            do {
                System.out.println("Mes: ");
                m = in.nextInt();
            } while (m <= 0 || m > 12);
            ret.setMes(m);
            int y = 0;
            do {
                System.out.println("Año: ");
                y = in.nextInt();
            } while (y <= 2000);
            ret.setAnio(y);
            return ret;

        }
    }

    //hora
    public static class Hora {

        private int hora;
        private int minuto;
        private int segundo;

        public int getHora() {
            return hora;
        }

        public void setHora(int hora) {
            this.hora = hora;
        }

        public int getMinuto() {
            return minuto;
        }

        public void setMinuto(int minuto) {
            this.minuto = minuto;
        }

        public int getSegundo() {
            return segundo;
        }

        public void setSegundo(int segundo) {
            this.segundo = segundo;
        }

        public Hora() {
            Time hoy = Time.valueOf(LocalTime.now());
        }

        public Hora(int h, int m, int s) {
            this.hora = h;
            this.minuto = m;
            this.segundo = s;
        }

        public Time conversorHora() {
            java.sql.Time ret = new Time(this.hora, this.minuto, this.segundo);
            return ret;
        }

        public static Hora nuevaHora() {
            Hora ret = new Hora();
            Scanner in = new Scanner(System.in);
            int h = 0;
            do {
                System.out.println("Hora: ");
                h = in.nextInt();
            } while (h <= 0 || h > 23);
            ret.setHora(h);
            int m = 0;
            do {
                System.out.println("Minutos: ");
                m = in.nextInt();
            } while (m <= 0 || m > 59);
            ret.setHora(m);
            int s = 0;
            do {
                System.out.println("Segundos: ");
                s = in.nextInt();
            } while (s <= 59);
            ret.setHora(s);
            return ret;

        }
    }
    
     public static String removeDiacriticalMarks(String string) {
        //Form.NFC acepta ñ y distingue las tildes en español
        return Normalizer.normalize(string, Normalizer.Form.NFC)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");}

     
     
}
