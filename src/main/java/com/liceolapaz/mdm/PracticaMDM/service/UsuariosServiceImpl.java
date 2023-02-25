package com.liceolapaz.mdm.PracticaMDM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liceolapaz.mdm.PracticaMDM.model.Usuarios;
import com.liceolapaz.mdm.PracticaMDM.repository.UsuariosRepository;

@Service
public class UsuariosServiceImpl implements IUsersService{

	@Autowired
	UsuariosRepository usersRepo;
	
	@Override
	public Usuarios findByUser(String user) {
		return usersRepo.findByUsername(user);
	}

	@Override
	public void save(Usuarios user) {
		usersRepo.save(user);
	}

}
