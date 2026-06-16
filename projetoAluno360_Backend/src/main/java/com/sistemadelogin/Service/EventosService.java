package com.sistemadelogin.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemadelogin.Entity.Eventos;
import com.sistemadelogin.Repository.EventosRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventosService {
	
	private final EventosRepository repository;
	
	public Eventos cadastrar(Eventos eventos) {
		return repository.save(eventos);
	}
	public List<Eventos> listar() {
		return repository.findAll();
	}
	public Eventos buscarPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Eventos não encontrados"));
	}
	public Eventos atualizar(Long id, Eventos eventos) {
		
		Eventos eventoExistente = buscarPorId(id);
		
		eventoExistente.setData(eventos.getData());
		eventoExistente.setDescricao(eventos.getDescricao());
		eventoExistente.setHorario(eventos.getHorario());
		eventoExistente.setLocal(eventos.getLocal());;
		eventoExistente.setNome(eventos.getNome());
		eventoExistente.setTipo(eventos.getTipo());
		
		return repository.save(eventoExistente);
	}
	public void deletar (Long id) {
		Eventos eventos = buscarPorId(id);
		
		repository.delete(eventos);
	}

}
