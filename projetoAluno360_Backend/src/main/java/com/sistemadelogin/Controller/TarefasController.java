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

import com.sistemadelogin.Entity.Tarefas;
import com.sistemadelogin.Service.TarefasService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TarefasController {
	
	private final TarefasService service;
	
	@PostMapping
	public Tarefas cadastrar(@RequestBody Tarefas tarefas ) {
		return service.cadastrar(tarefas);
		
	}
	@GetMapping 
	public List<Tarefas> listar() {
		return service.listar();
		
	}
	@GetMapping("/{id}")
	public Tarefas buscarPorId(@PathVariable Long id ) {
		return service.buscarPorId(id);
	}
	@PutMapping("{id}")
	public Tarefas atualizar(
			@PathVariable Long id,
			@RequestBody Tarefas tarefas) {
		
		return service.atualizar(id, tarefas);
		
	}
	@DeleteMapping("{id}")
	public String deletar(@PathVariable Long id) {
		service.deletar(id);
		
		return "Tarefa deletada com sucesso";
	}
	

}
