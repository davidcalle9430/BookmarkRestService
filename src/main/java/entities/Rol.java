package entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/**
* Entidad Rol
* Clase encargada de reprentar los roles
*
* @author  David Calle
* @version 1.0
* @since   2015-12-14
*/
@Entity
public class Rol {
	/**
     * Rol, nombre del rol único e identificador
     */
	@Id
	private String role;
	
	/**
     * Conjunto de cuenta que le pertenecen a ese rol
     */
	@OneToMany(mappedBy="role", cascade = {CascadeType.PERSIST}, orphanRemoval = true)
	private Set<Usuario> accounts;
	
	public Rol(String role){
		this.role = role;
	}
	public Rol(){
		
	}

	public Set<Usuario> getAccounts() {
		return accounts;
	}
	public void setAccounts(Set<Usuario> accounts) {
		this.accounts = accounts;
	}
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return role;
	}
	
	
}
