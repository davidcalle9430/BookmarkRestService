/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidic.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
    @NamedQuery(name = "Importaciones.findAll", query = "SELECT i FROM Importaciones i"),
    @NamedQuery(name = "Importaciones.findByConsec", query = "SELECT i FROM Importaciones i WHERE i.importacionesPK.consec = :consec"),
    @NamedQuery(name = "Importaciones.findByFecha", query = "SELECT i FROM Importaciones i WHERE i.importacionesPK.fecha = :fecha"),
    @NamedQuery(name = "Importaciones.findByCodigo", query = "SELECT i FROM Importaciones i WHERE i.importacionesPK.codigo = :codigo"),
    @NamedQuery(name = "Importaciones.findByCantidad", query = "SELECT i FROM Importaciones i WHERE i.cantidad = :cantidad"),
    @NamedQuery(name = "Importaciones.findByCostojm", query = "SELECT i FROM Importaciones i WHERE i.costojm = :costojm"),
    @NamedQuery(name = "Importaciones.findByCostoim", query = "SELECT i FROM Importaciones i WHERE i.costoim = :costoim"),
    @NamedQuery(name = "Importaciones.findByDocumento", query = "SELECT i FROM Importaciones i WHERE i.documento = :documento"),
    @NamedQuery(name = "Importaciones.findByNdoc", query = "SELECT i FROM Importaciones i WHERE i.importacionesPK.ndoc = :ndoc"),
    @NamedQuery(name = "Importaciones.findByPrecio", query = "SELECT i FROM Importaciones i WHERE i.precio = :precio")})
public class Importaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ImportacionesPK importacionesPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
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

    public Importaciones(ImportacionesPK importacionesPK) {
        this.importacionesPK = importacionesPK;
    }

    public Importaciones(int consec, Date fecha, double codigo, double ndoc) {
        this.importacionesPK = new ImportacionesPK(consec, fecha, codigo, ndoc);
    }

    public ImportacionesPK getImportacionesPK() {
        return importacionesPK;
    }

    public void setImportacionesPK(ImportacionesPK importacionesPK) {
        this.importacionesPK = importacionesPK;
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
        int hash = 0;
        hash += (importacionesPK != null ? importacionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Importaciones)) {
            return false;
        }
        Importaciones other = (Importaciones) object;
        if ((this.importacionesPK == null && other.importacionesPK != null) || (this.importacionesPK != null && !this.importacionesPK.equals(other.importacionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Importaciones[ importacionesPK=" + importacionesPK + " ]";
    }
    
}
