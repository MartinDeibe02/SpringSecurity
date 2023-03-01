package com.liceolapaz.mdm.PracticaMDM.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liceolapaz.mdm.PracticaMDM.model.Authorities;
import com.liceolapaz.mdm.PracticaMDM.model.Usuarios;
import com.liceolapaz.mdm.PracticaMDM.service.AuthoritiesService;
import com.liceolapaz.mdm.PracticaMDM.service.UsuariosServiceImpl;

@Controller
public class ControladorUsuarios {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UsuariosServiceImpl usersService;
	
	@Autowired
	private AuthoritiesService authService;
	
	
	@GetMapping("/signup")
	public String register(Usuarios usuario, Model model) {
		model.addAttribute("usuario", new Usuarios());
		return "signup";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.logout(request, null, null);
		return "redirect:/login";
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
		
		Authorities auth = new Authorities();
		auth.setUsername(usuario.getUsername());
		auth.setAuthority("USUARIO");
		
		usersService.save(usuario);
		authService.save(auth);

		return "redirect:/login";
	}
}
