package com.sistemadelogin.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemadelogin.Entity.Eventos;
import com.sistemadelogin.Service.EventosService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/eventos")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EventosController {
	
	private final EventosService service;
	
	@PostMapping
	public Eventos cadastrar(@RequestBody Eventos eventos) {
		return service.cadastrar(eventos);
	}
	@GetMapping
	public List<Eventos> listar() {
		return service.listar();
	}
	@GetMapping("{id}")
	public Eventos buscarPorId(@PathVariable Long id) {
		return service.buscarPorId(id);
	}
	@PutMapping("{id}")
	public Eventos atualizar(
			@PathVariable Long id,
			@RequestBody Eventos eventos) {
		return service.atualizar(id, eventos);
	}
	@DeleteMapping("{id}")
	public String deletar(@PathVariable Long id) {
		service.deletar(id);
		
		return "Eventos deletados com sucesso";
	}

}
