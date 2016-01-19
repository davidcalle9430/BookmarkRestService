/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidic.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author david
 */
@Embeddable
public class UsuariosPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(nullable = false,name="Empresa")
    private Integer empresa;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String usuario;

    public UsuariosPK() {
    }

    public UsuariosPK(Integer empresa, String usuario) {
        this.empresa = empresa;
        this.usuario = usuario;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Integer empresa) {
        this.empresa = empresa;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

 
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		System.out.println( "hash code " + result);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("eguals");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuariosPK other = (UsuariosPK) obj;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		
		
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	@Override
    public String toString() {
        return "sidic.entities.UsuariosPK[ empresa=" + empresa + ", usuario=" + usuario + " ]";
    }
    
}
