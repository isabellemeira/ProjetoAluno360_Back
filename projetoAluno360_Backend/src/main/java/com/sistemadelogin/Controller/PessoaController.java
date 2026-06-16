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

import com.sistemadelogin.Entity.Pessoa;
import com.sistemadelogin.Service.PessoaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pessoas")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PessoaController {

	private final PessoaService service;
	
	@PostMapping
	public Pessoa cadastrar(@RequestBody Pessoa pessoa) {
		return service.cadastrar(pessoa);
		
	}
	
	@GetMapping
	public List<Pessoa> listar() {
		return service.listar();
	}
	@GetMapping("/{id}")
	public Pessoa buscarPorId(@PathVariable Long id) {
		return service.buscarPorId(id);
		
	}
	@PutMapping("/{id}")
	public Pessoa atualizar(
			@PathVariable Long id,
			@RequestBody Pessoa pessoa) {
		
		return service.atualizar(id, pessoa);
	}
	@DeleteMapping("{id}")
	public String deletar(@PathVariable Long id) {
		service.deletar(id);
		
		return "Pessoa deletada com sucesso";
	}
	
}

