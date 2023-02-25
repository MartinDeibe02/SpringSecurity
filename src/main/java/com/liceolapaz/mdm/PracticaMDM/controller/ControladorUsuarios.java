package com.liceolapaz.mdm.PracticaMDM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liceolapaz.mdm.PracticaMDM.model.Usuarios;
import com.liceolapaz.mdm.PracticaMDM.service.UsuariosServiceImpl;

@Controller
public class ControladorUsuarios {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UsuariosServiceImpl usersService;
	
	
	@GetMapping("/signup")
	public String register(Usuarios usuario, Model model) {
		model.addAttribute("usuario", new Usuarios());
		return "signup";
	}
	
	@GetMapping("/bcrypt/{value}")
	@ResponseBody
	public String bCrypt(@PathVariable("value") String value) {
		
		String pass = passwordEncoder.encode(value);
		return pass;
	}
	
	@PostMapping("/saveUser")
	public String saveUser(Usuarios usuario) {
		
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		usuario.setEnabled(true);
		System.out.println(usuario);
		
		usersService.save(usuario);
		
		return "redirect:/login";
	}
}
