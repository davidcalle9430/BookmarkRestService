/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidic.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author david
 */
@Embeddable
public class ImportacionesPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(nullable = false)
    private int consec;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(nullable = false)
    private double codigo;
    @Basic(optional = false)
    @Column(nullable = false)
    private double ndoc;

    public ImportacionesPK() {
    }

    public ImportacionesPK(int consec, Date fecha, double codigo, double ndoc) {
        this.consec = consec;
        this.fecha = fecha;
        this.codigo = codigo;
        this.ndoc = ndoc;
    }

    public int getConsec() {
        return consec;
    }

    public void setConsec(int consec) {
        this.consec = consec;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getCodigo() {
        return codigo;
    }

    public void setCodigo(double codigo) {
        this.codigo = codigo;
    }

    public double getNdoc() {
        return ndoc;
    }

    public void setNdoc(double ndoc) {
        this.ndoc = ndoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) consec;
        hash += (fecha != null ? fecha.hashCode() : 0);
        hash += (int) codigo;
        hash += (int) ndoc;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImportacionesPK)) {
            return false;
        }
        ImportacionesPK other = (ImportacionesPK) object;
        if (this.consec != other.consec) {
            return false;
        }
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.ndoc != other.ndoc) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.ImportacionesPK[ consec=" + consec + ", fecha=" + fecha + ", codigo=" + codigo + ", ndoc=" + ndoc + " ]";
    }
    
}
