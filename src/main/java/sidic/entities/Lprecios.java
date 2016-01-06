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
@Table(name = "lprecios")
@XmlRootElement
public class Lprecios implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CODPRE")
    private Double codpre;
    @Column(name = "NOMPRE")
    private String nompre;
    @Column(name = "MOD1PRE")
    private String mod1pre;
    @Column(name = "MOD2PRE")
    private String mod2pre;
    @Column(name = "MOD3PRE")
    private String mod3pre;
    @Column(name = "REFPRE")
    private String refpre;
    @Column(name = "USOPRE")
    private String usopre;
    @Column(name = "MARPRE")
    private String marpre;
    @Column(name = "PROCPRE")
    private String procpre;
    @Column(name = "CANTPRE")
    private Double cantpre;
    @Column(name = "PREPRE")
    private Double prepre;
    @Column(name = "ASTPRE")
    private String astpre;
    @Column(name = "CODVPRE")
    private Double codvpre;
    @Column(name = "TIPART")
    private String tipart;
    @Column(name = "LINEA")
    private Double linea;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Lprecios() {
    }

    public Lprecios(Integer id) {
        this.id = id;
    }

    public Double getCodpre() {
        return codpre;
    }

    public void setCodpre(Double codpre) {
        this.codpre = codpre;
    }

    public String getNompre() {
        return nompre;
    }

    public void setNompre(String nompre) {
        this.nompre = nompre;
    }

    public String getMod1pre() {
        return mod1pre;
    }

    public void setMod1pre(String mod1pre) {
        this.mod1pre = mod1pre;
    }

    public String getMod2pre() {
        return mod2pre;
    }

    public void setMod2pre(String mod2pre) {
        this.mod2pre = mod2pre;
    }

    public String getMod3pre() {
        return mod3pre;
    }

    public void setMod3pre(String mod3pre) {
        this.mod3pre = mod3pre;
    }

    public String getRefpre() {
        return refpre;
    }

    public void setRefpre(String refpre) {
        this.refpre = refpre;
    }

    public String getUsopre() {
        return usopre;
    }

    public void setUsopre(String usopre) {
        this.usopre = usopre;
    }

    public String getMarpre() {
        return marpre;
    }

    public void setMarpre(String marpre) {
        this.marpre = marpre;
    }

    public String getProcpre() {
        return procpre;
    }

    public void setProcpre(String procpre) {
        this.procpre = procpre;
    }

    public Double getCantpre() {
        return cantpre;
    }

    public void setCantpre(Double cantpre) {
        this.cantpre = cantpre;
    }

    public Double getPrepre() {
        return prepre;
    }

    public void setPrepre(Double prepre) {
        this.prepre = prepre;
    }

    public String getAstpre() {
        return astpre;
    }

    public void setAstpre(String astpre) {
        this.astpre = astpre;
    }

    public Double getCodvpre() {
        return codvpre;
    }

    public void setCodvpre(Double codvpre) {
        this.codvpre = codvpre;
    }

    public String getTipart() {
        return tipart;
    }

    public void setTipart(String tipart) {
        this.tipart = tipart;
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
        if (!(object instanceof Lprecios)) {
            return false;
        }
        Lprecios other = (Lprecios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Lprecios[ id=" + id + " ]";
    }
    
}
