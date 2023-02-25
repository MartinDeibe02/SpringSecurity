package com.liceolapaz.mdm.PracticaMDM.service;

import com.liceolapaz.mdm.PracticaMDM.model.Usuarios;

public interface IUsersService {
	Usuarios findByUser(String user);
	void save(Usuarios user);
}
