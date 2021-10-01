package com.escolar.system.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.escolar.system.domain.Receita;

public class ReceitaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotEmpty(message = "O campo NOME DA RECEITA é requerido")
	private String nome;
	
	public ReceitaDTO() {
		super();
	
	}

	public ReceitaDTO(Receita objRec) {
		super();
		this.id = objRec.getId();
		this.nome = objRec.getNome();
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
