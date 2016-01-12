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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@XmlRootElement
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(nullable = false, precision = 22)
    private Long codigo;
    @Column(length = 35)
    private String referencia;
    @Column(length = 15)
    private String uso;
    @Column(length = 18)
    private String modelo1;
    @Column(length = 18)
    private String modelo2;
    @Column(length = 18)
    private String modelo3;
    @Column(length = 11)
    private String marca;
    @Column(precision = 22)
    private Double precio;
    @Column(precision = 22)
    private Double cantdisp;
    @Column(length = 17)
    private String procedenc;
    @Column(precision = 22)
    private Double ultcostpr;
    @Column(precision = 22)
    private Double costprom;
    @Column(precision = 22)
    private Double ultcostjm;
    @Column(precision = 22)
    private Double costjm;
    @Column(precision = 22)
    private Double ultcomp;
    @Column(precision = 22)
    private Double cosultcom;
    @Column(precision = 22)
    private Double invimppas;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecsaldado;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecultimp;
    @Column(precision = 22)
    private Double invimpante;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecanteimp;
    @Column(precision = 22)
    private Double costpromim;
    @Column(precision = 22)
    private Double ultcosproi;
    @Column(length = 1)
    private String modif;
    @Column(length = 30)
    private String refcorta;
    @Column(length = 50)
    private String refvendedor;
    @Column(length = 50)
    private String modelvendedor;

    public Articulo() {
    }

    public Articulo(Long codigo) {
        this.codigo = codigo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public String getModelo1() {
        return modelo1;
    }

    public void setModelo1(String modelo1) {
        this.modelo1 = modelo1;
    }

    public String getModelo2() {
        return modelo2;
    }

    public void setModelo2(String modelo2) {
        this.modelo2 = modelo2;
    }

    public String getModelo3() {
        return modelo3;
    }

    public void setModelo3(String modelo3) {
        this.modelo3 = modelo3;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getCantdisp() {
        return cantdisp;
    }

    public void setCantdisp(Double cantdisp) {
        this.cantdisp = cantdisp;
    }

    public String getProcedenc() {
        return procedenc;
    }

    public void setProcedenc(String procedenc) {
        this.procedenc = procedenc;
    }

    public Double getUltcostpr() {
        return ultcostpr;
    }

    public void setUltcostpr(Double ultcostpr) {
        this.ultcostpr = ultcostpr;
    }

    public Double getCostprom() {
        return costprom;
    }

    public void setCostprom(Double costprom) {
        this.costprom = costprom;
    }

    public Double getUltcostjm() {
        return ultcostjm;
    }

    public void setUltcostjm(Double ultcostjm) {
        this.ultcostjm = ultcostjm;
    }

    public Double getCostjm() {
        return costjm;
    }

    public void setCostjm(Double costjm) {
        this.costjm = costjm;
    }

    public Double getUltcomp() {
        return ultcomp;
    }

    public void setUltcomp(Double ultcomp) {
        this.ultcomp = ultcomp;
    }

    public Double getCosultcom() {
        return cosultcom;
    }

    public void setCosultcom(Double cosultcom) {
        this.cosultcom = cosultcom;
    }

    public Double getInvimppas() {
        return invimppas;
    }

    public void setInvimppas(Double invimppas) {
        this.invimppas = invimppas;
    }

    public Date getFecsaldado() {
        return fecsaldado;
    }

    public void setFecsaldado(Date fecsaldado) {
        this.fecsaldado = fecsaldado;
    }

    public Date getFecultimp() {
        return fecultimp;
    }

    public void setFecultimp(Date fecultimp) {
        this.fecultimp = fecultimp;
    }

    public Double getInvimpante() {
        return invimpante;
    }

    public void setInvimpante(Double invimpante) {
        this.invimpante = invimpante;
    }

    public Date getFecanteimp() {
        return fecanteimp;
    }

    public void setFecanteimp(Date fecanteimp) {
        this.fecanteimp = fecanteimp;
    }

    public Double getCostpromim() {
        return costpromim;
    }

    public void setCostpromim(Double costpromim) {
        this.costpromim = costpromim;
    }

    public Double getUltcosproi() {
        return ultcosproi;
    }

    public void setUltcosproi(Double ultcosproi) {
        this.ultcosproi = ultcosproi;
    }

    public String getModif() {
        return modif;
    }

    public void setModif(String modif) {
        this.modif = modif;
    }

    public String getRefcorta() {
        return refcorta;
    }

    public void setRefcorta(String refcorta) {
        this.refcorta = refcorta;
    }

    public String getRefvendedor() {
        return refvendedor;
    }

    public void setRefvendedor(String refvendedor) {
        this.refvendedor = refvendedor;
    }

    public String getModelvendedor() {
        return modelvendedor;
    }

    public void setModelvendedor(String modelvendedor) {
        this.modelvendedor = modelvendedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Articulo)) {
            return false;
        }
        Articulo other = (Articulo) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Articulo[ codigo=" + codigo + " ]";
    }
    
}
