package com.liceolapaz.mdm.PracticaMDM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liceolapaz.mdm.PracticaMDM.model.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, String> {
	Usuarios findByUsername(String user);
}
