package com.escolar.system.domain.enums;

public enum PosGraduacao {

	SIM(0,"SIM"),
	NAO(1,"NAO");
	
	private Integer cod;
	private String descricao;
	
	
	private PosGraduacao(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}


	public Integer getCod() {
		return cod;
	}


	public String getDescricao() {
		return descricao;
	}
	
	public static PosGraduacao toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(PosGraduacao x : PosGraduacao.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("PosGraduacao invalida" + cod);
	}
	
}
