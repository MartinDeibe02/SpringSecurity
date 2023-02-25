package com.liceolapaz.mdm.PracticaMDM.service;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liceolapaz.mdm.PracticaMDM.model.Authorities;
import com.liceolapaz.mdm.PracticaMDM.repository.AuthoritiesRepository;

@Service
public class AuthoritiesService implements IAuthoritiesService{

	@Autowired
	AuthoritiesRepository authRepo;
	
	@Override
	public void save(Authorities auth) {
		authRepo.save(auth);
	}

}
