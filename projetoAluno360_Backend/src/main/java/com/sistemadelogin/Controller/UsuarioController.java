package com.sistemadelogin.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemadelogin.Entity.Usuario;
import com.sistemadelogin.Service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UsuarioController {

	private final UsuarioService service;

	@PostMapping("/cadastrar")
	public String cadastrar(@RequestBody Usuario usuario) {

		return service.cadastrar(usuario);

	}

	@PostMapping("/login")
	public String login(@RequestBody Usuario usuario) {

		return service.login(usuario);
	}

	@GetMapping("/logado")
	public Usuario logado() {
		return service.logado();
	}

}

