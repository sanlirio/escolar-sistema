package com.escolar.system.domain.enums;

public enum Alergia {
	
	SIM(0,"SIM"),
	NAO(1,"NAO");
	
	private Integer cod;
	private String descricao;
	
	
	private Alergia(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}


	public Integer getCod() {
		return cod;
	}


	public String getDescricao() {
		return descricao;
	}
	
	public static Alergia toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(Alergia x : Alergia.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Alergia invalida" + cod);
	}
	
}
