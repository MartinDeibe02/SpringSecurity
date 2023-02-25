package com.liceolapaz.mdm.PracticaMDM.controller;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.liceolapaz.mdm.PracticaMDM.model.Usuarios;


public class Authorities {
	private Usuarios username;
	
	private String authority;

	public Usuarios getUsername() {
		return username;
	}

	public void setUsername(Usuarios username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
}
