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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "a_505")
@XmlRootElement
public class A505 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private Double codigo;
    @Column(name = "REFERENCIA")
    private String referencia;
    @Column(name = "USO")
    private String uso;
    @Column(name = "MODELO1")
    private String modelo1;
    @Column(name = "MODELO2")
    private String modelo2;
    @Column(name = "MODELO3")
    private String modelo3;
    @Column(name = "MARCA")
    private String marca;
    @Column(name = "PRECIO")
    private Double precio;
    @Column(name = "CANTDISP")
    private Double cantdisp;
    @Column(name = "PROCEDENC")
    private String procedenc;
    @Column(name = "ULTCOSTPR")
    private Double ultcostpr;
    @Column(name = "COSTPROM")
    private Double costprom;
    @Column(name = "ULTCOSTJM")
    private Double ultcostjm;
    @Column(name = "COSTJM")
    private Double costjm;
    @Column(name = "ULTCOMP")
    private Double ultcomp;
    @Column(name = "COSULTCOM")
    private Double cosultcom;
    @Column(name = "INVIMPPAS")
    private Double invimppas;
    @Column(name = "FECSALDADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecsaldado;
    @Column(name = "FECULTIMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecultimp;
    @Column(name = "INVIMPANTE")
    private Double invimpante;
    @Column(name = "FECANTEIMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecanteimp;
    @Column(name = "COSTPROMIM")
    private Double costpromim;
    @Column(name = "ULTCOSPROI")
    private Double ultcosproi;
    @Column(name = "MODIF")
    private String modif;
    @Column(name = "REFCORTA")
    private String refcorta;
    @Column(name = "REFVENDEDOR")
    private String refvendedor;
    @Column(name = "MODELVENDEDOR")
    private String modelvendedor;

    public A505() {
    }

    public A505(Double codigo) {
        this.codigo = codigo;
    }

    public Double getCodigo() {
        return codigo;
    }

    public void setCodigo(Double codigo) {
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof A505)) {
            return false;
        }
        A505 other = (A505) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.A505[ codigo=" + codigo + " ]";
    }
    
}
