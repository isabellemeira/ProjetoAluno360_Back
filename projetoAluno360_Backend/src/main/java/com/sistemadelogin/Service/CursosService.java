package com.sistemadelogin.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemadelogin.Entity.Cursos;
import com.sistemadelogin.Repository.CursosRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CursosService {
	
	private final CursosRepository repository;
	
	public Cursos cadastrar(Cursos cursos) {
		return repository.save(cursos);
		
	}
	public List<Cursos> listar() {
		return repository.findAll();
	}
	public Cursos buscarPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Cursos não encontrados"));
	}
	public Cursos atualizar(Long id, Cursos cursos) {
		
		Cursos cursoExistente = buscarPorId(id);
		
		cursoExistente.setNome(cursos.getNome());
		cursoExistente.setInstituicao(cursos.getInstituicao());
		cursoExistente.setArea(cursos.getArea());
		cursoExistente.setCargaHoraria(cursos.getCargaHoraria());
		cursoExistente.setNivel(cursos.getNivel());
		cursoExistente.setStatus(cursos.getStatus());
		
		return repository.save(cursoExistente);
	}
	public void deletar (Long id) {
		Cursos cursos = buscarPorId(id);
		
		repository.delete(cursos);
	}

}
