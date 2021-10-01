package com.escolar.system.domain.enums;

public enum DeficienciaFisica {

	SIM(0,"SIM"),
	NAO(1,"NAO");
	
	private Integer cod;
	private String descricao;
	
	
	private DeficienciaFisica(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}


	public Integer getCod() {
		return cod;
	}


	public String getDescricao() {
		return descricao;
	}
	
	public static DeficienciaFisica toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(DeficienciaFisica x : DeficienciaFisica.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Resultado invalido" + cod);
	}
	
}
