package com.sistemadelogin.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemadelogin.Entity.Aluno;
import com.sistemadelogin.Repository.AlunoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlunoService {

	private final AlunoRepository repository;
	
	public Aluno cadastrar(Aluno aluno) {
		return repository.save(aluno);
	}
	public List<Aluno> listar(){
		return repository.findAll();
		
	}
	public Aluno buscarPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
	}
	public Aluno atualizar(Long id, Aluno aluno) {
		
		Aluno alunoExistente = buscarPorId(id);
		
		alunoExistente.setNome(aluno.getNome());
		alunoExistente.setIdade(aluno.getIdade());
		alunoExistente.setEmail(aluno.getEmail());
		alunoExistente.setTelefone(aluno.getTelefone());
		alunoExistente.setTurma(aluno.getTurma());
		alunoExistente.setStatus(aluno.getStatus());
		
		return repository.save(alunoExistente);
		
	}
	
	public void deletar(Long id) {
		Aluno aluno = buscarPorId(id);
		
		repository.delete(aluno);
	}
}
