package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.annotation.JsonIgnore;
/**
* Entidad Usuario
* Clase encargada de reprentar los usuarios
*
* @author  David Calle
* @version 1.0
* @since   2015-12-14
*/
@Entity
public class Usuario {
	
	/**
     * Nombre de usuario, debe ser único en la base de datos
     */
	@Column(unique = true)
	private String username;
	/**
     * contraseña, no enviada al serializar 
     */
	@JsonIgnore
	private String password;
	/**
     * identificador autoincrementar del usuario
     */
	@Id
	@GeneratedValue
	private Long id;
	
	/**
     * Rol del usuario en la aplicación
     */
	@ManyToOne(	fetch = FetchType.EAGER )
	private Rol role;
	
	
	@ManyToOne(	fetch = FetchType.EAGER )
	private Empresa empresa;
	
	
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Rol getRole() {
		return role;
	}

	public void setRole(Rol role) {
		this.role = role;
	}

	
	
	public Usuario(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public Usuario() {
		super();
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Account [username=" + username + ", password=" + password + ", id=" + id + " role=" +  role.getRole()+"]";
	}
	
	
}
