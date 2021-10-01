package com.escolar.system.domain.enums;

public enum Sexo {

	MASCULINO(0,"MASCULINO"),
	FEMININO(1,"FEMININO");
	
	private Integer cod;
	private String descricao;
	
	
	private Sexo(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}


	public Integer getCod() {
		return cod;
	}


	public String getDescricao() {
		return descricao;
	}
	
	public static Sexo toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(Sexo x : Sexo.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Sexo invalida" + cod);
	}
	
}
