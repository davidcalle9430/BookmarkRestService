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
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase que representa un cliente especial
 * @author david
 */
@IdClass(EspeciaPK.class)
@Entity
@XmlRootElement
public class Especia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, name="CODIGO")
    private Long codigo;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Long articulo; // el anterior ingeniero no hizo una relación directa en la bd
    @Column(length = 35)
    private String referencia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 22)
    private Double precio;
    @JoinColumn(name = "CODIGO", referencedColumnName = "CODIGO", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Clientes clientes;

    public Especia() {
    }
    

    public Especia(Long codigo, Long articulo) {
		super();
		this.codigo = codigo;
		this.articulo = articulo;
	}


	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	public Long getArticulo() {
		return articulo;
	}


	public void setArticulo(Long articulo) {
		this.articulo = articulo;
	}


	public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
   
    }
    

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((articulo == null) ? 0 : articulo.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Especia other = (Especia) obj;
		if (articulo == null) {
			if (other.articulo != null)
				return false;
		} else if (!articulo.equals(other.articulo))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
    
    
}
    
