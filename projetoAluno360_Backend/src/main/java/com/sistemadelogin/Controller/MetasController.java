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

import com.sistemadelogin.Entity.Metas;
import com.sistemadelogin.Service.MetasService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/metas")
@RequiredArgsConstructor
@CrossOrigin("*")
public class MetasController {
	
	private final MetasService service;
	
	@PostMapping
	public Metas cadastrar(@RequestBody Metas metas) {
		return service.cadastrar(metas);
	}
	@GetMapping
	public List<Metas> listar() {
		return service.listar();
	}
	@GetMapping("/{id}")
	public Metas buscarPorId(@PathVariable Long id) {
		return service.buscarPorId(id);
	}
	@PutMapping("{id}")
	public Metas atualizar(
			@PathVariable Long id,
			@RequestBody Metas metas) {
		return service.atualizar(id, metas);
		
	}
	@DeleteMapping("{id}")
	public String deletar(@PathVariable Long id) {
		service.deletar(id);
		
		return "Metas deletadas com sucesso";
	}

}
