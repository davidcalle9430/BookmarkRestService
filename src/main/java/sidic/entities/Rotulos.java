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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "rotulos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rotulos.findAll", query = "SELECT r FROM Rotulos r"),
    @NamedQuery(name = "Rotulos.findByNota", query = "SELECT r FROM Rotulos r WHERE r.nota = :nota"),
    @NamedQuery(name = "Rotulos.findByRazsoc", query = "SELECT r FROM Rotulos r WHERE r.razsoc = :razsoc"),
    @NamedQuery(name = "Rotulos.findByDireccion", query = "SELECT r FROM Rotulos r WHERE r.direccion = :direccion"),
    @NamedQuery(name = "Rotulos.findByCiudad", query = "SELECT r FROM Rotulos r WHERE r.ciudad = :ciudad"),
    @NamedQuery(name = "Rotulos.findById", query = "SELECT r FROM Rotulos r WHERE r.id = :id")})
public class Rotulos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "nota")
    private String nota;
    @Column(name = "RAZSOC")
    private String razsoc;
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "CIUDAD")
    private String ciudad;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Rotulos() {
    }

    public Rotulos(Integer id) {
        this.id = id;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getRazsoc() {
        return razsoc;
    }

    public void setRazsoc(String razsoc) {
        this.razsoc = razsoc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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
        if (!(object instanceof Rotulos)) {
            return false;
        }
        Rotulos other = (Rotulos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Rotulos[ id=" + id + " ]";
    }
    
}
