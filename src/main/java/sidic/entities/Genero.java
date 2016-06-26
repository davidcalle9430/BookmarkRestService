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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@XmlRootElement
public class Genero implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    private Long codigo;
    
    @Column(length = 35)
    private String nombre;
    
    @Column(precision = 22)
    private Double ultcod;
    
    @Column(precision = 22)
    private Double cantdisp;
    
    @Column(precision = 22)
    private Double cantdispjm;
    
    @Column(precision = 22)
    private Double cantdispf;
    
    @Column(precision = 22)
    private Double porcprec;
    
    @Column(precision = 22)
    private Double costprom;
    
    @Column(length = 22)
    private String nombrei;
    
    @Column(length = 1)
    private String tipart;
    
    @Column(length = 1)
    private String iva;

    public Genero() {
    }

    public Genero(Long codigo) {
        this.codigo = codigo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getUltcod() {
        return ultcod;
    }

    public void setUltcod(Double ultcod) {
        this.ultcod = ultcod;
    }

    public Double getCantdisp() {
        return cantdisp;
    }

    public void setCantdisp(Double cantdisp) {
        this.cantdisp = cantdisp;
    }

    public Double getCantdispjm() {
        return cantdispjm;
    }

    public void setCantdispjm(Double cantdispjm) {
        this.cantdispjm = cantdispjm;
    }

    public Double getCantdispf() {
        return cantdispf;
    }

    public void setCantdispf(Double cantdispf) {
        this.cantdispf = cantdispf;
    }

    public Double getPorcprec() {
        return porcprec;
    }

    public void setPorcprec(Double porcprec) {
        this.porcprec = porcprec;
    }

    public Double getCostprom() {
        return costprom;
    }

    public void setCostprom(Double costprom) {
        this.costprom = costprom;
    }

    public String getNombrei() {
        return nombrei;
    }

    public void setNombrei(String nombrei) {
        this.nombrei = nombrei;
    }

    public String getTipart() {
        return tipart;
    }

    public void setTipart(String tipart) {
        this.tipart = tipart;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
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
        if (!(object instanceof Genero)) {
            return false;
        }
        Genero other = (Genero) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Genero [codigo=" + codigo + ", nombre=" + nombre + ", ultcod=" + ultcod + ", cantdisp=" + cantdisp
				+ ", cantdispjm=" + cantdispjm + ", cantdispf=" + cantdispf + ", porcprec=" + porcprec + ", costprom="
				+ costprom + ", nombrei=" + nombrei + ", tipart=" + tipart + ", iva=" + iva + "]";
	}
    
}
