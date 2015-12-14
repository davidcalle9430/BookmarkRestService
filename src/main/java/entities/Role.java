package entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Role {
	
	@Id
	private String role;
	@OneToMany(mappedBy="role", cascade = {CascadeType.PERSIST}, orphanRemoval = true)
	private Set<Account> accounts;
	
	public Role(String role){
		this.role = role;
	}
	public Role(){
		
	}

	public Set<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(Set<Account> accounts) {
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
