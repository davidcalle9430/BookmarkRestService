/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidic.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author david
 */
@Entity
@Table(name="cliente")
@XmlRootElement
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(nullable = false, precision = 22)
    private Long codigo;
    @Column(length = 70)
    private String razsoc;
    @Column(length = 70)
    private String direccion;
    @Column(length = 30)
    private String telefono;
    @Column(length = 25)
    private String proptario;
    @Column(length = 25)
    private String gerente;
    @Column(length = 14)
    private String nit;
    @Column(length = 14)
    private String cc;
    @Column(length = 35)
    private String pedidos;
    @Column(length = 35)
    private String cobros;
    @Column(length = 15)
    private String cupo;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaing;
    @Column(length = 1)
    private String rotulo;
    @Column(length = 1)
    private String camref;
    @Column(length = 1)
    private String ica;
    @Column(precision = 22)
    private Double porcica;
    @Column(length = 1)
    private String activo;
    @Column(length = 1)
    private String consigna;
    @Column(length = 50)
    private String nombre1;
    @Column(length = 50)
    private String nombre2;
    @Column(length = 50)
    private String apellido1;
    @Column(length = 50)
    private String apellido2;
    @Column(length = 1)
    private String sucursales;
    @Column(name = "NIT_N", precision = 22)
    private Double nitN;
    @Column(name = "DIGITOV_NIT")
    private Integer digitovNit;
    private Integer idvendedor;
    @Column(length = 1)
    private String nuevo;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodif;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientes")
    private List<Especia> especiaList;
    @JoinColumn(name = "CIUDAD", referencedColumnName = "CODIGO")
    @ManyToOne
    private Ciudades ciudad;
    @JoinColumn(name = "CODCORR", referencedColumnName = "CODIGO")
    @ManyToOne
    private Correr codcorr;
    @JoinColumn(name = "LINEA", referencedColumnName = "LINEA")
    @ManyToOne
    private Lineas linea;
    @JoinColumn(name = "VENDEDOR", referencedColumnName = "CODIGO")
    @ManyToOne
    private Vendedor vendedor;
    @JoinColumn(name = "ZONA", referencedColumnName = "ZONA")
    @ManyToOne
    private Zonas zona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientes")
    private List<Cartera> carteraList;

    public Clientes() {
    }

    public Clientes(Long codigo) {
        this.codigo = codigo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getProptario() {
        return proptario;
    }

    public void setProptario(String proptario) {
        this.proptario = proptario;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getPedidos() {
        return pedidos;
    }

    public void setPedidos(String pedidos) {
        this.pedidos = pedidos;
    }

    public String getCobros() {
        return cobros;
    }

    public void setCobros(String cobros) {
        this.cobros = cobros;
    }

    public String getCupo() {
        return cupo;
    }

    public void setCupo(String cupo) {
        this.cupo = cupo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaing() {
        return fechaing;
    }

    public void setFechaing(Date fechaing) {
        this.fechaing = fechaing;
    }

    public String getRotulo() {
        return rotulo;
    }

    public void setRotulo(String rotulo) {
        this.rotulo = rotulo;
    }

    public String getCamref() {
        return camref;
    }

    public void setCamref(String camref) {
        this.camref = camref;
    }

    public String getIca() {
        return ica;
    }

    public void setIca(String ica) {
        this.ica = ica;
    }

    public Double getPorcica() {
        return porcica;
    }

    public void setPorcica(Double porcica) {
        this.porcica = porcica;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getConsigna() {
        return consigna;
    }

    public void setConsigna(String consigna) {
        this.consigna = consigna;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getSucursales() {
        return sucursales;
    }

    public void setSucursales(String sucursales) {
        this.sucursales = sucursales;
    }

    public Double getNitN() {
        return nitN;
    }

    public void setNitN(Double nitN) {
        this.nitN = nitN;
    }

    public Integer getDigitovNit() {
        return digitovNit;
    }

    public void setDigitovNit(Integer digitovNit) {
        this.digitovNit = digitovNit;
    }

    public Integer getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(Integer idvendedor) {
        this.idvendedor = idvendedor;
    }

    public String getNuevo() {
        return nuevo;
    }

    public void setNuevo(String nuevo) {
        this.nuevo = nuevo;
    }

    public Date getFechamodif() {
        return fechamodif;
    }

    public void setFechamodif(Date fechamodif) {
        this.fechamodif = fechamodif;
    }

    @XmlTransient
    public List<Especia> getEspeciaList() {
        return especiaList;
    }

    public void setEspeciaList(List<Especia> especiaList) {
        this.especiaList = especiaList;
    }

    public Ciudades getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudades ciudad) {
        this.ciudad = ciudad;
    }

    public Correr getCodcorr() {
        return codcorr;
    }

    public void setCodcorr(Correr codcorr) {
        this.codcorr = codcorr;
    }

    public Lineas getLinea() {
        return linea;
    }

    public void setLinea(Lineas linea) {
        this.linea = linea;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Zonas getZona() {
        return zona;
    }

    public void setZona(Zonas zona) {
        this.zona = zona;
    }

    @XmlTransient
    public List<Cartera> getCarteraList() {
        return carteraList;
    }

    public void setCarteraList(List<Cartera> carteraList) {
        this.carteraList = carteraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sidic.entities.Clientes[ codigo=" + codigo + " ]";
    }
    
}
