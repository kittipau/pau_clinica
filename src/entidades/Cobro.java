/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;

/**
 *
 * @author punib
 */
public class Cobro {
    private long id; // > 0 
    private double importe; // > 0 
    private Date FechaFin; 
    //VAL: Todos los valores comprendidos entre el 01/01/2000 hasta el 31/12/2100
    //INVAL: Letras y caracteres especiales excepto “/"

    //getters

    public long getId() {
        return id;
    }

    public double getImporte() {
        return importe;
    }

    public Date getFechaFin() {
        return FechaFin;
    }
    
//setters

    public void setId(long id) {
        this.id = id;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public void setFechaFin(Date FechaFin) {
        this.FechaFin = FechaFin;
    }
    
    //Constructores

    public Cobro() {
    }

    public Cobro(long id, double importe, Date FechaFin) {
        this.id = id;
        this.importe = importe;
        this.FechaFin = FechaFin;
    }
    
    public Cobro (Cobro c){
        
        this.id = c.id;
        this.importe = c.importe;
        this.FechaFin = c.FechaFin;
    }
    
    
}
