package entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Account {
	@Column(unique = true)
	private String username;
	@JsonIgnore
	private String password;
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne(	fetch = FetchType.EAGER )
	private Role role;
	
	
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@OneToMany(mappedBy="account", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private Set<Bookmark> bookmarks;
	
	
	public Account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public Account() {
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
	public Set<Bookmark> getBookmarks() {
		return bookmarks;
	}
	public void setBookmarks(Set<Bookmark> bookmarks) {
		this.bookmarks = bookmarks;
	}

	@Override
	public String toString() {
		return "Account [username=" + username + ", password=" + password + ", id=" + id + " role=" +  role.getRole()+"]";
	}
	
	
}
