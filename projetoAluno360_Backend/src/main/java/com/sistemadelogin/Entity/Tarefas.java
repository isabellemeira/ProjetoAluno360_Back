package com.sistemadelogin.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Tarefas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	
	private String titulo;
	
	private String descricao;
	
	private String materia;
	
	private LocalDate dataEntrega;
	
	private String prioridade;
	
	private String status;
}
