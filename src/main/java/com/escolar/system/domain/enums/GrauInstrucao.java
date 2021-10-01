package com.escolar.system.domain.enums;

public enum GrauInstrucao {

	ANALFABETO(0,"ANALFABETO"),
	ALFABETIZADO(1,"ALFABETIZADO"),
	ENSINO_FUNDAMENTAL_INCOMPLETO(2,"ENSINO FUNDAMENTAL INCOMPLETO"),
	ENSINO_FUNDAMENTAL_COMPLETO(3,"ENSINO FUNDAMENTAL COMPLETO"),
	ENSINO_MEDIO_INCOMPLETO(4,"ENSION MEDIO INCOMPLETO"),
	ENSINO_MEDIO_COMPLETO(5,"ENSION MEDIO COMPLETO"),
	SUPERIOR_COMPLETO(6,"SUPERIOR COMPLETO"),
	MESTRADO(7,"MESTRADO");
	
	private Integer cod;
	private String descricao;
	
	
	private GrauInstrucao(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
public static GrauInstrucao toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(GrauInstrucao x : GrauInstrucao.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Grau de Instrucao invalido" + cod);
	}
	
}
