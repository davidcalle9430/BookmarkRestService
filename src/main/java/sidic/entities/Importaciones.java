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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@XmlRootElement
@IdClass(ImportacionesPK.class)
public class Importaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    //@EmbeddedId
    //protected ImportacionesPK importacionesPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private int consec;
    
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private double codigo;
    
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private double ndoc;
    
    @Column(precision = 22)
    private Double cantidad;
    @Column(precision = 22)
    private Double costojm;
    @Column(precision = 22)
    private Double costoim;
    @Column(length = 3)
    private String documento;
    @Column(precision = 22)
    private Double precio;

    public Importaciones() {
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


    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getCostojm() {
        return costojm;
    }

    public void setCostojm(Double costojm) {
        this.costojm = costojm;
    }

    public Double getCostoim() {
        return costoim;
    }

    public void setCostoim(Double costoim) {
        this.costoim = costoim;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cantidad == null) ? 0 : cantidad.hashCode());
		long temp;
		temp = Double.doubleToLongBits(codigo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + consec;
		result = prime * result + ((costoim == null) ? 0 : costoim.hashCode());
		result = prime * result + ((costojm == null) ? 0 : costojm.hashCode());
		result = prime * result + ((documento == null) ? 0 : documento.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		temp = Double.doubleToLongBits(ndoc);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Importaciones))
			return false;
		Importaciones other = (Importaciones) obj;
		if (cantidad == null) {
			if (other.cantidad != null)
				return false;
		} else if (!cantidad.equals(other.cantidad))
			return false;
		if (Double.doubleToLongBits(codigo) != Double.doubleToLongBits(other.codigo))
			return false;
		if (consec != other.consec)
			return false;
		if (costoim == null) {
			if (other.costoim != null)
				return false;
		} else if (!costoim.equals(other.costoim))
			return false;
		if (costojm == null) {
			if (other.costojm != null)
				return false;
		} else if (!costojm.equals(other.costojm))
			return false;
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equals(other.documento))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (Double.doubleToLongBits(ndoc) != Double.doubleToLongBits(other.ndoc))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Importaciones [consec=" + consec + ", fecha=" + fecha + ", codigo=" + codigo + ", ndoc=" + ndoc
				+ ", cantidad=" + cantidad + ", costojm=" + costojm + ", costoim=" + costoim + ", documento="
				+ documento + ", precio=" + precio + "]";
	}   
}
