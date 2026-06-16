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

import com.sistemadelogin.Entity.Hobbies;
import com.sistemadelogin.Service.HobbiesService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/hobbies")
@RequiredArgsConstructor
@CrossOrigin("*")
public class HobbiesController {
	
	private final HobbiesService service;
	
	@PostMapping
	public Hobbies cadastrar(@RequestBody Hobbies hobbies) {
		return service.cadastrar(hobbies);
	}
	@GetMapping
	public List<Hobbies> listar() {
		return service.listar();
	}
	@GetMapping("{id}")
	public Hobbies buscarPorId(@PathVariable Long id) {
		return service.buscarPorId(id);
	}
	@PutMapping("{id}")
	public Hobbies atualizar(
			@PathVariable Long id,
			@RequestBody Hobbies hobbies) {
		return service.atualizar(id, hobbies);
	}
	@DeleteMapping("{id}")
	public String deletar(@PathVariable Long id) {
		service.deletar(id);
		
		return "Hobbies deletados com sucesso";
	}

}