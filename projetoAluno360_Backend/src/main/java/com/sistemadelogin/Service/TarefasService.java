package com.sistemadelogin.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemadelogin.Entity.Tarefas;
import com.sistemadelogin.Repository.TarefasRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TarefasService {
	
	private final TarefasRepository repository;
	
	public Tarefas cadastrar(Tarefas tarefas) {
		return repository.save(tarefas);
	}
	public List<Tarefas> listar() {
		return repository.findAll();
	}
	public Tarefas buscarPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
	}
	public Tarefas atualizar(Long id, Tarefas tarefas) {
		
		Tarefas tarefaExistente = buscarPorId(id);
		
		tarefaExistente.setTitulo(tarefas.getTitulo());
		tarefaExistente.setDescricao(tarefas.getDescricao());
		tarefaExistente.setMateria(tarefas.getMateria());
		tarefaExistente.setDataEntrega(tarefas.getDataEntrega());
		tarefaExistente.setPrioridade(tarefas.getPrioridade());
		tarefaExistente.setStatus(tarefas.getStatus());
		tarefaExistente.setTitulo(tarefas.getTitulo());
		
		return repository.save(tarefaExistente);
	}
	public void deletar(Long id) {
		Tarefas tarefas = buscarPorId(id);
		
		repository.delete(tarefas);
	}

}
