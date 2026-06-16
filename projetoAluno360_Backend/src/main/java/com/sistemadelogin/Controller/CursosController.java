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

import com.sistemadelogin.Entity.Cursos;
import com.sistemadelogin.Service.CursosService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CursosController {
	
	private final CursosService service;
	
	@PostMapping
	public Cursos cadastrar(@RequestBody Cursos cursos) {
		return service.cadastrar(cursos);
	}
	@GetMapping
	public List<Cursos> listar() {
		return service.listar();
	}
	@GetMapping("{id}")
	public Cursos buscarPorId(@PathVariable Long id) {
		return service.buscarPorId(id);
	}
	@PutMapping("{id}")
	public Cursos atualizar(
			@PathVariable Long id,
			@RequestBody Cursos cursos) {
		return service.atualizar(id, cursos);
	}
	@DeleteMapping("{id}")
	public String deletar(@PathVariable Long id) {
		service.deletar(id);
		
		return "Cursos deletados com sucesso";
	}

}
