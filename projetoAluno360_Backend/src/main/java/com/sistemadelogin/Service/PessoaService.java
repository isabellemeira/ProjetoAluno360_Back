package com.sistemadelogin.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemadelogin.Entity.Pessoa;
import com.sistemadelogin.Repository.PessoaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PessoaService {

	private final PessoaRepository repository;
	
	public Pessoa cadastrar(Pessoa pessoa) {
		return repository.save(pessoa);
	}
	public List<Pessoa> listar(){
		return repository.findAll();
		
	}
	public Pessoa buscarPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Pessoa não encontrado"));
	}
	public Pessoa atualizar(Long id, Pessoa pessoa) {
		
		Pessoa pessoaExistente = buscarPorId(id);
		
		pessoaExistente.setNome(pessoa.getNome());
		pessoaExistente.setEmail(pessoa.getEmail());
		pessoaExistente.setCpf(pessoa.getCpf());
		pessoaExistente.setTelefone(pessoa.getTelefone());
		pessoaExistente.setTurma(pessoa.getTurma());
		
		
		return repository.save(pessoaExistente);
		
	}
	
	public void deletar(Long id) {
		Pessoa pessoa = buscarPorId(id);
		
		repository.delete(pessoa);
	}
}

