package com.escolar.system.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToMany;

import com.escolar.system.domain.Disciplina;
import com.escolar.system.domain.Funcionario;
import com.escolar.system.domain.Matricula;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class DisciplinaDTO  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	
	//@JsonIgnore
	@ManyToMany(mappedBy = "disciplinas")
	private List<Funcionario> funcionarios = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany(mappedBy = "disciplinas")
	private List<Matricula> matriculas = new ArrayList<>();
	
	public DisciplinaDTO() {
		super();
	
	}

	public DisciplinaDTO(Disciplina objDis) {
		super();
		this.id = objDis.getId();
		this.nome = objDis.getNome();
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

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	
	
}
