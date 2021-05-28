/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author punib
 */
@Entity
@Table(name = "alergia", catalog = "pauclinica", schema = "")
@NamedQueries({
    @NamedQuery(name = "Alergia.findAll", query = "SELECT a FROM Alergia a"),
    @NamedQuery(name = "Alergia.findById", query = "SELECT a FROM Alergia a WHERE a.id = :id"),
    @NamedQuery(name = "Alergia.findByNombre", query = "SELECT a FROM Alergia a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Alergia.findByIdMed", query = "SELECT a FROM Alergia a WHERE a.idMed = :idMed")})
public class Alergia implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Short id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "idMed")
    private short idMed;

    public Alergia() {
    }

    public Alergia(Short id) {
        this.id = id;
    }

    public Alergia(Short id, String nombre, short idMed) {
        this.id = id;
        this.nombre = nombre;
        this.idMed = idMed;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        Short oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public short getIdMed() {
        return idMed;
    }

    public void setIdMed(short idMed) {
        short oldIdMed = this.idMed;
        this.idMed = idMed;
        changeSupport.firePropertyChange("idMed", oldIdMed, idMed);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alergia)) {
            return false;
        }
        Alergia other = (Alergia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vista.Alergia[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
