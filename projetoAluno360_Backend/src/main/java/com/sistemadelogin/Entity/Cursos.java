package com.sistemadelogin.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Cursos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cursoId;

    private String nome;
    private String instituicao;
    private String area;
    private double cargaHoraria;
    private int nivel;
    private String status;

    @ManyToMany(mappedBy = "cursos")
    private List<Aluno> alunos;
}
