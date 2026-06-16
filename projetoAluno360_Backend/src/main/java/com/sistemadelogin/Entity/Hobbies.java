package com.sistemadelogin.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Hobbies {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String categoria;
	
	private String plataforma;
	
	private int tempoSemanal;
	
	private int nivelHabilidade;
	
	private String status;
	
	

}
