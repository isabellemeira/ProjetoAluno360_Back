package com.sistemadelogin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemadelogin.Entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> { 

}
