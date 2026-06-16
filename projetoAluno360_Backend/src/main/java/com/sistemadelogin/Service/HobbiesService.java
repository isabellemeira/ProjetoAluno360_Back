package com.sistemadelogin.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemadelogin.Entity.Hobbies;
import com.sistemadelogin.Repository.HobbiesRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HobbiesService {
	
	private final HobbiesRepository repository;
	
	public Hobbies cadastrar(Hobbies Hobbies) {
		return repository.save(Hobbies);
		
	}
	
	public List<Hobbies> listar() {
		return repository.findAll();
	}
	public Hobbies buscarPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Hobbies não encontrados")); 
	}
	public Hobbies atualizar(Long id, Hobbies hobbies) {
		
		Hobbies hobbieExistente = buscarPorId(id);
		
		hobbieExistente.setCategoria(hobbies.getCategoria());
		hobbieExistente.setNivelHabilidade(hobbies.getNivelHabilidade());
		hobbieExistente.setNome(hobbies.getNome());
		hobbieExistente.setPlataforma(hobbies.getPlataforma());
		hobbieExistente.setStatus(hobbies.getStatus());
		hobbieExistente.setTempoSemanal(hobbies.getTempoSemanal());
		
		return repository.save(hobbieExistente);
	}
	public void deletar (Long id) {
		Hobbies hobbies = buscarPorId(id);
		
		repository.delete(hobbies);
	}

}

