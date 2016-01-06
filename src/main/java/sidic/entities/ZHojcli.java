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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "z_hojcli")
@XmlRootElement
public class ZHojcli implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CODIGO")
    private Double codigo;
    @Column(name = "RAZSOC")
    private String razsoc;
    @Column(name = "fec")
    private String fec;
    @Column(name = "PRODUCTOS")
    private String productos;
    @Column(name = "C")
    private String c;
    @Column(name = "30")
    private String a;
    @Column(name = "VALOR")
    private Double valor;
    @Column(name = "fct")
    private Double fct;
    @Column(name = "tipf")
    private String tipf;
    @Column(name = "NOTAD")
    private Double notad;
    @Column(name = "NOTAC")
    private Double notac;
    @Column(name = "OBSERVAC")
    private String observac;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public ZHojcli() {
    }

    public ZHojcli(Integer id) {
        this.id = id;
    }

    public Double getCodigo() {
        return codigo;
    }

    public void setCodigo(Double codigo) {
        this.codigo = codigo;
    }

    public String getRazsoc() {
        return razsoc;
    }

    public void setRazsoc(String razsoc) {
        this.razsoc = razsoc;
    }

    public String getFec() {
        return fec;
    }

    public void setFec(String fec) {
        this.fec = fec;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
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

    public Double getNotad() {
        return notad;
    }

    public void setNotad(Double notad) {
        this.notad = notad;
    }

    public Double getNotac() {
        return notac;
    }

    public void setNotac(Double notac) {
        this.notac = notac;
    }

    public String getObservac() {
        return observac;
    }

    public void setObservac(String observac) {
        this.observac = observac;
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
        if (!(object instanceof ZHojcli)) {
            return false;
        }
        ZHojcli other = (ZHojcli) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.ZHojcli[ id=" + id + " ]";
    }
    
}
