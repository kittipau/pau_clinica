/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author punib
 */
public class Revision extends Cita{
    private String anotacion; //<=40 caracteres alfanumericos
    private Cirugia cirugia;
    
    //getters

    public String getAnotacion() {
        return anotacion;
    }

    public Cirugia getCirugia() {
        return cirugia;
    }
    //setters

    public void setAnotacion(String anotacion) {
        this.anotacion = anotacion;
    }

    public void setCirugia(Cirugia cirugia) {
        this.cirugia = cirugia;
    }
    //constructores

    public Revision() {
        super();
    }

    public Revision(String anotacion, Cirugia cirugia, long id, Date fecha, char rangoHorario, Time hora, Secretariado secretario) {
        super(id, fecha, rangoHorario, hora, secretario);
        this.anotacion = anotacion;
        this.cirugia = cirugia;
    }

    public Revision(String anotacion, Cirugia cirugia, Cita c) {
        super(c);
        this.anotacion = anotacion;
        this.cirugia = cirugia;
    }
    public Revision(Revision r){
        this.anotacion=r.anotacion;
        this.cirugia=r.cirugia;
        
    }
    
    
}
