package com.escolar.system.dtos;

import java.io.Serializable;

import com.escolar.system.domain.TipoAlergia;

public class TipoAlergiaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String tipoAlergia;

	public TipoAlergiaDTO() {
		super();

	}

	public TipoAlergiaDTO(TipoAlergia objTAl) {
		super();
		this.id = objTAl.getId();
		this.tipoAlergia = objTAl.getTipoAlergia();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoAlergia() {
		return tipoAlergia;
	}

	public void setTipoAlergia(String tipoAlergia) {
		this.tipoAlergia = tipoAlergia;
	}

}
