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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "t_new")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TNew.findAll", query = "SELECT t FROM TNew t"),
    @NamedQuery(name = "TNew.findByCodigo", query = "SELECT t FROM TNew t WHERE t.codigo = :codigo"),
    @NamedQuery(name = "TNew.findByTipo", query = "SELECT t FROM TNew t WHERE t.tipo = :tipo"),
    @NamedQuery(name = "TNew.findByVendedor", query = "SELECT t FROM TNew t WHERE t.vendedor = :vendedor"),
    @NamedQuery(name = "TNew.findByNombre", query = "SELECT t FROM TNew t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TNew.findByFecha", query = "SELECT t FROM TNew t WHERE t.fecha = :fecha"),
    @NamedQuery(name = "TNew.findByFechapago", query = "SELECT t FROM TNew t WHERE t.fechapago = :fechapago"),
    @NamedQuery(name = "TNew.findBySubtot", query = "SELECT t FROM TNew t WHERE t.subtot = :subtot"),
    @NamedQuery(name = "TNew.findByTipopago", query = "SELECT t FROM TNew t WHERE t.tipopago = :tipopago"),
    @NamedQuery(name = "TNew.findByFct", query = "SELECT t FROM TNew t WHERE t.fct = :fct"),
    @NamedQuery(name = "TNew.findByTipf", query = "SELECT t FROM TNew t WHERE t.tipf = :tipf"),
    @NamedQuery(name = "TNew.findByLinea", query = "SELECT t FROM TNew t WHERE t.linea = :linea"),
    @NamedQuery(name = "TNew.findById", query = "SELECT t FROM TNew t WHERE t.id = :id")})
public class TNew implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CODIGO")
    private Double codigo;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "VENDEDOR")
    private String vendedor;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "FECHAPAGO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechapago;
    @Column(name = "SUBTOT")
    private Double subtot;
    @Column(name = "tipopago")
    private String tipopago;
    @Column(name = "fct")
    private Double fct;
    @Column(name = "tipf")
    private String tipf;
    @Column(name = "LINEA")
    private Double linea;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public TNew() {
    }

    public TNew(Integer id) {
        this.id = id;
    }

    public Double getCodigo() {
        return codigo;
    }

    public void setCodigo(Double codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechapago() {
        return fechapago;
    }

    public void setFechapago(Date fechapago) {
        this.fechapago = fechapago;
    }

    public Double getSubtot() {
        return subtot;
    }

    public void setSubtot(Double subtot) {
        this.subtot = subtot;
    }

    public String getTipopago() {
        return tipopago;
    }

    public void setTipopago(String tipopago) {
        this.tipopago = tipopago;
    }

    public Double getFct() {
        return fct;
    }

    public void setFct(Double fct) {
        this.fct = fct;
    }

    public String getTipf() {
        return tipf;
    }

    public void setTipf(String tipf) {
        this.tipf = tipf;
    }

    public Double getLinea() {
        return linea;
    }

    public void setLinea(Double linea) {
        this.linea = linea;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof TNew)) {
            return false;
        }
        TNew other = (TNew) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.TNew[ id=" + id + " ]";
    }
    
}
