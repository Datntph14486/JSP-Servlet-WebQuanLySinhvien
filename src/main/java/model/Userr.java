package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Table
@Entity
public class Userr {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String userName;
	@Column
	private String name;
	@Column
	private String password;
	@Column
	private AccountRole role;
	public Userr() {
		super();
	}
	public Userr(Long id, String userName, String name, String password, AccountRole role) {
		super();
		this.id = id;
		this.userName = userName;
		this.name = name;
		this.password = password;
		this.role = role;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AccountRole getRole() {
		return role;
	}
	public void setRole(AccountRole role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Userr [id=" + id + ", userName=" + userName + ", name=" + name + ", password=" + password + ", role="
				+ role + "]";
	}
	
	
	

}
