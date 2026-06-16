package com.sistemadelogin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemadelogin.Entity.Eventos;

public interface EventosRepository extends JpaRepository<Eventos, Long> {

}
