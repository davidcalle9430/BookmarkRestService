/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidic.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plazos.findAll", query = "SELECT p FROM Plazos p"),
    @NamedQuery(name = "Plazos.findByForma", query = "SELECT p FROM Plazos p WHERE p.forma = :forma"),
    @NamedQuery(name = "Plazos.findByDescripcion", query = "SELECT p FROM Plazos p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Plazos.findByTipo", query = "SELECT p FROM Plazos p WHERE p.tipo = :tipo")})
public class Plazos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 3)
    private String forma;
    @Column(length = 100)
    private String descripcion;
    @Column(length = 1)
    private String tipo;

    public Plazos() {
    }

    public Plazos(String forma) {
        this.forma = forma;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (forma != null ? forma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plazos)) {
            return false;
        }
        Plazos other = (Plazos) object;
        if ((this.forma == null && other.forma != null) || (this.forma != null && !this.forma.equals(other.forma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Plazos[ forma=" + forma + " ]";
    }
    
}
