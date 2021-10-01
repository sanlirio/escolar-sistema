package com.escolar.system.dtos;

import java.io.Serializable;

import com.escolar.system.domain.Turma;

public class TurmaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String curso;

	public TurmaDTO() {
		super();

	}

	public TurmaDTO(Turma objTurm) {
		super();
		this.id = objTurm.getId();
		this.nome = objTurm.getNome();
		this.curso = objTurm.getCurso();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

}
