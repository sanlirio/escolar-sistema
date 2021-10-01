package com.escolar.system.domain.enums;

public enum EstadoCivil {

	SOLTEIRO(0,"SOLTEIRO"),
	CASADO(1,"CASADO"),
	VIUVO(2,"VIUVO(A)"),
	DIVORCIADO(3,"DIVORCIADO(A)");
	
	private Integer cod;
	private String descricao;
	
	
	private EstadoCivil(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}


	public Integer getCod() {
		return cod;
	}


	public String getDescricao() {
		return descricao;
	}
	
	public static EstadoCivil toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(EstadoCivil x : EstadoCivil.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Estado Civil invalida" + cod);
	}
	
}
