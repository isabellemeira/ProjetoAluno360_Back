package com.sistemadelogin.Service;

import org.springframework.stereotype.Service;

import com.sistemadelogin.Entity.Usuario;
import com.sistemadelogin.Repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	private final UsuarioRepository repository;

	public Usuario usuarioLogado;

	public String cadastrar(Usuario usuario) {

		Usuario usuarioExistente = repository.findByLogin(usuario.getLogin());

		if (usuarioExistente != null) {
			return "Email já cadastrado";

		}
		repository.save(usuario);

		return "Usuário cadastrado";

	}

	public String login(Usuario usuario) {

		Usuario usuarioBanco = repository.findByLogin(usuario.getLogin());
		if (usuarioBanco == null) {
			return "Usuário não encontrado";
		}
		if (!usuarioBanco.getSenha().equals(usuario.getSenha())) {
			return "Senha incorreta";
		}
		usuarioLogado = usuarioBanco;

		return "Login realizado";
	}

	public Usuario logado() {
		return usuarioLogado;
	}

	
}

