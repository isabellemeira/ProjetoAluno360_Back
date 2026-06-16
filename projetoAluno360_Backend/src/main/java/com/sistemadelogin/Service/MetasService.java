package com.sistemadelogin.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemadelogin.Entity.Metas;
import com.sistemadelogin.Repository.MetasRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MetasService {
	
	private final MetasRepository repository;
	
	public Metas cadastrar(Metas metas) {
		return repository.save(metas);
		
	}
	
	public List<Metas> listar() {
		return repository.findAll();
	}
	public Metas buscarPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Metas não encontradas")); 
	}
	public Metas atualizar(Long id, Metas metas) {
		
		Metas metaExistente = buscarPorId(id);
		
		metaExistente.setDescricao(metas.getDescricao());
		metaExistente.setPrazo(metas.getPrazo());
		metaExistente.setProgresso(metas.getProgresso());
		metaExistente.setStatus(metas.getStatus());
		metaExistente.setTitulo(metas.getTitulo());
		
		return repository.save(metaExistente);
	}
	public void deletar (Long id) {
		Metas metas = buscarPorId(id);
		
		repository.delete(metas);
	}

}
