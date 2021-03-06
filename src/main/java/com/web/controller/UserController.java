package com.web.controller;


import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.repository.IUserRepository;
import com.web.repository.IVisitanteRepository;

import com.web.util.SendMailService;

import com.web.entities.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller

public class UserController {
    
	@Autowired
	IUserRepository userRepo;
	
	@Autowired
	IVisitanteRepository visitRepo;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	SendMailService sendMailService;
	
	@GetMapping({"/","/login"})
    public String inicio() {
        return "login";
    }
	
	@GetMapping({"/iniciar"})
    public String iniciarSesion() {
        return "login";
    }
	
	@GetMapping(path= {"/get_register"})
	public String getRegister() {
		return "register_user";
	}
	
	
	
	@GetMapping("/home")
	public String login() {
		
		return "home";
	}
	@GetMapping("/logout")
	public String logout() {
		
		return "login";
	}
	
	@PostMapping("/register")
	public String register_user(@RequestParam  String username, String email, String password, String service ,Model model) {
		
	
		Usuario user = new Usuario();
        user.setEmpresa((service.equalsIgnoreCase("UFPS")) ? 1:2);
        user.setEmail(email);
        user.setPassword(encoder.encode(password));
        user.setUsuario(username);
        user.setRol(1);
		Usuario retorno = userRepo.save(user);
		model.addAttribute("username",retorno.getUsuario());
		 //String asunto = "Se ha registrado correctamente a nuestra plataforma"; 
	        //String mensaje = "Bienvenido: "+user.getUsuario()+",\nEs un placer recibirlo en nuestra plataforma, disfrute de nuestros servicios";
	       // sendMailService.sendMail("movierecordshd@gmail.com", user.getEmail(), asunto, mensaje);
		
	
		
		return "home";
	}
	
	@GetMapping("/list_users")
	public String list_my_users(Model model) {
		model.addAttribute("users", userRepo.findAll());
		return "list";
	}
	
	@GetMapping("/list_visit")
	public String list_my_visits(Model model) {
		model.addAttribute("visit", visitRepo.findAll());
		return "list";
	}
	
	
}
