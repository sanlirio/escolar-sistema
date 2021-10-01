package com.escolar.system.domain.enums;

public enum TipoSanguinio {

	A_POSITIVO(0,"A+"),
	B_POSITIVO(1,"B+"),
	AB_POSITIVO(2,"AB+"),
	O_POSITIVO(3,"O+"),
	A_NEGATIVO(4,"A-"),
	B_NEGATIVO(5,"B-"),
	AB_NEGATIVO(6,"AB-"),
	O_NEGATIVO(7,"O-");
	
	private Integer cod;
	private String descricao;
	
	
	private TipoSanguinio(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}


	public Integer getCod() {
		return cod;
	}


	public String getDescricao() {
		return descricao;
	}
	
	public static TipoSanguinio toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(TipoSanguinio x : TipoSanguinio.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Tipo Sanguinio invalido" + cod);
	}
	
}
