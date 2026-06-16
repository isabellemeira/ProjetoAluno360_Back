package com.sistemadelogin.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemadelogin.Entity.Conquistas;
import com.sistemadelogin.Repository.ConquistasRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConquistaService {
	
	private final ConquistasRepository repository;
	
	public Conquistas cadastrar(Conquistas Conquistas) {
		return repository.save(Conquistas);
	}
	public List<Conquistas> listar() {
		return repository.findAll();
	}
	public Conquistas buscarPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Cadastro não efetuado"));
	}
	public Conquistas atualizar(Long id, Conquistas Conquistas) {
		
		Conquistas cadastroExistente = buscarPorId(id);
		
		cadastroExistente.setCategoria(Conquistas.getCategoria());
		cadastroExistente.setDataConquista(Conquistas.getDataConquista());
		cadastroExistente.setDescricao(Conquistas.getDescricao());
		cadastroExistente.setNivel(Conquistas.getNivel());
		cadastroExistente.setPontuacao(Conquistas.getPontuacao());
		cadastroExistente.setTitulo(Conquistas.getTitulo());
		
		return repository.save(cadastroExistente);
	}
	public void deletar(Long id) {
		Conquistas Conquistas = buscarPorId(id);
		
		repository.delete(Conquistas);
	}

}

