/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidic.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author david
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByEmpresa", query = "SELECT u FROM Usuarios u WHERE u.usuariosPK.empresa = :empresa"),
    @NamedQuery(name = "Usuarios.findByUsuario", query = "SELECT u FROM Usuarios u WHERE u.usuariosPK.usuario = :usuario"),
    @NamedQuery(name = "Usuarios.findByNivel", query = "SELECT u FROM Usuarios u WHERE u.nivel = :nivel"),
    @NamedQuery(name = "Usuarios.findByActivado", query = "SELECT u FROM Usuarios u WHERE u.activado = :activado"),
    @NamedQuery(name = "Usuarios.findByMaxdias", query = "SELECT u FROM Usuarios u WHERE u.maxdias = :maxdias"),
    @NamedQuery(name = "Usuarios.findByDiasalerta", query = "SELECT u FROM Usuarios u WHERE u.diasalerta = :diasalerta"),
    @NamedQuery(name = "Usuarios.findByIndicadorNuevo", query = "SELECT u FROM Usuarios u WHERE u.indicadorNuevo = :indicadorNuevo"),
    @NamedQuery(name = "Usuarios.findByPassword", query = "SELECT u FROM Usuarios u WHERE u.password = :password"),
    @NamedQuery(name = "Usuarios.findByFechapassword", query = "SELECT u FROM Usuarios u WHERE u.fechapassword = :fechapassword"),
    @NamedQuery(name = "Usuarios.findByFecha", query = "SELECT u FROM Usuarios u WHERE u.fecha = :fecha")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuariosPK usuariosPK;
    private Integer nivel;
    private Integer activado;
    private Integer maxdias;
    private Integer diasalerta;
    @Column(name = "indicador_nuevo")
    private Integer indicadorNuevo;
    //	@JsonIgnore
    @Column(length = 12)
    private String password;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechapassword;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JsonIgnore
    @JoinColumn(name = "Empresa", referencedColumnName = "Empresa", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empresas empresas;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios")
    private List<Opciones> opcionesList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios")
    private List<Menus> menusList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios")
    private List<Niveles> nivelesList;

    public Usuarios() {
    }

    public Usuarios(UsuariosPK usuariosPK) {
        this.usuariosPK = usuariosPK;
    }

    public Usuarios(int empresa, String usuario) {
        this.usuariosPK = new UsuariosPK(empresa, usuario);
    }

    public UsuariosPK getUsuariosPK() {
        return usuariosPK;
    }

    public void setUsuariosPK(UsuariosPK usuariosPK) {
        this.usuariosPK = usuariosPK;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getActivado() {
        return activado;
    }

    public void setActivado(Integer activado) {
        this.activado = activado;
    }

    public Integer getMaxdias() {
        return maxdias;
    }

    public void setMaxdias(Integer maxdias) {
        this.maxdias = maxdias;
    }

    public Integer getDiasalerta() {
        return diasalerta;
    }

    public void setDiasalerta(Integer diasalerta) {
        this.diasalerta = diasalerta;
    }

    public Integer getIndicadorNuevo() {
        return indicadorNuevo;
    }

    public void setIndicadorNuevo(Integer indicadorNuevo) {
        this.indicadorNuevo = indicadorNuevo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFechapassword() {
        return fechapassword;
    }

    public void setFechapassword(Date fechapassword) {
        this.fechapassword = fechapassword;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Empresas getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }

    @XmlTransient
    public List<Opciones> getOpcionesList() {
        return opcionesList;
    }

    public void setOpcionesList(List<Opciones> opcionesList) {
        this.opcionesList = opcionesList;
    }

    @XmlTransient
    public List<Menus> getMenusList() {
        return menusList;
    }

    public void setMenusList(List<Menus> menusList) {
        this.menusList = menusList;
    }

    @XmlTransient
    public List<Niveles> getNivelesList() {
        return nivelesList;
    }

    public void setNivelesList(List<Niveles> nivelesList) {
        this.nivelesList = nivelesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuariosPK != null ? usuariosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.usuariosPK == null && other.usuariosPK != null) || (this.usuariosPK != null && !this.usuariosPK.equals(other.usuariosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Usuarios[ usuariosPK=" + usuariosPK + " ]";
    }
    
}
