package com.liceolapaz.mdm.PracticaMDM.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Users")
public class Usuarios {
	@Id
	private String username;
	private String password;
	private boolean enabled;
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
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "Usuarios [username=" + username + ", password=" + password + ", enabled=" + enabled + "]";
	}
	
	
}
