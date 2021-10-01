package com.escolar.system.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.escolar.system.domain.Cidade;

public class CidadeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotEmpty(message = "O campo NOME DA CIDADE é requerido")
	private String nome;
	private Integer estado;

	public CidadeDTO() {
		super();

	}

	public CidadeDTO(Cidade objCid) {
		super();
		this.id = objCid.getId();
		this.nome = objCid.getNome();
		this.estado = objCid.getEstado().getCod();
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

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

}
