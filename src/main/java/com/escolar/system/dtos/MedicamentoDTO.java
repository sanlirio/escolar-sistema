package com.escolar.system.dtos;

import java.io.Serializable;

import com.escolar.system.domain.Medicamento;

public class MedicamentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String tipoMedicamento;

	public MedicamentoDTO() {
		super();

	}

	public MedicamentoDTO(Medicamento objMed) {
		super();
		this.id = objMed.getId();
		this.tipoMedicamento = objMed.getTipoMedicamento();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoMedicamento() {
		return tipoMedicamento;
	}

	public void setTipoMedicamento(String tipoMedicamento) {
		this.tipoMedicamento = tipoMedicamento;
	}

}
