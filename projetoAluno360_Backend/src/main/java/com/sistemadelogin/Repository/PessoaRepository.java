package com.sistemadelogin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemadelogin.Entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
