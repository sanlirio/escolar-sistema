package com.escolar.system.domain.enums;

public enum Estado {

	AC(0,"Acre"), 
	AL(1,"Alagoas"),
	AM(2,"Amazonas"),
	BA(3,"Bahia"),
	CE(4,"Ceará"),
	DF(5,"Distrito Federal"),
	ES(6,"Espírito Santo"),
	GO(7,"Goiás"),
	MA(8,"Maranhão"),
	MT(9,"Mato Grosso"),
	MS(10,"Mato Grosso do Sul"),
	MG(11,"Minas Gerais"),
	PA(12,"Pará"),
	PB(13,"Paraíba"),
	PR(14,"Paraná"),
	PE(15,"Pernambuco"),
	PI(16,"Piauí"),
	RJ(17,"Rio de Janeiro"),
	RN(18,"Rio Grande do Norte"),
	RS(19,"Rio Grande do Sul"),
	RO(20,"Rondônia"),
	RR(21,"Roraima"),
	SC(22,"Santa Catarina"),
	SP(23,"São Paulo"),
	SE(24,"Sergipe"),
	TO(25,"Tocantins");
	
	private Integer cod;
	private String descricao;
	
	
	private Estado(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}


	public Integer getCod() {
		return cod;
	}


	public String getDescricao() {
		return descricao;
	}
	
	public static Estado toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(Estado x : Estado.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Estado invalida" + cod);
	}
}
