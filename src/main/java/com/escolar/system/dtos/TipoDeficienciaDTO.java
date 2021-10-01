package com.escolar.system.dtos;

import java.io.Serializable;

import com.escolar.system.domain.TipoDeficiencia;

public class TipoDeficienciaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String tipoDeficiencia;

	public TipoDeficienciaDTO() {
		super();

	}

	public TipoDeficienciaDTO(TipoDeficiencia objDef) {
		super();
		this.id = objDef.getId();
		this.tipoDeficiencia = objDef.getTipoDeficiencia();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoDeficiencia() {
		return tipoDeficiencia;
	}

	public void setTipoDeficiencia(String tipoDeficiencia) {
		this.tipoDeficiencia = tipoDeficiencia;
	}

}
