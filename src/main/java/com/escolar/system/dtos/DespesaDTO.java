package com.escolar.system.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.escolar.system.domain.Despesa;

public class DespesaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotEmpty(message = "O campo NOME DA DESPESA é requerido")
	private String nome;

	public DespesaDTO() {
		super();

	}

	public DespesaDTO(Despesa objDes) {
		super();
		this.id = objDes.getId();
		this.nome = objDes.getNome();

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

}
