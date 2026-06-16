package com.sistemadelogin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemadelogin.Entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByLogin(String login);
}