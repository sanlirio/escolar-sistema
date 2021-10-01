package com.escolar.system.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.escolar.system.domain.Cargo;

public class CargoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotEmpty(message = "O campo NOME é requerido")
	private String nome;

	public CargoDTO() {
		super();

	}

	public CargoDTO(Cargo objCar) {
		super();
		this.id = objCar.getId();
		this.nome = objCar.getNome();
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
