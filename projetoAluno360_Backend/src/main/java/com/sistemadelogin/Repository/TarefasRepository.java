package com.sistemadelogin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemadelogin.Entity.Tarefas;

public interface TarefasRepository extends JpaRepository<Tarefas, Long> {

}
