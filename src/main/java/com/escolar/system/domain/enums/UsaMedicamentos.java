package com.escolar.system.domain.enums;

public enum UsaMedicamentos {

	SIM(0,"SIM"),
	NAO(1,"NAO");
	
	private Integer cod;
	private String descricao;
	
	
	private UsaMedicamentos(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}


	public Integer getCod() {
		return cod;
	}


	public String getDescricao() {
		return descricao;
	}
	
	public static UsaMedicamentos toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(UsaMedicamentos x : UsaMedicamentos.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Resultado invalido" + cod);
	}
	
}
