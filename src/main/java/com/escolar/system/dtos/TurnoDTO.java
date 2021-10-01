package com.escolar.system.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToMany;

import com.escolar.system.domain.Funcionario;
import com.escolar.system.domain.Turno;

public class TurnoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;

	@ManyToMany(mappedBy = "turnos")
	private List<Funcionario> funcionarios = new ArrayList<>();

	public TurnoDTO() {
		super();

	}

	public TurnoDTO(Turno objTurn) {
		super();
		this.id = objTurn.getId();
		this.nome = objTurn.getNome();
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

}
